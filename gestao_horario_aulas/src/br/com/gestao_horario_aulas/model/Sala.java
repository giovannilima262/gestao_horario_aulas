package br.com.gestao_horario_aulas.model;

import br.com.gestao_horario_aulas.enums.TipoSalaEnum;

public class Sala {
	private Integer id;
	private String bloco;
	private String nome;
	private TipoSalaEnum tipoSala;
	
	public Integer getId() {
		return this.id;
	}
	
	public void setId(int id) {
		this.id =id;
	}
	
	public String getBloco() {
		return bloco;
	}

	public void setBloco(String bloco) {
		this.bloco = bloco;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public TipoSalaEnum getTipoSala() {
		return tipoSala;
	}

	public void setTipoSala(TipoSalaEnum tipoSala) {
		this.tipoSala = tipoSala;
	}
	
	@Override
	public boolean equals(Object arg0) {
		Sala outra = (Sala) arg0; 
		return this.getId().equals(outra.getId());
	}
}
