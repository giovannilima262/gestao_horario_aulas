package br.com.gestao_horario_aulas.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gestao_horario_aulas.model.Disciplina;
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

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nome = request.getParameter("nome");
		String cpf = request.getParameter("cpf");
		if (Util.isEmptyOrNull(nome) || Util.isEmptyOrNull(cpf)) {
			request.setAttribute("mensagem", "Todos os dados são obrigatórios para inserir um professor");
			request.getRequestDispatcher("./disciplina.jsp").forward(request, response);
			return;
		}
		Professor disciplina = new Professor(nome, cpf);
		// TODO Inserir professor e mensagem de inserir
		response.sendRedirect("./listaProfessores.jsp");
	}

}
