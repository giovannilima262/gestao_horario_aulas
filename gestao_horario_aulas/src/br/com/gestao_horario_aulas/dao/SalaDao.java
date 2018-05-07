package br.com.gestao_horario_aulas.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.gestao_horario_aulas.model.Sala;
import br.com.gestao_horario_aulas.util.Conexao;
import br.com.gestao_horario_aulas.enums.TipoSalaEnum;

public class SalaDao {
	private List<Sala> salas = new ArrayList<>();

	private Conexao conexao;

	public SalaDao() {
		this.conexao = Conexao.getConexao();
	}

	public void close() {
		conexao.closeConnection();
	}

	public void insert(Sala aula) {
		salas.add(aula);
	}

	public ArrayList<Sala> getLista() {
		return (ArrayList<Sala>) this.salas;
	}

	public Sala findById(Integer id) {
		Sala materia = null;
		for (Sala s : this.salas) {
			if (s.getId().equals(id)) {
				materia = s;
			}
		}
		return materia;
	}

	public ArrayList<Sala> findByNome(String nome) {
		ArrayList<Sala> salas = new ArrayList<>();
		for (Sala s : this.salas) {
			if (s.getNome().equals(nome)) {
				salas.add(s);
			}
		}
		return salas;
	}

	public ArrayList<Sala> findByTipo(TipoSalaEnum Tipo) {
		ArrayList<Sala> salas = new ArrayList<>();
		for (Sala s : this.salas) {
			if (s.getTipoSala().equals(Tipo)) {
				salas.add(s);
			}
		}
		return salas;
	}

	public void delete(Integer id) {
		for (Sala s : this.salas) {
			if (s.getId().equals(id)) {
				this.salas.remove(s);
			}
		}
	}
}
