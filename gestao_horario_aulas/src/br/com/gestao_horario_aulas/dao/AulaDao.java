package br.com.gestao_horario_aulas.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.gestao_horario_aulas.model.Aula;
import br.com.gestao_horario_aulas.model.Professor;
import br.com.gestao_horario_aulas.util.Conexao;

public class AulaDao {
	private List<Aula> aulas = new ArrayList<>();

	private Conexao conexao;

	public AulaDao() {
		this.conexao = Conexao.getConexao();
	}

	public void close() {
		conexao.closeConnection();
	}

	public void insert(Aula aula) {
		try (PreparedStatement stmt = conexao.getConnection().prepareStatement(
				"INSERT INTO aula" + " (dia_semana,horario,id_sala,id_professor_disciplina)" + " VALUES(?,?,?,?);");
				PreparedStatement stm = conexao.getConnection()
						.prepareStatement("SELECT id FROM professor_disciplina WHERE id_professor = "
								+ aula.getProfessor().getId() + " AND id_disciplina = " + aula.getDisciplina().getId()
								+ ";");
				ResultSet rs = stm.executeQuery();) {
			stmt.setInt(1, aula.getDia());
			stmt.setInt(2, aula.getHorario());
			stmt.setInt(3, aula.getSala().getId());
			int id = 0;
			while (rs.next()) {
				id = rs.getInt("id");
			}
			if (id != 0) {
				stmt.setInt(4, id);
				stmt.execute();
			}
		} catch (SQLException e) {
			new RuntimeException(e);
		}
	}

	public ArrayList<Aula> getLista() {
		try (PreparedStatement stmt = conexao.getConnection().prepareStatement("SELECT * FROM aula");
				ResultSet rs = stmt.executeQuery();) {
			Aula aula = new Aula();
			while (rs.next()) {
				aula.setDia(rs.getInt("dia_semana"));
				aula.setHorario(rs.getInt("horario"));
				aula.setId(rs.getInt("id"));
				int idProfessorDisciplina = rs.getInt("id_professor_disciplina");
				aula.setProfessor(getProfessorByProfessorDisciplina(idProfessorDisciplina));
//				aula.setDisciplina(getDisciplinaByProfessorDisciplina(idProfessorDisciplina));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return (ArrayList<Aula>) this.aulas;
	}

	private Professor getProfessorByProfessorDisciplina(int idProfessorDisciplina) {
		Professor professor = new Professor();

		try (PreparedStatement stmt = conexao.getConnection().prepareStatement(
				"SELECT * FROM professor WHERE (SELECT professor_disciplina.id_professor FROM professor_disciplina WHERE professor_disciplina.id = "
						+ idProfessorDisciplina + ") = professor.id;");
				ResultSet rs = stmt.executeQuery();) {

			while (rs.next()) {
				professor.setId(rs.getInt("id"));
				professor.setNome(rs.getString("nome"));
				professor.setCpf(rs.getString("cpf"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return professor;
	}

//	private Disciplina getDisciplinaByProfessorDisciplina(int idProfessorDisciplina) {
//		Disciplina disciplina = new Disciplina();
//
//		try (PreparedStatement stmt = conexao.getConnection().prepareStatement(
//				"SELECT * FROM professor WHERE (SELECT professor_disciplina.id_professor FROM professor_disciplina WHERE professor_disciplina.id = "
//						+ idProfessorDisciplina + ") = professor.id;");
//				ResultSet rs = stmt.executeQuery();
//				ResultSet rst = stmt.executeQuery();) {
//
//			while (rs.next()) {
//				disciplina.setId(rs.getInt("id"));
//				disciplina.setNome(rs.getString("nome"));
//				disciplina.setSemestre(rs.getInt("semestre"));
//			}
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//
//		return disciplina;
//	}

	public Aula findById(Integer id) {
		Aula aula = null;
		for (Aula a : this.aulas) {
			if (aula.getId().equals(id)) {
				aula = a;
			}
		}
		return aula;
	}

	public ArrayList<Aula> findByMateria(Integer idMateria) {
		ArrayList<Aula> aulas = new ArrayList<Aula>();
		for (Aula a : this.aulas) {
			if (a.getDisciplina().getId().equals(idMateria)) {
				aulas.add(a);
			}
		}
		return aulas;
	}

	public ArrayList<Aula> findByProfessor(Integer idProfessor) {
		ArrayList<Aula> aulas = new ArrayList<Aula>();
		for (Aula a : this.aulas) {
			if (a.getProfessor().getId().equals(idProfessor)) {
				aulas.add(a);
			}
		}
		return aulas;
	}

	public void delete(Integer id) {
		try (PreparedStatement stmt = conexao.getConnection()
				.prepareStatement("DELETE FROM aula WHERE id = " + id + ";");) {
			stmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
