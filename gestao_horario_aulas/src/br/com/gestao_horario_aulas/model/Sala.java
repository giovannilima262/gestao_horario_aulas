package br.com.gestao_horario_aulas.model;

import br.com.gestao_horario_aulas.enums.TipoSalaEnum;

public class Sala {
	private String bloco;
	private String nome;
	private TipoSalaEnum tipoSala;

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

}
