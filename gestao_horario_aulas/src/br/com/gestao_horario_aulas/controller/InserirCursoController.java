package br.com.gestao_horario_aulas.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gestao_horario_aulas.dao.CursoDao;
import br.com.gestao_horario_aulas.model.Coordenador;
import br.com.gestao_horario_aulas.model.Curso;
import br.com.gestao_horario_aulas.util.Util;

/**
 * Servlet implementation class InserirCurso
 */
@WebServlet("/telas/coordenador/InserirCurso")
public class InserirCursoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InserirCursoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		CursoDao cursod = new CursoDao();
		cursod.delete(Integer.parseInt(id));
		response.sendRedirect("./listaCursos.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("nome");
		String idCoordenador = request.getParameter("coordenador");
		if (Util.isEmptyOrNull(nome) || Util.isEmptyOrNull(idCoordenador)) {
			request.setAttribute("mensagem", "Todos os dados são obrigatórios para inserir um curso");
			request.getRequestDispatcher("./curso.jsp").forward(request, response);
			return;
		}
		CursoDao cursod = new CursoDao();
		Coordenador c = new Coordenador();
		c.setId(Integer.parseInt(idCoordenador));
		cursod.insert(new Curso(nome, c ));
		response.sendRedirect("./listaCursos.jsp");
	}

}
