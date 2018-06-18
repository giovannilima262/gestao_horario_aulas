package br.com.gestao_horario_aulas.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.gestao_horario_aulas.model.Disciplina;
import br.com.gestao_horario_aulas.model.DisciplinaGrade;
import br.com.gestao_horario_aulas.model.Grade;
import br.com.gestao_horario_aulas.util.Conexao;

public class DisciplinaGradeDao {
	private Conexao conexao;
	private GradeDao graded;
	private DisciplinaDao disciplinad;

	public DisciplinaGradeDao() {
		this.conexao = Conexao.getConexao();
		graded = new GradeDao();
		disciplinad = new DisciplinaDao();
	}

	public void close() {
		conexao.closeConnection();
	}

	public void insert(DisciplinaGrade disciplinaGrade) {
		try (PreparedStatement stmt = conexao.getConnection()
				.prepareStatement("INSERT INTO disciplina_grade (id_disciplina, id_grade, semestre_grade) values (?,?,?);");) {
			stmt.setInt(1, disciplinaGrade.getDisciplina().getId());
			stmt.setInt(2, disciplinaGrade.getGrade().getId());
			stmt.setInt(3, disciplinaGrade.getSemestre());
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<DisciplinaGrade> getLista() {
		List<DisciplinaGrade> dgs = new ArrayList<>();
		try (PreparedStatement stmt = conexao.getConnection()
				.prepareStatement("SELECT * FROM disciplina_grade;");
				ResultSet rs = stmt.executeQuery()) {
			while (rs.next()) {
				DisciplinaGrade dg = new DisciplinaGrade();
				Grade g = graded.findById(rs.getInt("id_grade"));
				Disciplina d = disciplinad.findById(rs.getInt("id_disciplina"));
				dg.setId(rs.getInt("id"));
				dg.setDisciplina(d);
				dg.setGrade(g);
				dg.setSemestre(rs.getInt("semestre_grade"));
				dg.setNome(g.getNome()+" "+d.getNome());
				dgs.add(dg);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return (ArrayList<DisciplinaGrade>) dgs;

	}

	public DisciplinaGrade findById(Integer id) {
		DisciplinaGrade dg = new DisciplinaGrade();
		try (PreparedStatement stmt = conexao.getConnection()
				.prepareStatement("SELECT * FROM disciplina_grade WHERE id ="+id+";");
				ResultSet rs = stmt.executeQuery()) {
			while (rs.next()) {
				Grade g = graded.findById(rs.getInt("id_grade"));
				Disciplina d = disciplinad.findById(rs.getInt("id_disciplina"));
				dg.setId(rs.getInt("id"));
				dg.setDisciplina(d);
				dg.setGrade(g);
				dg.setSemestre(rs.getInt("semestre_grade"));
				dg.setNome(g.getNome()+" "+d.getNome());
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dg;
	}
}
