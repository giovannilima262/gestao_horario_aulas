package br.com.gestao_horario_aulas.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InserirSalasController
 */
@WebServlet("/telas/coordenador/inserirHorario")
public class InserirHorarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/*String id = req.getParameter("id");
		try{
			gradeDao.delete(Integer.parseInt(id));
		}catch (SQLException e) {
			req.setAttribute("mensagemErro", "Não é possivel deletar");
			req.getRequestDispatcher("./listaGrades.jsp").forward(req, resp);
		}
		resp.sendRedirect("./listaGrades.jsp");*/
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*String nome = request.getParameter("nome");
		String curso = request.getParameter("curso");
		String semestre = request.getParameter("semestre");
		String ano = request.getParameter("ano");
		if (Util.isEmptyOrNull(nome) || Util.isEmptyOrNull(curso) || Util.isEmptyOrNull(semestre)
				|| Util.isEmptyOrNull(ano)) {
			request.setAttribute("mensagem", "Todos os dados são obrigatórios para inserir um professor");
			request.getRequestDispatcher("./grade.jsp").forward(request, response);
			return;
		}

		gradeDao.insert(new Grade(nome, ano + "." + semestre, curso));
		response.sendRedirect("./listaGrades.jsp");*/
	}

	

}
