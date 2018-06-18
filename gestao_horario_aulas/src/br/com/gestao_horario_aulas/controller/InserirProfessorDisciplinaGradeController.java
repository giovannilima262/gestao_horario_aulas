package br.com.gestao_horario_aulas.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gestao_horario_aulas.dao.DisciplinaGradeDao;
import br.com.gestao_horario_aulas.dao.ProfessorDao;
import br.com.gestao_horario_aulas.util.Util;

/**
 * Servlet implementation class InserirProfessorDisciplinaGradeController
 */
@WebServlet("/telas/coordenador/InserirProfessorDisciplinaGrade")
public class InserirProfessorDisciplinaGradeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InserirProfessorDisciplinaGradeController() {
        super();
        // TODO Auto-generated constructor stub
    }

   

    	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    		/*String id = req.getParameter("id");
    		try{
    			professorDao.delete(Integer.parseInt(id));
    		}catch (SQLException e) {
    			req.setAttribute("mensagemErro", "Não é possivel deletar");
    			req.getRequestDispatcher("./listaProfessores.jsp").forward(req, resp);
    		}

    		resp.sendRedirect("./listaProfessores.jsp");*/
    	}

    	protected void doPost(HttpServletRequest request, HttpServletResponse response)
    			throws ServletException, IOException {
    		String idProfessor = request.getParameter("professor");
    		String idDisciplinaGrade = request.getParameter("disciplinaGrade");
    		if (Util.isEmptyOrNull(idProfessor) || Util.isEmptyOrNull(idDisciplinaGrade)) {
    			request.setAttribute("mensagem", "Todos os dados são obrigatórios para inserir um professor");
    			request.getRequestDispatcher("./professorDisciplinaGrade.jsp").forward(request, response);
    			return;
    		}
    		ProfessorDao professorDao = new ProfessorDao();
    		DisciplinaGradeDao disciplinaGradeDao = new DisciplinaGradeDao();
			professorDao .insertPDG(professorDao.findById(Integer.parseInt(idProfessor)), disciplinaGradeDao.findById(Integer.parseInt(idDisciplinaGrade)));
    		response.sendRedirect("./listaProfessorDisciplinaGrade.jsp");
    	}

    	
    


}
