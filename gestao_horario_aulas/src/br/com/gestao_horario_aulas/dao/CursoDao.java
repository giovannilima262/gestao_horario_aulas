package br.com.gestao_horario_aulas.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.gestao_horario_aulas.model.Curso;

public class CursoDao {
	private List<Curso> cursos = new ArrayList<>();

	public void insert(Curso curso) {
		cursos.add(curso);
	}

	public ArrayList<Curso> getLista() {
		return (ArrayList<Curso>) this.cursos;
	}

	public Curso findById(Integer id) {
		Curso Curso = null;
		for (Curso c : this.cursos) {
			if (Curso.getId().equals(id)) {
				Curso = c;
			}
		}
		return Curso;
	}

	public Curso findByNome(String nome) {
		Curso Curso = null;
		for (Curso c : this.cursos) {
			if (c.getNome().equals(nome)) {
				Curso = c;
			}
		}
		return Curso;
	}

	public void delete(Integer id) {
		for (Curso c : this.cursos) {
			if (c.getId().equals(id)) {
				this.cursos.remove(c);
			}
		}
	}
}
