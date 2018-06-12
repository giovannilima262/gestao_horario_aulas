package br.com.gestao_horario_aulas.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gestao_horario_aulas.dao.ProfessorDao;
import br.com.gestao_horario_aulas.model.Professor;
import br.com.gestao_horario_aulas.util.Util;

/**
 * Servlet implementation class InserirSalasController
 */
@WebServlet("/telas/coordenador/inserirProfessor")
public class InserirProfessorController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProfessorDao professorDao = new ProfessorDao();
	private List<Professor> professores = new ArrayList<>();

	public InserirProfessorController() {
		professores = professorDao.getLista();
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		try{
			professorDao.delete(Integer.parseInt(id));
		}catch (SQLException e) {
			req.setAttribute("mensagemErro", "Não é possivel deletar");
			req.getRequestDispatcher("./listaProfessores.jsp").forward(req, resp);
		}

		resp.sendRedirect("./listaProfessores.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nome = request.getParameter("nome");
		String cpf = request.getParameter("cpf");
		if (Util.isEmptyOrNull(nome) || Util.isEmptyOrNull(cpf)) {
			request.setAttribute("mensagem", "Todos os dados são obrigatórios para inserir um professor");
			request.getRequestDispatcher("./professor.jsp").forward(request, response);
			return;
		}
		professorDao.insert(new Professor(nome, cpf));
		response.sendRedirect("./listaProfessores.jsp");
	}

	public List<Professor> getProfessores() {
		return professores;
	}

	public void setProfessores(List<Professor> professores) {
		this.professores = professores;
	}
}
