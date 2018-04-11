package br.com.gestao_horario_aulas.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.gestao_horario_aulas.model.Coordenador;

public class CoordenadorDao {
	private List<Coordenador> coordenadores = new ArrayList<>();

	public void insert(Coordenador coordenador) {
		coordenadores.add(coordenador);
	}

	public ArrayList<Coordenador> getLista() {
		return (ArrayList<Coordenador>) this.coordenadores;
	}

	public Coordenador findById(Integer id) {
		Coordenador coordenador = null;
		for (Coordenador c : this.coordenadores) {
			if (coordenador.getId().equals(id)) {
				coordenador = c;
			}
		}
		return coordenador;
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

	public Coordenador findByCurso(Integer idCurso) {
		Coordenador coordenador = null;
		for (Coordenador a : this.coordenadores) {
			if (coordenador.getCurso().getId().equals(idCurso)) {
				coordenador = a;
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
}
