package br.com.gestao_horario_aulas.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.gestao_horario_aulas.enums.DiaSemanaEnum;
import br.com.gestao_horario_aulas.enums.HoraEnumInicio;
import br.com.gestao_horario_aulas.model.Aula;
import br.com.gestao_horario_aulas.util.Conexao;

public class AulaDao {

	ProfessorDao professorDao = new ProfessorDao();
	DisciplinaDao disciplinaDao = new DisciplinaDao();
	SalaDao salaDao = new SalaDao();
	private Conexao conexao;

	public AulaDao() {
		this.conexao = Conexao.getConexao();
	}

	public void close() {
		conexao.closeConnection();
	}

	public void insert(Aula aula) {
		try (PreparedStatement stmt = conexao.getConnection().prepareStatement(
				"INSERT INTO aula" + " (dia_semana,horario,id_sala,id_professor_disciplina_grade)" + " VALUES(?,?,?,?);");
				PreparedStatement stm = conexao.getConnection()
						.prepareStatement("SELECT id FROM professor_disciplina_grade WHERE id_professor = "
								+ aula.getProfessor().getId() + " AND id_disciplina_grade = " + aula.getDisciplina().getId()
								+ ";");
				ResultSet rs = stm.executeQuery();) {
			stmt.setInt(1, aula.getDia().getCodigo());
			stmt.setInt(2, aula.getHorario().getCodigo());
			stmt.setInt(3, aula.getSala().getId());
			int id = 0;
			while (rs.next()) {
				id = rs.getInt("id");
			}
			if (id != 0) {
				stmt.setInt(4, id);
				stmt.execute();
			}
		} catch (SQLException e) {
			new RuntimeException(e);
		}
	}

	public ArrayList<Aula> getLista() {
		ArrayList<Aula> aulas = new ArrayList<>();
		try (PreparedStatement stmt = conexao.getConnection().prepareStatement("Select a.id, pdg.id_professor as professor, dg.id_disciplina as disciplina, a.horario as horario, a.dia_semana as dia_semana, a.id_sala as sala from aula as a inner join professor_disciplina_grade as pdg on (a.id_professor_disciplina_grade = pdg.id) inner join disciplina_grade as dg on(pdg.id_disciplina_grade = dg.id);");
				ResultSet rs = stmt.executeQuery();) {
			while (rs.next()) {
				Aula aula = new Aula();
				aula.setDia(DiaSemanaEnum.getDiaEnum(rs.getInt("dia_semana")));
				aula.setHorario(HoraEnumInicio.getHoraEnum(rs.getInt("horario")));
				aula.setId(rs.getInt("id"));
				aula.setDisciplina(disciplinaDao.findById(rs.getInt("disciplina")));
				aula.setProfessor(professorDao.findById(rs.getInt("professor")));
				aula.setSala(salaDao.findById(rs.getInt("sala")));
				aulas.add(aula);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return aulas;
	}

	public Aula findById(Integer id) {
		Aula aula = new Aula();
		try (PreparedStatement stmt = conexao.getConnection().prepareStatement("Select a.id, pdg.id_professor as professor, dg.id_disciplina as disciplina, a.horario as horario, a.dia_semana as dia_semana, a.id_sala as sala from aula as a inner join professor_disciplina_grade as pdg on (a.id_professor_disciplina_grade = pdg.id) inner join disciplina_grade as dg on(pdg.id_disciplina_grade = dg.id) where a.id="+id+";");
				ResultSet rs = stmt.executeQuery();) {
			while (rs.next()) {
				aula.setDia(DiaSemanaEnum.getDiaEnum(rs.getInt("dia_semana")));
				aula.setHorario(HoraEnumInicio.getHoraEnum(rs.getInt("horario")));
				aula.setId(rs.getInt("id"));
				aula.setDisciplina(disciplinaDao.findById(rs.getInt("disciplina")));
				aula.setProfessor(professorDao.findById(rs.getInt("professor")));
				aula.setSala(salaDao.findById(rs.getInt("sala")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return aula;
	}

	public void delete(Integer id) {
		try (PreparedStatement stmt = conexao.getConnection()
				.prepareStatement("DELETE FROM aula WHERE id = " + id + ";");) {
			stmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
