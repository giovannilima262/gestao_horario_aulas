package br.com.gestao_horario_aulas.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gestao_horario_aulas.dao.AulaDao;
import br.com.gestao_horario_aulas.dao.ProfessorDao;
import br.com.gestao_horario_aulas.dao.SalaDao;
import br.com.gestao_horario_aulas.model.Aula;
import br.com.gestao_horario_aulas.model.Disciplina;
import br.com.gestao_horario_aulas.model.DisciplinaGrade;
import br.com.gestao_horario_aulas.model.Professor;
import br.com.gestao_horario_aulas.model.Sala;
import br.com.gestao_horario_aulas.util.Util;

/**
 * Servlet implementation class InserirSalasController
 */
@WebServlet("/telas/coordenador/inserirHorario")
public class InserirHorarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ArrayList<Aula> aulas = new ArrayList<>();
	private AulaDao aulaDao = new AulaDao();

	private ArrayList<Sala> salas = new ArrayList<>();
	private ArrayList<Professor> professores = new ArrayList<>();

	private SalaDao salaDao = new SalaDao();
	private ProfessorDao professorDao = new ProfessorDao();

	public InserirHorarioController() {
		professores = professorDao.getLista();
		salas = salaDao.getLista();
		aulas = aulaDao.getLista();
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		if(req.getParameter("ac").equals("del")){
			aulaDao.delete(Integer.parseInt(id));
			resp.sendRedirect("./listaHorarios.jsp");
		}else{
			ArrayList<DisciplinaGrade> disciplinas = new ArrayList<>();
			disciplinas = professorDao.getDisciplinaPorProfessor(Integer.parseInt(id));
			req.setAttribute("disciplinas", disciplinas);
			req.getRequestDispatcher("./horario.jsp").forward(req, resp);
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String hora = request.getParameter("hora");
		String dia = request.getParameter("dia");
		String idProfessor = request.getParameter("professor");
		String idDisciplinaGrade = request.getParameter("Disciplina");
		String idSala = request.getParameter("sala");

		if (Util.isEmptyOrNull(hora) || Util.isEmptyOrNull(dia) || Util.isEmptyOrNull(idProfessor)
				|| Util.isEmptyOrNull(idDisciplinaGrade) || Util.isEmptyOrNull(idSala)) {
			request.setAttribute("mensagem", "Todos os dados são obrigatórios para inserir um horário");
			request.getRequestDispatcher("./horario.jsp").forward(request, response);
			return;
		}

		AulaDao aulaDao = new AulaDao();
		Aula aula = new Aula();
		Sala sala = new Sala();
		Professor professor = new Professor();
		Disciplina disciplina = new Disciplina();
		aula.setDia(Integer.parseInt(dia));
		aula.setHorario(Integer.parseInt(hora));
		sala.setId(Integer.parseInt(idSala));
		aula.setSala(sala);
		professor.setId(Integer.parseInt(idProfessor));
		aula.setProfessor(professor);
		disciplina.setId(Integer.parseInt(idDisciplinaGrade));
		aula.setDisciplina(disciplina);
		aulaDao.insert(aula);
		response.sendRedirect("./listaHorarios.jsp");
	}

	public ArrayList<Sala> getSalas() {
		return salas;
	}

	public ArrayList<Professor> getProfessores() {
		return professores;
	}

	public ArrayList<Aula> getAulas() {
		return aulas;
	}

	public AulaDao getAulaDao() {
		return aulaDao;
	}
	
}
