package br.com.gestao_horario_aulas.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.gestao_horario_aulas.model.Disciplina;
import br.com.gestao_horario_aulas.util.Conexao;

public class DisciplinaDao {
	private List<Disciplina> materias = new ArrayList<>();

	private Conexao conexao;

	public DisciplinaDao() {
		this.conexao = Conexao.getConexao();
	}

	public void close() {
		conexao.closeConnection();
	}

	public void insert(Disciplina aula) {
		materias.add(aula);
	}

	public ArrayList<Disciplina> getLista() {
		return (ArrayList<Disciplina>) this.materias;
	}

	public Disciplina findById(Integer id) {
		Disciplina materia = null;
		for (Disciplina m : this.materias) {
			if (m.getId().equals(id)) {
				materia = m;
			}
		}
		return materia;
	}

	public Disciplina findByNome(String nome) {
		Disciplina materia = null;
		for (Disciplina m : this.materias) {
			if (m.getNome().equals(nome)) {
				materia = m;
			}
		}
		return materia;
	}

	public ArrayList<Disciplina> findByCurso(Integer cursoId) {
		ArrayList<Disciplina> materias = new ArrayList<>();
		for (Disciplina m : this.materias) {
			if (m.getCurso().getId().equals(cursoId)) {
				materias.add(m);
			}
		}
		return materias;
	}

	public ArrayList<Disciplina> findBySemestre(Integer semestre) {
		ArrayList<Disciplina> materias = new ArrayList<>();
		for (Disciplina m : this.materias) {
			if (m.getSemestre().equals(semestre)) {
				materias.add(m);
			}
		}
		return materias;
	}

	public void delete(Integer id) {
		for (Disciplina m : this.materias) {
			if (m.getId().equals(id)) {
				this.materias.remove(m);
			}
		}
	}
}
