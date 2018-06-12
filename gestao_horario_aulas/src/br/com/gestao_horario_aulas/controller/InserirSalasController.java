package br.com.gestao_horario_aulas.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

	private List<Sala> salas = new ArrayList<>();
	private SalaDao salaDao = new SalaDao();

	public InserirSalasController() {
		salas = salaDao.getLista();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		try{
			salaDao.delete(Integer.parseInt(id));
		}catch (SQLException e) {
			req.setAttribute("mensagemErro", "Não é possivel deletar");
			req.getRequestDispatcher("./listaSalas.jsp").forward(req, resp);
		}
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
		salaDao.insert(new Sala(bloco, nome, tipo));
		// TODO Inserir Sala e mensagem de inseri
		response.sendRedirect("./listaSalas.jsp");
	}

	public List<Sala> getSalas() {
		return salas;
	}

	public void setSalas(List<Sala> salas) {
		this.salas = salas;
	}

}
