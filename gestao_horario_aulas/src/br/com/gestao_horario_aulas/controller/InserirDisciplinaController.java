package br.com.gestao_horario_aulas.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gestao_horario_aulas.model.Disciplina;
import br.com.gestao_horario_aulas.model.Sala;
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
		Disciplina disciplina = new Disciplina(nome, Integer.parseInt(semestre), Integer.parseInt(idCurso));
		// TODO Inserir disciplina e mensagem de inseri
		response.sendRedirect("./listaDisciplinas.jsp");
	}

}
