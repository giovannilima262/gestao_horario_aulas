package br.com.gestao_horario_aulas.model;

public class Aula {
	private Integer id;
	private Disciplina materia;
	private Professor professor;
	private Sala sala;
	private Integer dia;
	private Integer horario;

	public Aula(Disciplina materia) {
		this.materia = materia;
	}
	
	public Aula() {
		
	}

	public Integer getId() {
		return this.id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	public Disciplina getMateria() {
		return materia;
	}

	public void setMateria(Disciplina materia) {
		this.materia = materia;
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

	public Integer getDia() {
		return dia;
	}

	public void setDia(Integer dia) {
		this.dia = dia;
	}

	public Integer getHorario() {
		return horario;
	}

	public void setHorario(Integer horario) {
		this.horario = horario;
	}

	@Override
	public boolean equals(Object arg0) {
		Aula outra = (Aula) arg0;
		return this.getId().equals(outra.getId());
	}

}
