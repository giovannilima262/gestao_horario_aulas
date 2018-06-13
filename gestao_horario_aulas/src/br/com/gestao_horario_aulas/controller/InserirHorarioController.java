package br.com.gestao_horario_aulas.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gestao_horario_aulas.dao.AulaDao;
import br.com.gestao_horario_aulas.dao.DisciplinaDao;
import br.com.gestao_horario_aulas.dao.ProfessorDao;
import br.com.gestao_horario_aulas.dao.SalaDao;
import br.com.gestao_horario_aulas.model.Aula;
import br.com.gestao_horario_aulas.util.Util;

/**
 * Servlet implementation class InserirSalasController
 */
@WebServlet("/telas/coordenador/inserirHorario")
public class InserirHorarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private AulaDao aulaDao = new AulaDao();
	private ProfessorDao professorDao = new ProfessorDao();
	private DisciplinaDao disciplinaDao = new DisciplinaDao();
	private SalaDao salaDao = new SalaDao();

	private List<Aula> aulas;

	public InserirHorarioController() {
		aulas = aulaDao.getLista();
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/*
		 * String id = req.getParameter("id"); try{
		 * gradeDao.delete(Integer.parseInt(id)); }catch (SQLException e) {
		 * req.setAttribute("mensagemErro", "Não é possivel deletar");
		 * req.getRequestDispatcher("./listaGrades.jsp").forward(req, resp); }
		 * resp.sendRedirect("./listaGrades.jsp");
		 */
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String hora = request.getParameter("hora");
		String dia = request.getParameter("dia");
		String idProfessor = request.getParameter("professor");
		String idDisciplinaGrade = request.getParameter("disciplinagrade");
		String idSala = request.getParameter("sala");
		if (Util.isEmptyOrNull(hora) || Util.isEmptyOrNull(dia) || Util.isEmptyOrNull(idProfessor)
				|| Util.isEmptyOrNull(idDisciplinaGrade) || Util.isEmptyOrNull(idSala)) {
			request.setAttribute("mensagem", "Todos os dados são obrigatórios para inserir um professor");
			request.getRequestDispatcher("./grade.jsp").forward(request, response);
			return;
		}

		aulaDao.insert(new Aula(Integer.parseInt(hora), Integer.parseInt(dia),
				professorDao.findById(Integer.parseInt(idProfessor)),
				disciplinaDao.findByIdDisciplinaGrade(Integer.parseInt(idDisciplinaGrade)),
				salaDao.findById(Integer.parseInt(idSala))));
		response.sendRedirect("./listaGrades.jsp");
	}

	public List<Aula> getAulas() {
		return aulas;
	}

	public void setAulas(List<Aula> aulas) {
		this.aulas = aulas;
	}

}
