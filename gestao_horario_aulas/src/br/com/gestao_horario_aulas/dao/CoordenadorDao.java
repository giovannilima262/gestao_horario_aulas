package br.com.gestao_horario_aulas.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.gestao_horario_aulas.model.Coordenador;
import br.com.gestao_horario_aulas.model.Curso;
import br.com.gestao_horario_aulas.util.Conexao;

public class CoordenadorDao {
	private List<Coordenador> coordenadores = new ArrayList<>();

	private Conexao conexao;

	public CoordenadorDao() {
		this.conexao = Conexao.getConexao();
	}

	public void close() {
		conexao.closeConnection();
	}
	
	public void insert(Coordenador coordenador) {
		coordenadores.add(coordenador);
	}

	public ArrayList<Coordenador> getLista() {
		return (ArrayList<Coordenador>) this.coordenadores;
	}

	public Coordenador findById(Integer id) {
		for (Coordenador c : this.coordenadores) {
			if (c.getId().equals(id)) {
				return c;
			}
		}
		return null;
	}

	public Coordenador findByNome(String nome) {
		Coordenador coordenador = null;
		for (Coordenador c : this.coordenadores) {
			if (c.getNome().equals(nome)) {
				coordenador = c;
			}
		}
		return coordenador;
	}


	public void delete(Integer id) {
		for (Coordenador c : this.coordenadores) {
			if (c.getId().equals(id)) {
				this.coordenadores.remove(c);
			}
		}
	}

	public Coordenador obterCoordenador(String user, String senha) {
		Coordenador coordenador = null;
		// FIXME Mudar para consultar o usuario no banco
		if (user.equals("coordenador") && senha.equals("123456")) {
			coordenador = new Coordenador();
			coordenador.setNome(user);
			Curso curso = new Curso();
			curso.setNome("Engenharia de Software");
			curso.setCoordenador(coordenador);
		}
		return coordenador;
	}
}
