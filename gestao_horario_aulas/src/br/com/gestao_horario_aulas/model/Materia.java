package br.com.gestao_horario_aulas.model;

public class Materia {
	private Integer id;
	private String nome;
	private Curso curso;
	private Integer semestre;
	private Professor professor;

	public Integer getId() {
		return this.id;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Integer getSemestre() {
		return semestre;
	}

	public void setSemestre(Integer semestre) {
		this.semestre = semestre;
	}
	
	public Professor getProfessor() {
		return this.professor;
	}
	
	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
	
	@Override
	public boolean equals(Object arg0) {
		Materia outra = (Materia) arg0; 
		return this.getId().equals(outra.getId());
	}
}
