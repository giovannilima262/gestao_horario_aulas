package br.com.gestao_horario_aulas.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gestao_horario_aulas.dao.CursoDao;
import br.com.gestao_horario_aulas.dao.DisciplinaDao;
import br.com.gestao_horario_aulas.model.Curso;
import br.com.gestao_horario_aulas.model.Disciplina;
import br.com.gestao_horario_aulas.util.Util;

/**
 * Servlet implementation class EditarDisciplinaController
 */
@WebServlet("/telas/coordenador/EditarDisciplina")
public class EditarDisciplinaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private ArrayList<Curso> cursos = new ArrayList<>();
	private DisciplinaDao disciplinaDao = new DisciplinaDao();
	private CursoDao cursoDao = new CursoDao();

	public DisciplinaDao getDisciplinaDao() {
		return disciplinaDao;
	}
	
	public EditarDisciplinaController(){
		cursos = cursoDao.getLista();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String idDisciplina = req.getParameter("id");
		req.setAttribute("nomeDisciplina", getDisciplinaDao().findById(Integer.parseInt(idDisciplina)).getNome());
		req.setAttribute("idDisciplina", Integer.parseInt(idDisciplina));
		req.setAttribute("objCurso", getDisciplinaDao().findById(Integer.parseInt(idDisciplina)).getCurso());
		RequestDispatcher rq = req.getRequestDispatcher("./editarDisciplina.jsp");
		rq.forward(req, resp);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idDisciplina = request.getParameter("idDisciplina");
		String idCurso = request.getParameter("idCurso");
		String nome = request.getParameter("nome");
		
		if (Util.isEmptyOrNull(nome)) {
			request.setAttribute("mensagem", "Todos os dados são obrigatórios para editar uma Disciplina");
			request.getRequestDispatcher("./editarDisciplina.jsp").forward(request, response);
			return;
		}
		Curso c = new Curso();
		c.setId(Integer.parseInt(idCurso));	
		Disciplina d = new Disciplina(nome,c);
		d.setId(Integer.parseInt(idDisciplina));
		disciplinaDao.update(d);
		response.sendRedirect("./listaDisciplinas.jsp");
	}
	
	public ArrayList<Curso> getCursos(){
		return cursos;
	}

}
