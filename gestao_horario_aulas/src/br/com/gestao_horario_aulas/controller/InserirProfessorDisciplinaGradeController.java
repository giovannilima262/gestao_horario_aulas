package br.com.gestao_horario_aulas.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InserirProfessorDisciplinaGradeController
 */
@WebServlet("/InserirProfessorDisciplinaGradeController")
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
    		String nome = request.getParameter("nome");
    		String cpf = request.getParameter("cpf");
    		/*if (Util.isEmptyOrNull(nome) || Util.isEmptyOrNull(cpf)) {
    			request.setAttribute("mensagem", "Todos os dados são obrigatórios para inserir um professor");
    			request.getRequestDispatcher("./professor.jsp").forward(request, response);
    			return;
    		}
    		professorDao.insert(new Professor(nome, cpf));
    		response.sendRedirect("./listaProfessores.jsp");*/
    	}

    	
    


}
