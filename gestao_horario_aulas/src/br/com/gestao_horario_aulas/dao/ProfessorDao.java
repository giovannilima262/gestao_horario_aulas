package br.com.gestao_horario_aulas.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.gestao_horario_aulas.model.Professor;
import br.com.gestao_horario_aulas.util.Conexao;

public class ProfessorDao {
	private List<Professor> professores = new ArrayList<>();

	private Conexao conexao;

	public ProfessorDao() {
		this.conexao = Conexao.getConexao();
	}

	public void close() {
		conexao.closeConnection();
	}

	public void insert(Professor professor) {
		professores.add(professor);
	}

	public ArrayList<Professor> getLista() {
		return (ArrayList<Professor>) this.professores;
	}

	public Professor findById(Integer id) {
		Professor professor = null;
		for (Professor p : this.professores) {
			if (professor.getId().equals(id)) {
				professor = p;
			}
		}
		return professor;
	}

	public Professor findByNome(String nome) {
		Professor professor = null;
		for (Professor p : this.professores) {
			if (p.getNome().equals(nome)) {
				professor = p;
			}
		}
		return professor;
	}

	public void delete(Integer id) {
		for (Professor p : this.professores) {
			if (p.getId().equals(id)) {
				this.professores.remove(p);
			}
		}
	}

}
