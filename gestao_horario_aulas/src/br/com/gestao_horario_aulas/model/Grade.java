package br.com.gestao_horario_aulas.model;

import java.util.List;

public class Grade {
	private Integer id;
	private String nome;
	private Curso curso;
	private String anoSemestreFim;
	private String anoSemestreInicio;
	private List<Disciplina> disciplinas;
	
	public Grade() {}
	
	public Grade(String nome, String semestreInicio, String idCurso) {
		this.nome = nome;
		this.anoSemestreInicio = semestreInicio;
		this.curso = new Curso();
		this.curso.setId(Integer.parseInt(idCurso));
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
		return anoSemestreInicio;
	}

	public void setAnoSemestreInicio(String anoSemestreInicio) {
		this.anoSemestreInicio = anoSemestreInicio;
	}

	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getAnoSemestreFim() {
		return anoSemestreFim;
	}

	public void setAnoSemestreFim(String anoSemestreFim) {
		this.anoSemestreFim = anoSemestreFim;
	}

}
