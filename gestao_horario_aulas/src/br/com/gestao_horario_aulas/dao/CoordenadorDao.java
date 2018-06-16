package br.com.gestao_horario_aulas.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.com.gestao_horario_aulas.model.Coordenador;
import br.com.gestao_horario_aulas.model.Curso;
import br.com.gestao_horario_aulas.util.Conexao;

public class CoordenadorDao {

	private Conexao conexao;

	public CoordenadorDao() {
		this.conexao = Conexao.getConexao();
	}

	public void close() {
		conexao.closeConnection();
	}

	public void insert(Coordenador coordenador) {
		try (PreparedStatement stmt = conexao.getConnection()
				.prepareStatement("INSERT INTO coordenador (nome) VALUES (?);");) {
			stmt.setString(1, coordenador.getNome());
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}
	
	public void update(Coordenador coordenador) {
		try (PreparedStatement stmt = conexao.getConnection()
				.prepareStatement("UPDATE coordenador SET nome = ? WHERE id = ?;");) {
			stmt.setString(1, coordenador.getNome());
			stmt.setInt(2, coordenador.getId());
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}

	public ArrayList<Coordenador> getLista() {
		List<Coordenador> coordenadores = new ArrayList<>();
		try (PreparedStatement stmt = conexao.getConnection().prepareStatement("SELECT * FROM coordenador;");
				ResultSet rs = stmt.executeQuery()) {
			while (rs.next()) {
				Coordenador coordenador = new Coordenador();
				coordenador.setId(rs.getInt("id"));
				coordenador.setNome(rs.getString("nome"));
				coordenadores.add(coordenador);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return (ArrayList<Coordenador>) coordenadores;
	}

	public Coordenador findById(Integer id) {
		Coordenador coordenador = new Coordenador();
		try (PreparedStatement stmt = conexao.getConnection()
				.prepareStatement("SELECT * FROM coordenador WHERE id = " + id +";"); ResultSet rs = stmt.executeQuery()) {
			while (rs.next()) {
				coordenador.setId(rs.getInt("id"));
				coordenador.setNome(rs.getString("nome"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return coordenador;
	}

	public ArrayList<Coordenador> findByNome(String nome) {
		List<Coordenador> coordenadores = new ArrayList<>();
		try (PreparedStatement stmt = conexao.getConnection().prepareStatement("SELECT * FROM coordenador WHERE nome = '"+nome+"';");
				ResultSet rs = stmt.executeQuery()) {
			while (rs.next()) {
				Coordenador coordenador = new Coordenador();
				coordenador.setId(rs.getInt("id"));
				coordenador.setNome(rs.getString("nome"));
				coordenadores.add(coordenador);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conexao.getConnection();
		}
		return (ArrayList<Coordenador>) coordenadores;
	}

	public void delete(Integer id) throws SQLException{
		PreparedStatement stmt = conexao.getConnection().prepareStatement("DELETE FROM coordenador WHERE id = "+id+";");
		stmt.executeQuery();
		stmt.close();
		
	}

	public Coordenador obterCoordenador(String user, String senha) {
		Coordenador coordenador = null;
		// FIXME Mudar para consultar o usuario no banco
		if (user.equals("coordenador") && senha.equals("123456")) {
			coordenador = new Coordenador();
			coordenador.setNome(user);
			Curso curso = new Curso();
			curso.setNome("Engenharia de Software");
			curso.setCoordenador(coordenador);
		}
		return coordenador;
	}
}
