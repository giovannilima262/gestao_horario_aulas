package br.com.gestao_horario_aulas.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gestao_horario_aulas.dao.CursoDao;
import br.com.gestao_horario_aulas.dao.GradeDao;
import br.com.gestao_horario_aulas.model.Curso;
import br.com.gestao_horario_aulas.model.Grade;
import br.com.gestao_horario_aulas.util.Util;

/**
 * Servlet implementation class EditarGradeController
 */
@WebServlet("/telas/coordenador/EditarGrade")
public class EditarGradeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private List<Integer> semestres = new ArrayList<>();
	private ArrayList<Curso> cursos = new ArrayList<>();
	private GradeDao gradeDao = new GradeDao();
	private CursoDao cursoDao = new CursoDao();

	
	public EditarGradeController(){
		cursos = cursoDao.getLista();
		semestres = listaSemestres();
	}
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String idGrade = req.getParameter("id");
		req.setAttribute("nomeGrade", getGradeDao().findById(Integer.parseInt(idGrade)).getNome());
		req.setAttribute("idGrade", Integer.parseInt(idGrade));
		req.setAttribute("AnoInicioGrade", getGradeDao().findById(Integer.parseInt(idGrade)).getAnoSemestreInicio());
		req.setAttribute("objCurso", getGradeDao().findById(Integer.parseInt(idGrade)).getCurso());
		RequestDispatcher rq = req.getRequestDispatcher("./editarGrade.jsp");
		rq.forward(req, resp);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idGrade = request.getParameter("idGrade");
		String idCurso = request.getParameter("idCurso");
		String semestreFim = request.getParameter("anoFim") +"."+ request.getParameter("semestreFim");
		String nome = request.getParameter("nome");
		
		if (Util.isEmptyOrNull(nome)) {
			request.setAttribute("mensagem", "Todos os dados são obrigatórios para editar uma Grade");
			request.getRequestDispatcher("./editarGrade.jsp").forward(request, response);
			return;
		}
		Curso c = new Curso();
		c.setId(Integer.parseInt(idCurso));	
		Grade g = new Grade();
		g.setNome(nome);
		g.setId(Integer.parseInt(idGrade));
		g.setAnoSemestreFim(semestreFim);
		g.setCurso(c);
		gradeDao.update(g);
		response.sendRedirect("./listaGrades.jsp");
	}
	
	private List<Integer> listaSemestres() {
		List<Integer> list = new ArrayList<>();
		for (int i = 1990; i < 2100; i++) {
			list.add(i);
		}
		return list;
	}
	
	public ArrayList<Curso> getCursos(){
		return cursos;
	}

	public GradeDao getGradeDao() {
		return gradeDao;
	}
	
	public List<Integer> getSemestres() {
		return semestres;
	}
}
