package br.com.gestao_horario_aulas.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.gestao_horario_aulas.model.Materia;
import br.com.gestao_horario_aulas.util.Conexao;

public class MateriaDao {
	private List<Materia> materias = new ArrayList<>();

	private Conexao conexao;

	public MateriaDao() {
		this.conexao = Conexao.getConexao();
	}

	public void close() {
		conexao.closeConnection();
	}

	public void insert(Materia aula) {
		materias.add(aula);
	}

	public ArrayList<Materia> getLista() {
		return (ArrayList<Materia>) this.materias;
	}

	public Materia findById(Integer id) {
		Materia materia = null;
		for (Materia m : this.materias) {
			if (m.getId().equals(id)) {
				materia = m;
			}
		}
		return materia;
	}

	public Materia findByNome(String nome) {
		Materia materia = null;
		for (Materia m : this.materias) {
			if (m.getNome().equals(nome)) {
				materia = m;
			}
		}
		return materia;
	}

	public ArrayList<Materia> findByCurso(Integer cursoId) {
		ArrayList<Materia> materias = new ArrayList<>();
		for (Materia m : this.materias) {
			if (m.getCurso().getId().equals(cursoId)) {
				materias.add(m);
			}
		}
		return materias;
	}

	public ArrayList<Materia> findBySemestre(Integer semestre) {
		ArrayList<Materia> materias = new ArrayList<>();
		for (Materia m : this.materias) {
			if (m.getSemestre().equals(semestre)) {
				materias.add(m);
			}
		}
		return materias;
	}

	public void delete(Integer id) {
		for (Materia m : this.materias) {
			if (m.getId().equals(id)) {
				this.materias.remove(m);
			}
		}
	}
}
