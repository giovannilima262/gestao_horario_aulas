package br.com.gestao_horario_aulas.model;

public class Coordenador {
	private Integer id;
	private String nome;

	public Integer getId() {
		return this.id;
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
