package br.com.gestao_horario_aulas.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gestao_horario_aulas.dao.CoordenadorDao;
import br.com.gestao_horario_aulas.model.Coordenador;
import br.com.gestao_horario_aulas.util.Util;

/**
 * Servlet implementation class InserirSalasController
 */
@WebServlet("/telas/coordenador/inserirCoordenador")
public class InserirCoordenadorController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InserirCoordenadorController() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = req.getParameter("id");
		CoordenadorDao coordenadord = new CoordenadorDao();
		coordenadord.delete(Integer.parseInt(id));
		resp.sendRedirect("./listaCoordenadores.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nome = request.getParameter("nome");
		if (Util.isEmptyOrNull(nome)) {
			request.setAttribute("mensagem", "Todos os dados são obrigatórios para inserir um Coordenador");
			request.getRequestDispatcher("./coordenador.jsp").forward(request, response);
			return;
		}
		CoordenadorDao coordenadord = new CoordenadorDao();
		coordenadord.insert(new Coordenador(nome));
		// TODO Inserir professor e mensagem de inserir
		response.sendRedirect("./listaCoordenadores.jsp");
	}
}
