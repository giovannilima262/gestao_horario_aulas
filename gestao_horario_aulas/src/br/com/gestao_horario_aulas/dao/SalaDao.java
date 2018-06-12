package br.com.gestao_horario_aulas.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.gestao_horario_aulas.model.Sala;
import br.com.gestao_horario_aulas.util.Conexao;
import br.com.gestao_horario_aulas.enums.TipoSalaEnum;

public class SalaDao {
	private Conexao conexao;

	public SalaDao() {
		this.conexao = Conexao.getConexao();
	}

	public void close() {
		conexao.closeConnection();
	}

	public void insert(Sala sala) {
		try (PreparedStatement stmt = conexao.getConnection()
				.prepareStatement("INSERT INTO sala (nome, bloco, tipo_sala) VALUES (?,?,?);");) {
			stmt.setString(1, sala.getNome());
			stmt.setString(2, sala.getBloco());
			stmt.setInt(3, sala.getTipoSala().getCodigo());
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void update(Sala sala) {
		try (PreparedStatement stmt = conexao.getConnection()
				.prepareStatement("UPDATE sala SET nome = ?, bloco = ?, tipo_sala = ? WHERE id = ?;");) {
			stmt.setString(1, sala.getNome());
			stmt.setString(2, sala.getBloco());
			stmt.setInt(3, sala.getTipoSala().getCodigo());
			stmt.setInt(4, sala.getId());
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Sala> getLista() {
		List<Sala> salas = new ArrayList<>();
		try (PreparedStatement stmt = conexao.getConnection().prepareStatement("SELECT * FROM sala;");
				ResultSet rs = stmt.executeQuery()) {
			while (rs.next()) {
				Sala sala = new Sala();
				sala.setId(rs.getInt("id"));
				sala.setNome(rs.getString("nome"));
				sala.setBloco(rs.getString("bloco"));
				TipoSalaEnum tpe = rs.getInt("tipo_sala") == 1 ? TipoSalaEnum.LAMI
						: rs.getInt("tipo_sala") == 2 ? TipoSalaEnum.SALA
								: rs.getInt("tipo_sala") == 3 ? TipoSalaEnum.AUDITORIO : null;
				sala.setTipoSala(tpe);
				salas.add(sala);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return (ArrayList<Sala>) salas;
	}

	public Sala findById(Integer id) {
		Sala sala = new Sala();
		try (PreparedStatement stmt = conexao.getConnection()
				.prepareStatement("SELECT * FROM sala WHERE id = " + id + ";"); ResultSet rs = stmt.executeQuery()) {
			while (rs.next()) {
				sala.setId(rs.getInt("id"));
				sala.setNome(rs.getString("nome"));
				sala.setBloco(rs.getString("bloco"));
				TipoSalaEnum tpe = rs.getInt("tipo_sala") == 1 ? TipoSalaEnum.LAMI
						: rs.getInt("tipo_sala") == 2 ? TipoSalaEnum.SALA
								: rs.getInt("tipo_sala") == 3 ? TipoSalaEnum.AUDITORIO : null;
				sala.setTipoSala(tpe);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sala;
	}

	public ArrayList<Sala> findByNome(String nome) {
		List<Sala> salas = new ArrayList<>();
		Sala sala = new Sala();
		try (PreparedStatement stmt = conexao.getConnection()
				.prepareStatement("SELECT * FROM sala WHERE id = " + nome + ";"); ResultSet rs = stmt.executeQuery()) {
			while (rs.next()) {
				sala.setId(rs.getInt("id"));
				sala.setNome(rs.getString("nome"));
				sala.setBloco(rs.getString("bloco"));
				TipoSalaEnum tpe = rs.getInt("tipo_sala") == 1 ? TipoSalaEnum.LAMI
						: rs.getInt("tipo_sala") == 2 ? TipoSalaEnum.SALA
								: rs.getInt("tipo_sala") == 3 ? TipoSalaEnum.AUDITORIO : null;
				sala.setTipoSala(tpe);
				salas.add(sala);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return (ArrayList<Sala>) salas;
	}

	public ArrayList<Sala> findByTipo(TipoSalaEnum Tipo) {
		List<Sala> salas = new ArrayList<>();
		Sala sala = new Sala();
		try (PreparedStatement stmt = conexao.getConnection()
				.prepareStatement("SELECT * FROM sala WHERE tipo_sala = " + Tipo.getCodigo() + ";");
				ResultSet rs = stmt.executeQuery()) {
			while (rs.next()) {
				sala.setId(rs.getInt("id"));
				sala.setNome(rs.getString("nome"));
				sala.setBloco(rs.getString("bloco"));
				TipoSalaEnum tpe = rs.getInt("tipo_sala") == 1 ? TipoSalaEnum.LAMI
						: rs.getInt("tipo_sala") == 2 ? TipoSalaEnum.SALA
								: rs.getInt("tipo_sala") == 3 ? TipoSalaEnum.AUDITORIO : null;
				sala.setTipoSala(tpe);
				salas.add(sala);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return (ArrayList<Sala>) salas;
	}

	public void delete(Integer id) throws SQLException {
		PreparedStatement stmt = conexao.getConnection()
				.prepareStatement("DELETE FROM sala WHERE id = " + id + ";");
			stmt.executeQuery();
			stmt.close();
	}
}
