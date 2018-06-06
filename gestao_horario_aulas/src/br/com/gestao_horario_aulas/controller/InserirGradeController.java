package br.com.gestao_horario_aulas.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
 * Servlet implementation class InserirSalasController
 */
@WebServlet("/telas/coordenador/inserirGrade")
public class InserirGradeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private List<Curso> cursos = new ArrayList<>();
	private List<Grade> grades = new ArrayList<>();
	private GradeDao gradeDao = new GradeDao();
	private CursoDao cursoDao = new CursoDao();
	private List<Integer> semestres = new ArrayList<>();

	public InserirGradeController() {
		cursos = cursoDao.getLista();
		grades = gradeDao.getLista();
		semestres = listaSemestres();
	}

	private List<Integer> listaSemestres() {
		List<Integer> list = new ArrayList<>();
		for (int i = 1990; i < 2100; i++) {
			list.add(i);
		}
		return list;
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = req.getParameter("id");

		gradeDao.delete(Integer.parseInt(id));
		resp.sendRedirect("./listaGrades.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nome = request.getParameter("nome");
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
		response.sendRedirect("./listaGrades.jsp");
	}

	public List<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}

	public List<Grade> getGrades() {
		return grades;
	}

	public void setGrades(List<Grade> grades) {
		this.grades = grades;
	}

	public List<Integer> getSemestres() {
		return semestres;
	}

	public void setSemestres(List<Integer> semestres) {
		this.semestres = semestres;
	}

}
