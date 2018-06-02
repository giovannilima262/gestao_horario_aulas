package br.com.gestao_horario_aulas.model;

import java.util.List;

public class Disciplina {
	private Integer id;
	private String nome;
	private Grade grade;
	private Integer curso;
	private Integer semestre;
	private List<Disciplina> preRequisitos;

	public Disciplina() {
		
	}
	
	public Disciplina(String nome, Integer semestre, Integer idCurso) {
		this.nome = nome;
		this.semestre = semestre;
		this.curso = idCurso;
	}

	// FIXME Temporario até a existi um banco
	public Disciplina(String nome) {
		this.nome = nome;
	}

	public List<Disciplina> getPreRequisitos() {
		return preRequisitos;
	}

	public void setPreRequisitos(List<Disciplina> preRequisitos) {
		this.preRequisitos = preRequisitos;
	}


	public Integer getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Grade getGrade() {
		return grade;
	}

	public void setGrade(Grade grade) {
		this.grade = grade;
	}

	public Integer getSemestre() {
		return semestre;
	}

	public void setSemestre(Integer semestre) {
		this.semestre = semestre;
	}

	@Override
	public boolean equals(Object arg0) {
		Disciplina outra = (Disciplina) arg0;
		return this.getId().equals(outra.getId());
		
	}
	
	// FIXME Temporario até a existi um banco
	@Override
	public String toString() {
		return this.nome;
	}

	public void setCurso(Integer curso) {
		this.curso = curso;
	}
	
	public Integer getCurso() {
		return this.curso;
	}
}
