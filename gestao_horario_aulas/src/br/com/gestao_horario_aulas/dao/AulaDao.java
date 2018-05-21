package br.com.gestao_horario_aulas.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.gestao_horario_aulas.model.Aula;
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
								+ aula.getProfessor().getId() + " AND id_disciplina = " + aula.getMateria().getId()
								+ ";");
				ResultSet rs = stm.executeQuery();) {
			stmt.setInt(1, aula.getDia());
			stmt.setInt(2, aula.getHorario());
			stmt.setInt(3, aula.getSala().getId());
			int id = 0;
			while (rs.next()) {
				id = rs.getInt("id");
			}
			if(id!=0){
			stmt.setInt(4, id);
			stmt.execute();
			conexao.closeConnection();}
		} catch (SQLException e) {
			new RuntimeException(e);
		}
	}

	public ArrayList<Aula> getLista() {
		
		try(PreparedStatement stmt = conexao.getConnection().prepareStatement("SELECT * FROM aula");
				ResultSet rs = stmt.executeQuery();) {
			Aula au = new Aula();
			while(rs.next()) {
				au.setDia(rs.getInt("dia_semana"));
				au.setHorario(rs.getInt("horario"));
				au.setId(rs.getInt("id"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return (ArrayList<Aula>) this.aulas;
	}

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
			if (a.getMateria().getId().equals(idMateria)) {
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
		for (Aula a : this.aulas) {
			if (a.getId().equals(id)) {
				this.aulas.remove(a);
			}
		}
	}
}
