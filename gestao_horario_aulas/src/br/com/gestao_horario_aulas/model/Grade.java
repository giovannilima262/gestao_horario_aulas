package br.com.gestao_horario_aulas.model;

import java.util.List;

public class Grade {
	private Integer id;
	private Curso curso;
	private String AnoSemestreInicio;
	private String AnoSemestreFim;
	private List<Disciplina> disciplinas;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public String getAnoSemestreInicio() {
		return AnoSemestreInicio;
	}

	public void setAnoSemestreInicio(String anoSemestreInicio) {
		AnoSemestreInicio = anoSemestreInicio;
	}

	public String getAnoSemestreFim() {
		return AnoSemestreFim;
	}

	public void setAnoSemestreFim(String anoSemestreFim) {
		AnoSemestreFim = anoSemestreFim;
	}

	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}

}
