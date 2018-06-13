package br.com.gestao_horario_aulas.enums;

public enum HoraEnumInicio {
	_07_00(1, "07:00"),
	_08_15(2, "08:15"),
	_09_50(4, "09:50"),
	_11_05(5, "11:05");
	//FIXME Incluir mais
	private String descricao;
	private int codigo;

	HoraEnumInicio(int codigo, String descricao) {
		this.descricao = descricao;
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
}
