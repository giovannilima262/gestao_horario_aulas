package br.com.gestao_horario_aulas.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gestao_horario_aulas.dao.DisciplinaGradeDao;
import br.com.gestao_horario_aulas.model.Disciplina;
import br.com.gestao_horario_aulas.model.DisciplinaGrade;
import br.com.gestao_horario_aulas.model.Grade;
import br.com.gestao_horario_aulas.util.Util;

/**
 * Servlet implementation class InserirDisciplinaGradeController
 */
@WebServlet("/telas/coordenador/InserirDisciplinaGrade")
public class InserirDisciplinaGradeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	DisciplinaGradeDao dgd = new DisciplinaGradeDao();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InserirDisciplinaGradeController() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String disciplina = request.getParameter("disciplina");
		String grade = request.getParameter("grade");
		String semestre = request.getParameter("semestre_grade");
		if (Util.isEmptyOrNull(disciplina) || Util.isEmptyOrNull(grade) || Util.isEmptyOrNull(semestre)) {
			request.setAttribute("mensagem", "Todos os dados são obrigatórios para inserir uma Disciplina Grade");
			request.getRequestDispatcher("./disciplinaGrade.jsp").forward(request, response);
			return;
		}
		Disciplina d = new Disciplina();
		Grade g = new Grade();
		d.setId(Integer.parseInt(disciplina));
		g.setId(Integer.parseInt(grade));
		DisciplinaGrade dg = new DisciplinaGrade(d, g, Integer.parseInt(semestre));
		dgd.insert(dg);
		request.setAttribute("mensagem", "Inserido!");
		request.getRequestDispatcher("./disciplinaGrade.jsp").forward(request, response);
    }

}
