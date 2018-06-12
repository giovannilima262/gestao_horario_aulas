package br.com.gestao_horario_aulas.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.gestao_horario_aulas.model.Coordenador;
import br.com.gestao_horario_aulas.model.Curso;
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
				.prepareStatement("INSERT INTO grade (nome, id_curso, ano_semestre_ini) VALUES (?,?,?);");) {
			stmt.setString(1, grade.getNome());
			stmt.setInt(2, grade.getCurso().getId());
			stmt.setString(3, grade.getAnoSemestreInicio());
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void update(Grade grade) {
		try (PreparedStatement stmt = conexao.getConnection()
				.prepareStatement("UPDATE grade SET nome = ?, id_curso = ?, ano_semestre_ini = ? WHERE id = ?;");) {
			stmt.setString(1, grade.getNome());
			stmt.setInt(2, grade.getCurso().getId());
			stmt.setString(3, grade.getAnoSemestreInicio());
			stmt.setInt(4, grade.getId());
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Grade> getLista() {
		List<Grade> grades = new ArrayList<>();
		try (PreparedStatement stmt = conexao.getConnection()
				.prepareStatement("SELECT * FROM grade as g inner join curso as c on (c.id = g.id_curso);");
				ResultSet rs = stmt.executeQuery()) {
			while (rs.next()) {
				Curso c = new Curso();
				Grade grade = new Grade();
				Coordenador coo = new Coordenador();
				grade.setId(rs.getInt(1));
				grade.setNome(rs.getString(3));
				grade.setAnoSemestreInicio(rs.getString(4));
				c.setId(rs.getInt(6));
				c.setNome(rs.getString(7));
				coo.setId(8);
				c.setCoordenador(coo);
				grade.setCurso(c);
				grades.add(grade);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return (ArrayList<Grade>) grades;

	}

	public Grade findById(Integer id) {
		Grade grade = new Grade();
		try (PreparedStatement stmt = conexao.getConnection().prepareStatement(
				"SELECT * FROM grade as g inner join curso as c on (c.id = g.id_curso AND g.id = " + id + ");");
				ResultSet rs = stmt.executeQuery()) {
			while (rs.next()) {
				Curso c = new Curso();
				Coordenador coo = new Coordenador();
				grade.setId(rs.getInt(1));
				grade.setNome(rs.getString(3));
				grade.setAnoSemestreInicio(rs.getString(4));
				c.setId(rs.getInt(6));
				c.setNome(rs.getString(7));
				coo.setId(8);
				c.setCoordenador(coo);
				grade.setCurso(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return grade;
	}

	public ArrayList<Grade> findByNome(String nome) {
		List<Grade> grades = new ArrayList<>();
		try (PreparedStatement stmt = conexao.getConnection().prepareStatement(
				"SELECT * FROM grade as g inner join curso as c on (c.id = g.id_curso AND g.id = '" + nome + "');");
				ResultSet rs = stmt.executeQuery()) {
			while (rs.next()) {
				Curso c = new Curso();
				Grade grade = new Grade();
				Coordenador coo = new Coordenador();
				grade.setId(rs.getInt(1));
				grade.setNome(rs.getString(3));
				grade.setAnoSemestreInicio(rs.getString(4));
				c.setId(rs.getInt(6));
				c.setNome(rs.getString(7));
				coo.setId(8);
				c.setCoordenador(coo);
				grade.setCurso(c);
				grades.add(grade);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return (ArrayList<Grade>) grades;
	}

	public ArrayList<Grade> findByCurso(Integer cursoId) {
		List<Grade> grades = new ArrayList<>();
		try (PreparedStatement stmt = conexao.getConnection().prepareStatement(
				"SELECT * FROM grade as g inner join curso as c on (c.id = g.id_curso AND c.id = " + cursoId + ");");
				ResultSet rs = stmt.executeQuery()) {
			while (rs.next()) {
				Curso c = new Curso();
				Grade grade = new Grade();
				Coordenador coo = new Coordenador();
				grade.setId(rs.getInt(1));
				grade.setNome(rs.getString(3));
				grade.setAnoSemestreInicio(rs.getString(4));
				c.setId(rs.getInt(6));
				c.setNome(rs.getString(7));
				coo.setId(8);
				c.setCoordenador(coo);
				grade.setCurso(c);
				grades.add(grade);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return (ArrayList<Grade>) grades;

	}

	public void delete(Integer id)throws SQLException {
		PreparedStatement stmt = conexao.getConnection().prepareStatement("DELETE FROM grade WHERE id =" + id);
		stmt.execute();
		stmt.close();
	}
}
