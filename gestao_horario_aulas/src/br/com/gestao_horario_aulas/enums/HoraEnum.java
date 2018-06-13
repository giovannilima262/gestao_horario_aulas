package br.com.gestao_horario_aulas.enums;

public enum HoraEnum {
	_07_00("07:00"),
	_08_15("08:15"),
	_09_50("09:50"),
	_11_15("11:15"),
	_12_30("12:30");
	//FIXME Incluir mais
	private String descricao;

	HoraEnum(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
