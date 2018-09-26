package br.com.gestao_horario_aulas.model;

import org.junit.Test;

import br.com.gestao_horario_aulas.dao.CoordenadorDao;

public class CoordenadorDaoTeste {
	@Test
	public void inserirCoordenadorDefault() {
		CoordenadorDao cd = new CoordenadorDao();
		assert (cd.insert(CoordenadorTeste.umCoordenadorDefaut().build()));
	}

	@Test
	public void inserirCoordenadorSemNome() {
		CoordenadorDao cd = new CoordenadorDao();
		assert (cd.insert(CoordenadorTeste.semNome().build()));
	}

	@Test
	public void inserirCoordenadorSemId() {
		CoordenadorDao cd = new CoordenadorDao();
		assert (cd.insert(CoordenadorTeste.semId().build()));
	}
}
