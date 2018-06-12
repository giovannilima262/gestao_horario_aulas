package br.com.gestao_horario_aulas.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

	private List<Coordenador> coordenadores = new ArrayList<>();
	private CoordenadorDao coordenadorDao = new CoordenadorDao();

	public InserirCoordenadorController() {
		coordenadores = coordenadorDao.getLista();
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			String id = req.getParameter("id");
			coordenadorDao.delete(Integer.parseInt(id));
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
		coordenadorDao.insert(new Coordenador(nome));
		response.sendRedirect("./listaCoordenadores.jsp");
	}

	public List<Coordenador> getCoordenadores() {
		return coordenadores;
	}

	public void setCoordenadores(List<Coordenador> coordenadores) {
		this.coordenadores = coordenadores;
	}
}
