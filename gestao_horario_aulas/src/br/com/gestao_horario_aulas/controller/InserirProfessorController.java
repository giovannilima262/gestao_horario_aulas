package br.com.gestao_horario_aulas.controller;

import java.io.IOException;

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

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InserirProfessorController() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = req.getParameter("id");
		ProfessorDao professord = new ProfessorDao();
		professord.delete(Integer.parseInt(id));
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
		ProfessorDao professord = new ProfessorDao();
		professord.insert(new Professor(nome, cpf));
		// TODO Inserir professor e mensagem de inserir
		response.sendRedirect("./listaProfessores.jsp");
	}
}
