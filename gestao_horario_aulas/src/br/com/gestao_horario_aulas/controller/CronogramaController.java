package br.com.gestao_horario_aulas.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gestao_horario_aulas.model.Aula;
import br.com.gestao_horario_aulas.model.Disciplina;

/**
 * Servlet implementation class CronogramaController
 */
@WebServlet("/cronograma")
public class CronogramaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CronogramaController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String semestre = request.getParameter("semestre");
		request.setAttribute("aulas", buscarAulas(semestre));
		request.getRequestDispatcher("telas/cronograma.jsp?semestre=" + semestre).forward(request, response);
	}

	// FIXME Temporario até existencia de um banco
	private List<Aula> buscarAulas(String semestre) {
		List<Aula> aulas = new ArrayList<>();
		if (semestre.equals("1")) {
			aulas.add(new Aula(new Disciplina("Iniciação a Vida Universitária")));
			aulas.add(new Aula(new Disciplina("Inglês Técnico")));
			aulas.add(new Aula(new Disciplina("Comunicação e Explessão")));
			aulas.add(new Aula(new Disciplina("Arquitetura e Organização de Computadores")));
			aulas.add(new Aula(new Disciplina("Introdução a Engenharia de Software")));
			aulas.add(new Aula(new Disciplina("Lógica de Programação e Algoritmos")));

		} else {
			aulas.add(new Aula(new Disciplina("")));
			aulas.add(new Aula(new Disciplina("")));
			aulas.add(new Aula(new Disciplina("")));
			aulas.add(new Aula(new Disciplina("")));
			aulas.add(new Aula(new Disciplina("")));
			aulas.add(new Aula(new Disciplina("")));
		}
		return aulas;
	}

}
