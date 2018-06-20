package br.com.gestao_horario_aulas.model;

public class ProfessorDisciplinaGrade {
	private int id;
	private Professor professor;
	private DisciplinaGrade disciplinaGrade;
	public Professor getProfessor() {
		return professor;
	}
	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
	public DisciplinaGrade getDisciplinaGrade() {
		return disciplinaGrade;
	}
	public void setDisciplinaGrade(DisciplinaGrade disciplinaGrade) {
		this.disciplinaGrade = disciplinaGrade;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
