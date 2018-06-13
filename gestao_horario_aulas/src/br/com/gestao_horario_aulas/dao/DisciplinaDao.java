package br.com.gestao_horario_aulas.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.gestao_horario_aulas.model.Coordenador;
import br.com.gestao_horario_aulas.model.Curso;
import br.com.gestao_horario_aulas.model.Disciplina;
import br.com.gestao_horario_aulas.model.Grade;
import br.com.gestao_horario_aulas.util.Conexao;

public class DisciplinaDao {

	private Conexao conexao;

	public DisciplinaDao() {
		this.conexao = Conexao.getConexao();
	}

	public void close() {
		conexao.closeConnection();
	}

	public void insert(Disciplina disciplina) {
		try (PreparedStatement stmt = conexao.getConnection()
				.prepareStatement("INSERT INTO disciplina (nome, id_curso) VALUES (?,?);");) {
			stmt.setString(1, disciplina.getNome());
			stmt.setInt(2, disciplina.getCurso().getId());
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void update(Disciplina disciplina) {
		try (PreparedStatement stmt = conexao.getConnection()
				.prepareStatement("UPDATE disciplina SET nome = ?, id_curso = ? WHERE id = ?;");) {
			stmt.setString(1, disciplina.getNome());
			stmt.setInt(2, disciplina.getCurso().getId());
			stmt.setInt(3, disciplina.getId());
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Disciplina> getLista() {
		List<Disciplina> disciplinas = new ArrayList<>();
		try (PreparedStatement stmt = conexao.getConnection()
				.prepareStatement("SELECT * FROM disciplina as d inner join curso as c on (c.id = d.id_curso);");
				ResultSet rs = stmt.executeQuery()) {
			while (rs.next()) {
				Curso c = new Curso();
				Disciplina disciplina = new Disciplina();
				Coordenador coo = new Coordenador();
				disciplina.setId(rs.getInt(1));
				disciplina.setNome(rs.getString(3));
				c.setId(rs.getInt(4));
				c.setNome(rs.getString(5));
				coo.setId(rs.getInt(6));
				c.setCoordenador(coo);
				disciplina.setCurso(c);
				disciplinas.add(disciplina);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return (ArrayList<Disciplina>) disciplinas;

	}

	public Disciplina findById(Integer id) {
		Disciplina disciplina = new Disciplina();
		try (PreparedStatement stmt = conexao.getConnection().prepareStatement(
				"SELECT * FROM disciplina as d inner join curso as c on (c.id = d.id_curso AND d.id = " + id + ");");
				ResultSet rs = stmt.executeQuery()) {
			while (rs.next()) {
				Curso c = new Curso();
				Coordenador coo = new Coordenador();
				disciplina.setId(rs.getInt(1));
				disciplina.setNome(rs.getString(3));
				c.setId(rs.getInt(4));
				c.setNome(rs.getString(5));
				coo.setId(rs.getInt(6));
				c.setCoordenador(coo);
				disciplina.setCurso(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return disciplina;
	}

	public Disciplina findByIdDisciplinaGrade(Integer id) {
		Disciplina disciplina = new Disciplina();
		try (PreparedStatement stmt = conexao.getConnection()
				.prepareStatement("SELECT dg.id as id_diciplina_grade, " + "d.id as id_disciplina,"
						+ "g.id as id_grade," + "dg.semestre_grade as semestre," + "d.id_curso as id_curso,"
						+ "d.nome as nome_disciplina," + "g.nome as nome_grade"
						+ "FROM disciplina_grade as dg inner join disciplina as d on (d.id = dg.id_disciplina) inner join grade as g on (g.id = dg.id_grade) where dg.id = "
						+ id + ";");
				ResultSet rs = stmt.executeQuery()) {
			while (rs.next()) {
				Curso c = new Curso();
				disciplina.setId(rs.getInt("id_disciplina"));
				disciplina.setNome(rs.getString("nome_disciplina"));
				c.setId(rs.getInt("id_curso"));
				disciplina.setCurso(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return disciplina;
	}

	public ArrayList<Disciplina> findByNome(String nome) {
		List<Disciplina> disciplinas = new ArrayList<>();
		try (PreparedStatement stmt = conexao.getConnection().prepareStatement(
				"SELECT * FROM disciplina as d inner join curso as c on (c.id = d.id_curso AND d.id = '" + nome
						+ "');");
				ResultSet rs = stmt.executeQuery()) {
			while (rs.next()) {
				Curso c = new Curso();
				Coordenador coo = new Coordenador();
				Disciplina disciplina = new Disciplina();
				disciplina.setId(rs.getInt(1));
				disciplina.setNome(rs.getString(3));
				c.setId(rs.getInt(4));
				c.setNome(rs.getString(5));
				coo.setId(rs.getInt(6));
				c.setCoordenador(coo);
				disciplina.setCurso(c);
				disciplinas.add(disciplina);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return (ArrayList<Disciplina>) disciplinas;
	}

	public ArrayList<Disciplina> findByCurso(Integer cursoId) {
		List<Disciplina> disciplinas = new ArrayList<>();
		try (PreparedStatement stmt = conexao.getConnection().prepareStatement(
				"SELECT * FROM disciplina as d inner join curso as c on (c.id = d.id_curso AND c.id = " + cursoId
						+ ");");
				ResultSet rs = stmt.executeQuery()) {
			while (rs.next()) {
				Curso c = new Curso();
				Coordenador coo = new Coordenador();
				Disciplina disciplina = new Disciplina();
				disciplina.setId(rs.getInt(1));
				disciplina.setNome(rs.getString(3));
				c.setId(rs.getInt(4));
				c.setNome(rs.getString(5));
				coo.setId(rs.getInt(6));
				c.setCoordenador(coo);
				disciplina.setCurso(c);
				disciplinas.add(disciplina);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return (ArrayList<Disciplina>) disciplinas;

	}

	public void delete(Integer id) throws SQLException {
		PreparedStatement stmt = conexao.getConnection().prepareStatement("DELETE FROM disciplina WHERE id =" + id);
		stmt.execute();
		stmt.close();
	}
}
