package br.com.gestao_horario_aulas.model;

public class Coordenador {
	private Integer id;
	private String nome;

	public Coordenador() {
	}	
	
	public Coordenador(String nome) {
		this.nome = nome;
	}

	public Integer getId() {
		return this.id;
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
		Coordenador outro = (Coordenador) arg0; 
		return this.getId().equals(outro.getId());
	}
	
	@Override
	public String toString() {
		return this.nome;
	}
}
