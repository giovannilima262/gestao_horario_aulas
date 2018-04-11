package br.com.gestao_horario_aulas.model;

public class Coordenador {
	private Integer id;
	private String nome;
	private Curso curso;

	public Integer getId() {
		return this.id;
	}
	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Override
	public boolean equals(Object arg0) {
		Coordenador outro = (Coordenador) arg0; 
		return this.getId().equals(outro.getId());
	}
}
