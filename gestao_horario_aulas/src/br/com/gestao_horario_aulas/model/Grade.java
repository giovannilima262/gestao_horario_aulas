package br.com.gestao_horario_aulas.model;

import java.util.List;

public class Grade {
	private Integer id;
	private Curso curso;
	private String AnoSemestreInicio;
	private List<Disciplina> disciplinas;
	
	public Grade() {}
	
	public Grade(String semestreInicio, String curso) {
		this.AnoSemestreInicio = semestreInicio;
		this.curso = new Curso();
		this.curso.setId(Integer.parseInt(curso));
	}

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

	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}

}
