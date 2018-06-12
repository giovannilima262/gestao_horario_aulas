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

import br.com.gestao_horario_aulas.dao.CoordenadorDao;
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
	private List<Coordenador> coordenadores = new ArrayList<>();
	private List<Curso> cursos = new ArrayList<>();
	private CursoDao cursoDao = new CursoDao();
	private CoordenadorDao coordenadorDao = new CoordenadorDao();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InserirCursoController() {
		coordenadores = coordenadorDao.getLista();
		cursos = cursoDao.getLista();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		
		try{
			cursoDao.delete(Integer.parseInt(id));
		}catch (SQLException e) {
			request.setAttribute("mensagemErro", "Não é possivel deletar");
			request.getRequestDispatcher("./listaCursos.jsp").forward(request, response);
		}

		response.sendRedirect("./listaCursos.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nome = request.getParameter("nome");
		String idCoordenador = request.getParameter("coordenador");
		if (Util.isEmptyOrNull(nome) || Util.isEmptyOrNull(idCoordenador)) {
			request.setAttribute("mensagem", "Todos os dados são obrigatórios para inserir um curso");
			request.getRequestDispatcher("./curso.jsp").forward(request, response);
			return;
		}
		Coordenador c = new Coordenador();
		c.setId(Integer.parseInt(idCoordenador));
		cursoDao.insert(new Curso(nome, c));
		response.sendRedirect("./listaCursos.jsp");
	}

	public List<Coordenador> getCoordenadores() {
		return coordenadores;
	}

	public void setCoordenadores(List<Coordenador> coordenadores) {
		this.coordenadores = coordenadores;
	}

	public List<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}
	
	public CursoDao getCursoDao() {
		return this.cursoDao;
	}

}
