package br.com.gestao_horario_aulas.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.gestao_horario_aulas.model.Coordenador;
import br.com.gestao_horario_aulas.model.Curso;
import br.com.gestao_horario_aulas.util.Conexao;

public class CursoDao {

	private Conexao conexao;

	public CursoDao() {
		this.conexao = Conexao.getConexao();
	}

	public void close() {
		conexao.closeConnection();
	}

	public void insert(Curso curso) {
		try (PreparedStatement stmt = conexao.getConnection()
				.prepareStatement("INSERT INTO curso (id_coordenador, nome) VALUES (?,?);");) {
			stmt.setInt(1, curso.getCoordenador().getId());
			stmt.setString(2, curso.getNome());
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void update(Curso curso) {
		try (PreparedStatement stmt = conexao.getConnection()
				.prepareStatement("UPDATE curso SET id_coordenador = ?, nome = ? WHERE id = ?;");) {
			stmt.setInt(1, curso.getCoordenador().getId());
			stmt.setString(2, curso.getNome());
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Curso> getLista() {
		List<Curso> cursos = new ArrayList<>();
		try (PreparedStatement stmt = conexao.getConnection().prepareStatement(
				"SELECT * FROM curso as c inner join coordenador as coo on (coo.id = c.id_coordenador);");
				ResultSet rs = stmt.executeQuery()) {
			while (rs.next()) {
				Curso curso = new Curso();
				Coordenador c = new Coordenador();
				curso.setId(rs.getInt(1));
				curso.setNome(rs.getString(2));
				c.setId(rs.getInt(4));
				c.setNome(rs.getString(5));
				curso.setCoordenador(c);
				cursos.add(curso);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return (ArrayList<Curso>) cursos;
	}

	public Curso findById(Integer id) {
		Curso curso = new Curso();
		try (PreparedStatement stmt = conexao.getConnection().prepareStatement(
				"SELECT * FROM curso as c inner join coordenador as coo on (coo.id = c.id_coordenador AND c.id = " + id
						+ ");");
				ResultSet rs = stmt.executeQuery();) {
			while (rs.next()) {
				Coordenador c = new Coordenador();
				curso.setId(rs.getInt(1));
				curso.setNome(rs.getString(2));
				c.setId(rs.getInt(4));
				c.setNome(rs.getString(5));
				curso.setCoordenador(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return curso;
	}

	public Curso findByNome(String nome) {
		Curso curso = new Curso();
		try (PreparedStatement stmt = conexao.getConnection().prepareStatement(
				"SELECT * FROM curso as c inner join coordenador as coo on (coo.id = c.id_coordenador AND c.nome = '"
						+ nome + "');");
				ResultSet rs = stmt.executeQuery();) {
			while (rs.next()) {
				Coordenador c = new Coordenador();
				curso.setId(rs.getInt(1));
				curso.setNome(rs.getString(2));
				c.setId(rs.getInt(4));
				c.setNome(rs.getString(5));
				curso.setCoordenador(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return curso;
	}

	public ArrayList<String> disciplinaPorCurso() {
		ArrayList<String> mensagens = new ArrayList<>();
		try (PreparedStatement stmt = conexao.getConnection().prepareStatement(
				"SELECT c.nome, count(d) FROM curso as c inner join disciplina  as d on (c.id = d.id_curso) group by c.nome;");
				ResultSet rs = stmt.executeQuery();) {

			while (rs.next()) {
				String mensagem = new String();
				mensagem = rs.getString(1) + ": " + rs.getInt(2) + " disciplinas.";
				mensagens.add(mensagem);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mensagens;
	}

	public void delete(Integer id) throws SQLException {
		PreparedStatement stmt = conexao.getConnection().prepareStatement("DELETE FROM curso WHERE id =" + id);
		stmt.execute();
		stmt.close();
	}
}
