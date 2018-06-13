package br.com.gestao_horario_aulas.model;

import br.com.gestao_horario_aulas.enums.DiaSemanaEnum;
import br.com.gestao_horario_aulas.enums.HoraEnum;

public class Horario {
	private HoraEnum hora;
	private DiaSemanaEnum diaSemana;
	private Disciplina disciplina;
	private Professor professor;
	private Sala sala;
	public HoraEnum getHora() {
		return hora;
	}

	public void setHora(HoraEnum hora) {
		this.hora = hora;
	}

	public DiaSemanaEnum getDiaSemana() {
		return diaSemana;
	}

	public void setDiaSemana(DiaSemanaEnum diaSemana) {
		this.diaSemana = diaSemana;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}
}
