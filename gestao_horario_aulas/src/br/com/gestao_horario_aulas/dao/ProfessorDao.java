package br.com.gestao_horario_aulas.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
				professor.setNome(rs.getString("cpf"));
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

	public void delete(Integer id) {
		try (PreparedStatement stmt = conexao.getConnection().prepareStatement("DELETE FROM professor WHERE id = "+id+";");) {
			stmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
