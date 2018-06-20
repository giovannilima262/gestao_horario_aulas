package br.com.gestao_horario_aulas.enums;

public enum DiaSemanaEnum {
	SEGUNDA(1,"Segunda-Feira"),
	TERCA(2,"Terça-Feira"),
	QUARTA(3,"Quarta-Feira"),
	QUINTA(4,"Quinta-Feira"),
	SEXTA(5,"Sexta-Feira"),
	SABADO(6,"Sábado");
	private String descricao;
	private int codigo;
	
	DiaSemanaEnum(int codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}
	
	public static DiaSemanaEnum getDiaEnum(int cod) {
		for (DiaSemanaEnum tipo : DiaSemanaEnum.values()) {
			if (cod == tipo.getCodigo()) {
				return tipo;
			}
		}
		return null;
	}
	

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
