package br.com.gestao_horario_aulas.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gestao_horario_aulas.model.Grade;
import br.com.gestao_horario_aulas.util.Util;

/**
 * Servlet implementation class InserirSalasController
 */
@WebServlet("/telas/coordenador/inserirGrade")
public class InserirGradeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InserirGradeController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String curso = request.getParameter("curso");
		String semestre = request.getParameter("semestre");
		if (Util.isEmptyOrNull(curso) || Util.isEmptyOrNull(semestre)) {
			request.setAttribute("mensagem", "Todos os dados são obrigatórios para inserir um professor");
			request.getRequestDispatcher("./grade.jsp").forward(request, response);
			return;
		}
		Grade grade = new Grade(semestre, curso);
		// TODO Inserir Grade e mensagem de inserir
		response.sendRedirect("./listaGrades.jsp");
	}

}
