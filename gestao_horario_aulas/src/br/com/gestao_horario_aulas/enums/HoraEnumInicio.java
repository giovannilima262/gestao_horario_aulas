package br.com.gestao_horario_aulas.enums;

public enum HoraEnumInicio {
	_07_00(1, "07:00 - 08:15"),
	_08_15(2, "08:25 - 09:35"),
	_09_50(4, "09:45 - 10:00"),
	_10_20(4, "10:15 - 11:30"),
	_11_50(5, "11:45 - 12:40");
	//FIXME Incluir mais
	private String descricao;
	private int codigo;

	HoraEnumInicio(int codigo, String descricao) {
		this.descricao = descricao;
		this.codigo = codigo;
	}
	
	public static HoraEnumInicio getHoraEnum(int cod) {
		for (HoraEnumInicio tipo : HoraEnumInicio.values()) {
			if (cod == tipo.getCodigo()) {
				return tipo;
			}
		}
		return null;
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
