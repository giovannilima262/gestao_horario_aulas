package br.com.gestao_horario_aulas.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.gestao_horario_aulas.model.Disciplina;
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

	public ArrayList<Disciplina> getLista() {
		List<Disciplina> disciplinas = new ArrayList<>();
		try (PreparedStatement stmt = conexao.getConnection().prepareStatement("SELECT * FROM disciplina;");
				ResultSet rs = stmt.executeQuery()) {
			while (rs.next()) {
				CursoDao cdao = new CursoDao();
				Disciplina disciplina = new Disciplina();
				disciplina.setId(rs.getInt("id"));
				disciplina.setNome(rs.getString("nome"));
				disciplina.setCurso(cdao.findById(rs.getInt("id_curso")));
				disciplinas.add(disciplina);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return (ArrayList<Disciplina>) disciplinas;

	}

	public Disciplina findById(Integer id) { 
	Disciplina disciplina = new Disciplina();
	try (PreparedStatement stmt = conexao.getConnection()
			.prepareStatement("SELECT * FROM disciplina WHERE id = " + id +";"); 
			ResultSet rs = stmt.executeQuery()) {
		while (rs.next()) {
			CursoDao cdao = new CursoDao();
			disciplina.setId(rs.getInt("id"));
			disciplina.setNome(rs.getString("nome"));
			disciplina.setCurso(cdao.findById(rs.getInt("id_curso")));
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return disciplina;
}

	public ArrayList<Disciplina> findByNome(String nome) {
		List<Disciplina> disciplinas = new ArrayList<>();
		try (PreparedStatement stmt = conexao.getConnection().prepareStatement("SELECT * FROM disciplina WHERE nome = '" + nome +"';");
				ResultSet rs = stmt.executeQuery()) {
			while (rs.next()) {
				CursoDao cdao = new CursoDao();
				Disciplina disciplina = new Disciplina();
				disciplina.setId(rs.getInt("id"));
				disciplina.setNome(rs.getString("nome"));
				disciplina.setCurso(cdao.findById(rs.getInt("id_curso")));
				disciplinas.add(disciplina);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return (ArrayList<Disciplina>) disciplinas;
	}

	public ArrayList<Disciplina> findByCurso(Integer cursoId) {
		List<Disciplina> disciplinas = new ArrayList<>();
		try (PreparedStatement stmt = conexao.getConnection().prepareStatement("SELECT * FROM disciplina WHERE id_curso = " + cursoId +";");
				ResultSet rs = stmt.executeQuery()) {
			while (rs.next()) {
				CursoDao cdao = new CursoDao();
				Disciplina disciplina = new Disciplina();
				disciplina.setId(rs.getInt("id"));
				disciplina.setNome(rs.getString("nome"));
				disciplina.setCurso(cdao.findById(rs.getInt("id_curso")));
				disciplinas.add(disciplina);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return (ArrayList<Disciplina>) disciplinas;
	
	}


	public void delete(Integer id) {
		try (PreparedStatement stmt = conexao.getConnection().prepareStatement("DELETE FROM disciplina WHERE id =" + id)) {
			stmt.execute();
		} catch (SQLException e) {
			new RuntimeException(e);
		}
	
	}
}
