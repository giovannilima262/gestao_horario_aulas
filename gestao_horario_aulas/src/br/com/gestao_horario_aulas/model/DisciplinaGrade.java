package br.com.gestao_horario_aulas.model;

public class DisciplinaGrade {
	private String nome;
	private int id;
	private Disciplina disciplina;
	private Grade grade;
	private int Semestre;
	
	
	public DisciplinaGrade() {
		
	}
	
	public DisciplinaGrade(Disciplina disciplina, Grade grade, int semestre) {
		this.disciplina = disciplina;
		this.grade = grade;
		Semestre = semestre;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public Disciplina getDisciplina() {
		return disciplina;
	}
	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}
	public Grade getGrade() {
		return grade;
	}
	public void setGrade(Grade grade) {
		this.grade = grade;
	}
	public int getSemestre() {
		return Semestre;
	}
	public void setSemestre(int semestre) {
		Semestre = semestre;
	}
	
	
}
