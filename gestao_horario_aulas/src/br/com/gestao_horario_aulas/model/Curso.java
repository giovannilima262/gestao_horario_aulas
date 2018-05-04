package br.com.gestao_horario_aulas.model;

public class Curso {
	private Integer id;
	private String nome;
	private Coordenador coordenador;
	// TODO Adicionar numero de semestres do curso.
	public Coordenador getCurso() {
		return coordenador;
	}
	
	public void setCoordenador(Coordenador coordenador) {
		this.coordenador = coordenador;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Override
	public boolean equals(Object arg0) {
		Curso outra = (Curso) arg0; 
		return this.getId().equals(outra.getId());
	}
}
