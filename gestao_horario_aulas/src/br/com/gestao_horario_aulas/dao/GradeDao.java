package br.com.gestao_horario_aulas.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.gestao_horario_aulas.model.Grade;
import br.com.gestao_horario_aulas.util.Conexao;

public class GradeDao {
	private Conexao conexao;

	public GradeDao() {
		this.conexao = Conexao.getConexao();
	}

	public void close() {
		conexao.closeConnection();
	}

	public void insert(Grade grade) {
		try (PreparedStatement stmt = conexao.getConnection()
				.prepareStatement("INSERT INTO grade (nome, id_curso, ano_semestre_ini) VALUES (?,?, ?);");) {
			stmt.setString(1, grade.getNome());
			stmt.setInt(2, grade.getCurso().getId());
			stmt.setString(3, grade.getAnoSemestreInicio());
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Grade> getLista() {
		List<Grade> grades = new ArrayList<>();
		try (PreparedStatement stmt = conexao.getConnection().prepareStatement("SELECT * FROM grade;");
				ResultSet rs = stmt.executeQuery()) {
			while (rs.next()) {
				CursoDao cdao = new CursoDao();
				Grade grade = new Grade();
				grade.setId(rs.getInt("id"));
				grade.setNome(rs.getString("nome"));
				grade.setCurso(cdao.findById(rs.getInt("id_curso")));
				grade.setAnoSemestreInicio(rs.getString("ano_semestre_ini"));
				grades.add(grade);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return (ArrayList<Grade>) grades;

	}

	public Grade findById(Integer id) { 
	Grade grade = new Grade();
	try (PreparedStatement stmt = conexao.getConnection()
			.prepareStatement("SELECT * FROM grade WHERE id = " + id +";"); 
			ResultSet rs = stmt.executeQuery()) {
		while (rs.next()) {
			CursoDao cdao = new CursoDao();
			grade.setId(rs.getInt("id"));
			grade.setNome(rs.getString("nome"));
			grade.setCurso(cdao.findById(rs.getInt("id_curso")));
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return grade;
}

	public ArrayList<Grade> findByNome(String nome) {
		List<Grade> grades = new ArrayList<>();
		try (PreparedStatement stmt = conexao.getConnection().prepareStatement("SELECT * FROM grade WHERE nome = '" + nome +"';");
				ResultSet rs = stmt.executeQuery()) {
			while (rs.next()) {
				CursoDao cdao = new CursoDao();
				Grade grade = new Grade();
				grade.setId(rs.getInt("id"));
				grade.setNome(rs.getString("nome"));
				grade.setCurso(cdao.findById(rs.getInt("id_curso")));
				grades.add(grade);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return (ArrayList<Grade>) grades;
	}

	public ArrayList<Grade> findByCurso(Integer cursoId) {
		List<Grade> grades = new ArrayList<>();
		try (PreparedStatement stmt = conexao.getConnection().prepareStatement("SELECT * FROM grade WHERE id_curso = " + cursoId +";");
				ResultSet rs = stmt.executeQuery()) {
			while (rs.next()) {
				CursoDao cdao = new CursoDao();
				Grade grade = new Grade();
				grade.setId(rs.getInt("id"));
				grade.setNome(rs.getString("nome"));
				grade.setCurso(cdao.findById(rs.getInt("id_curso")));
				grades.add(grade);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return (ArrayList<Grade>) grades;
	
	}


	public void delete(Integer id) {
		try (PreparedStatement stmt = conexao.getConnection().prepareStatement("DELETE FROM grade WHERE id =" + id)) {
			stmt.execute();
		} catch (SQLException e) {
			new RuntimeException(e);
		}
	
	}
}
