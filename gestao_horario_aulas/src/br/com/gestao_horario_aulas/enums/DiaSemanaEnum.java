package br.com.gestao_horario_aulas.enums;

public enum DiaSemanaEnum {
	DOMINGO("Domingo"),
	SEGUNDA("Segunda-Feira"),
	TERCA("Terça-Feira"),
	QUARTA("Quarta-Feira"),
	QUINTA("Quinta-Feira"),
	SEXTA("Sexta-Feira"),
	SABADO("Sábado");
	//FIXME Incluir mais
	private String descricao;

	DiaSemanaEnum(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
