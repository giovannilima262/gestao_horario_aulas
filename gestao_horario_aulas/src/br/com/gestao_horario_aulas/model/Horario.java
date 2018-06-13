package br.com.gestao_horario_aulas.model;

import br.com.gestao_horario_aulas.enums.DiaSemanaEnum;
import br.com.gestao_horario_aulas.enums.HoraEnumInicio;

public class Horario {
	private HoraEnumInicio hora;
	private DiaSemanaEnum diaSemana;
	private Disciplina disciplina;
	private Professor professor;
	private Sala sala;
	public HoraEnumInicio getHora() {
		return hora;
	}

	public void setHora(HoraEnumInicio hora) {
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
