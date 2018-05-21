package br.com.gestao_horario_aulas.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

	public ArrayList<Curso> getLista() {
		List<Curso> cursos = new ArrayList<>();
		try (PreparedStatement stmt = conexao.getConnection().prepareStatement("SELECT * FROM curso;");
				ResultSet rs = stmt.executeQuery()) {
			Curso curso = new Curso();
			CoordenadorDao cd = new CoordenadorDao();
			while (rs.next()) {
				curso.setId(rs.getInt("id"));
				curso.setNome(rs.getString("nome"));
				curso.setCoordenador(cd.findById(rs.getInt("id_coordenador")));
				cursos.add(curso);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return (ArrayList<Curso>) cursos;
	}

	public Curso findById(Integer id) {
		Curso curso = new Curso();
		CoordenadorDao coordenador = new CoordenadorDao();
		try (PreparedStatement stmt = conexao.getConnection()
				.prepareStatement("SELECT * FROM curso WHERE id = " + id + ";"); ResultSet rs = stmt.executeQuery();) {
			while (rs.next()) {
				curso.setId(rs.getInt("id"));
				curso.setNome(rs.getString("nome"));
				curso.setCoordenador(coordenador.findById(rs.getInt("id_coordenador")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return curso;
	}

	public Curso findByNome(String nome) {
		Curso curso = new Curso();
		CoordenadorDao coordenador = new CoordenadorDao();
		try (PreparedStatement stmt = conexao.getConnection()
				.prepareStatement("SELECT * FROM curso WHERE nome = '" + nome + "';");
				ResultSet rs = stmt.executeQuery();) {
			while (rs.next()) {
				curso.setId(rs.getInt("id"));
				curso.setNome(rs.getString("nome"));
				curso.setCoordenador(coordenador.findById(rs.getInt("id_coordenador")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return curso;
	}

	public void delete(Integer id) {
		try (PreparedStatement stmt = conexao.getConnection().prepareStatement("DELETE FROM curso WHERE id =" + id)) {
			stmt.execute();
		} catch (SQLException e) {
			new RuntimeException(e);
		}
	}
}
