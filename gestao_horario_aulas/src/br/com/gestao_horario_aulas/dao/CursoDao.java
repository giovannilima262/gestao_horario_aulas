package br.com.gestao_horario_aulas.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.gestao_horario_aulas.model.Curso;
import br.com.gestao_horario_aulas.util.Conexao;

public class CursoDao {
	private List<Curso> cursos = new ArrayList<>();

	private Conexao conexao;

	public CursoDao() {
		this.conexao = Conexao.getConexao();
	}

	public void close() {
		conexao.closeConnection();
	}

	public void insert(Curso curso) {
		cursos.add(curso);
	}

	public ArrayList<Curso> getLista() {
		return (ArrayList<Curso>) this.cursos;
	}

	public Curso findById(Integer id) {
		Curso curso = null;
		for (Curso c : this.cursos) {
			if (c.getId().equals(id)) {
				curso = c;
			}
		}
		return curso;
	}

	public Curso findByNome(String nome) {
		Curso curso = null;
		for (Curso c : this.cursos) {
			if (c.getNome().equals(nome)) {
				curso = c;
			}
		}
		return curso;
	}

	public void delete(Integer id) {
		for (Curso c : this.cursos) {
			if (c.getId().equals(id)) {
				this.cursos.remove(c);
			}
		}
	}
}
