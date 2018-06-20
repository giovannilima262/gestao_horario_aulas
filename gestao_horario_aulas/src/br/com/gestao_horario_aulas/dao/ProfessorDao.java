package br.com.gestao_horario_aulas.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.gestao_horario_aulas.model.Disciplina;
import br.com.gestao_horario_aulas.model.DisciplinaGrade;
import br.com.gestao_horario_aulas.model.Professor;
import br.com.gestao_horario_aulas.util.Conexao;

public class ProfessorDao {

	private Conexao conexao;

	public ProfessorDao() {
		this.conexao = Conexao.getConexao();
	}

	public void close() {
		conexao.closeConnection();
	}

	public void insert(Professor professor) {
		try (PreparedStatement stmt = conexao.getConnection()
				.prepareStatement("INSERT INTO professor (nome, cpf) VALUES (?,?);");) {
			stmt.setString(1, professor.getNome());
			stmt.setString(2, professor.getCpf());
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void insertPDG(Professor professor, DisciplinaGrade disciplinaGrade) {
		try (PreparedStatement stmt = conexao.getConnection()
				.prepareStatement("INSERT INTO professor_disciplina_grade (id_professor, id_disciplina_grade) values (?,?);");) {
			stmt.setInt(1, professor.getId());
			stmt.setInt(2, disciplinaGrade.getId());
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<DisciplinaGrade> getDisciplinaPorProfessor(Integer id) {
		ArrayList<DisciplinaGrade> disciplinas = new ArrayList<>();
		try (PreparedStatement stmt = conexao.getConnection().prepareStatement(
				"SELECT d.id as disciplina_id, dg.id as disciplina_grade_id, d.nome as disciplina_nome FROM professor_disciplina_grade as pdg "
						+ "inner join disciplina_grade as dg on (dg.id = pdg.id_disciplina_grade) "
						+ "inner join professor as p on (pdg.id_professor = " + id + ") "
						+ "inner join disciplina as d on (d.id = dg.id_disciplina); ");
				ResultSet rs = stmt.executeQuery()) {
			while (rs.next()) {
				DisciplinaGrade disciplinaGrade = new DisciplinaGrade();
				Disciplina disciplina = new Disciplina();
				disciplina.setId(rs.getInt("disciplina_id"));
				disciplina.setNome(rs.getString("disciplina_nome"));
				disciplinaGrade.setDisciplina(disciplina);
				disciplinaGrade.setId(rs.getInt("disciplina_grade_id"));
				disciplinas.add(disciplinaGrade);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return disciplinas;
	}
	
	public void update(Professor professor) {
		try (PreparedStatement stmt = conexao.getConnection()
				.prepareStatement("UPDATE professor SET nome = ?, cpf = ? WHERE id = ?;");) {
			stmt.setString(1, professor.getNome());
			stmt.setString(2, professor.getCpf());
			stmt.setInt(3, professor.getId());
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Professor> getLista() {
		List<Professor> professores = new ArrayList<>();
		try (PreparedStatement stmt = conexao.getConnection().prepareStatement("SELECT * FROM professor;");
				ResultSet rs = stmt.executeQuery()) {
			while (rs.next()) {
				Professor professor = new Professor();
				professor.setId(rs.getInt("id"));
				professor.setNome(rs.getString("nome"));
				professor.setCpf(rs.getString("cpf"));
				professores.add(professor);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return (ArrayList<Professor>) professores;

	}

	public Professor findById(Integer id) {
		Professor professor = new Professor();
		try (PreparedStatement stmt = conexao.getConnection()
				.prepareStatement("SELECT * FROM professor WHERE id = " + id + ";");
				ResultSet rs = stmt.executeQuery()) {
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
	
	public List<Professor> findByNome(String nome) {
		List<Professor> professores = new ArrayList<>();
		try (PreparedStatement stmt = conexao.getConnection()
				.prepareStatement("SELECT * FROM professor WHERE nome = '" + nome + "' ;");
				ResultSet rs = stmt.executeQuery()) {
			while (rs.next()) {
				Professor professor = new Professor();
				professor.setId(rs.getInt("id"));
				professor.setNome(rs.getString("nome"));
				professor.setNome(rs.getString("cpf"));
				professores.add(professor);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conexao.getConnection();
		}
		return (ArrayList<Professor>) professores;
	}

	public void delete(Integer id) throws SQLException {
		PreparedStatement stmt = conexao.getConnection().prepareStatement("DELETE FROM professor WHERE id = "+id+";");
		stmt.executeQuery();
		stmt.close();
	}
}
