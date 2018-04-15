package br.com.gestao_horario_aulas.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gestao_horario_aulas.dao.CoordenadorDao;
import br.com.gestao_horario_aulas.model.Coordenador;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private CoordenadorDao coordenadorDao = new CoordenadorDao();

	public LoginController() {
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String user = request.getParameter("usuario");
		String senha = request.getParameter("senha");
		Coordenador coordenador = coordenadorDao.obterCoordenador(user, senha);
		if (coordenador != null) {
			request.getSession().setAttribute("coordenador", coordenador);
			response.sendRedirect("telas/home.jsp");
		} else {
			request.setAttribute("mensagem", "Usuário ou Senha Inválidos!");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}

}
