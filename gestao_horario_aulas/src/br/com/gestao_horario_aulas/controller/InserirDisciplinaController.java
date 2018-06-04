package br.com.gestao_horario_aulas.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gestao_horario_aulas.dao.DisciplinaDao;
import br.com.gestao_horario_aulas.model.Curso;
import br.com.gestao_horario_aulas.model.Disciplina;
import br.com.gestao_horario_aulas.util.Util;

/**
 * Servlet implementation class InserirSalasController
 */
@WebServlet("/telas/coordenador/inserirDisciplina")
public class InserirDisciplinaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InserirDisciplinaController() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		DisciplinaDao disciplinad = new DisciplinaDao();
		disciplinad.delete(Integer.parseInt(id));
		resp.sendRedirect("./listaDisciplinas.jsp");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nome = request.getParameter("nome");
		String idCurso = request.getParameter("curso");
		String semestre = request.getParameter("semestre");
		if (Util.isEmptyOrNull(nome) || Util.isEmptyOrNull(idCurso) || Util.isEmptyOrNull(semestre)) {
			request.setAttribute("mensagem", "Todos os dados são obrigatórios para inserir uma disciplina");
			request.getRequestDispatcher("./disciplina.jsp").forward(request, response);
			return;
		}
		DisciplinaDao disciplinad = new DisciplinaDao();
		Curso c = new Curso();
		c.setId(Integer.parseInt(idCurso));
		disciplinad.insert(new Disciplina(nome, Integer.parseInt(semestre), c ));
		// TODO Inserir disciplina e mensagem de inseri
		response.sendRedirect("./listaDisciplinas.jsp");
	}

}
