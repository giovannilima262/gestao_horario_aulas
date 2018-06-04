package br.com.gestao_horario_aulas.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gestao_horario_aulas.dao.SalaDao;
import br.com.gestao_horario_aulas.model.Sala;
import br.com.gestao_horario_aulas.util.Util;

/**
 * Servlet implementation class InserirSalasController
 */
@WebServlet("/telas/coordenador/inserirSala")
public class InserirSalasController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InserirSalasController() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = req.getParameter("id");
		SalaDao salad = new SalaDao();
		salad.delete(Integer.parseInt(id));
		resp.sendRedirect("./listaSalas.jsp");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nome = request.getParameter("nome");
		String bloco = request.getParameter("bloco");
		String tipo = request.getParameter("tipo");
		if (Util.isEmptyOrNull(nome) || Util.isEmptyOrNull(bloco) || Util.isEmptyOrNull(tipo)) {
			request.setAttribute("mensagem", "Todos os dados são obrigatórios para inserir uma sala");
			request.getRequestDispatcher("./sala.jsp").forward(request, response);
			return;
		}
		SalaDao salad = new SalaDao();
		salad.insert(new Sala(bloco, nome, tipo));
		// TODO Inserir Sala e mensagem de inseri
		response.sendRedirect("./listaSalas.jsp");
	}

}
