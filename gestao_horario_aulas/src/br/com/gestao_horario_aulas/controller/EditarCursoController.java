package br.com.gestao_horario_aulas.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
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
 * Servlet implementation class EditarCursoController
 */
@WebServlet("/telas/coordenador/EditarCurso")
public class EditarCursoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private CursoDao cursoDao = new CursoDao();

	public CursoDao getCursoDao() {
		return cursoDao;
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String idCurso = req.getParameter("id");
		req.setAttribute("nomeCurso", getCursoDao().findById(Integer.parseInt(idCurso)).getNome());
		req.setAttribute("idCurso", Integer.parseInt(idCurso));
		req.setAttribute("objCoordenador", getCursoDao().findById(Integer.parseInt(idCurso)).getCoordenador());
		RequestDispatcher rq = req.getRequestDispatcher("./editarCurso.jsp");
		rq.forward(req, resp);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idCurso = request.getParameter("idCurso");
		String idCoordenador = request.getParameter("idCoordenador");
		String nome = request.getParameter("nome");
		
		if (Util.isEmptyOrNull(nome)) {
			request.setAttribute("mensagem", "Todos os dados são obrigatórios para editar um Curso");
			request.getRequestDispatcher("./editarCurso.jsp").forward(request, response);
			return;
		}
		Coordenador coo = new Coordenador(nome);
		coo.setId(Integer.parseInt(idCoordenador));
		Curso c = new Curso(nome,coo);
		c.setId(Integer.parseInt(idCurso));		
		cursoDao.update(c);
		response.sendRedirect("./listaCursos.jsp");
	}

}
