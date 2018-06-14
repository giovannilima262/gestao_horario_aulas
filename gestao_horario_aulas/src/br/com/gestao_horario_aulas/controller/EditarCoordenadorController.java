package br.com.gestao_horario_aulas.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gestao_horario_aulas.dao.CoordenadorDao;
import br.com.gestao_horario_aulas.model.Coordenador;
import br.com.gestao_horario_aulas.util.Util;

/**
 * Servlet implementation class EditarCoordenadorController
 */
@WebServlet("/telas/coordenador/EditarCoordenador")
public class EditarCoordenadorController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private CoordenadorDao coordenadorDao = new CoordenadorDao();

	
	public CoordenadorDao getCoordenadorDao() {
		return coordenadorDao;
	}

	public EditarCoordenadorController() {
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		req.setAttribute("nomeCoordenador", getCoordenadorDao().findById(Integer.parseInt(id)).getNome());
		req.setAttribute("idCoordenador", Integer.parseInt(id));
		RequestDispatcher rq = req.getRequestDispatcher("./editarCoordenador.jsp");
		rq.forward(req, resp);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("idCoordenador");
		String nome = request.getParameter("nome");
		
		if (Util.isEmptyOrNull(nome)) {
			request.setAttribute("mensagem", "Todos os dados são obrigatórios para editar um Coordenador");
			request.getRequestDispatcher("./editarCoordenador.jsp").forward(request, response);
			return;
		}
		Coordenador coo = new Coordenador(nome);
		coo.setId(Integer.parseInt(id));
		coordenadorDao.update(coo);
		response.sendRedirect("./listaCoordenadores.jsp");
	}

}
