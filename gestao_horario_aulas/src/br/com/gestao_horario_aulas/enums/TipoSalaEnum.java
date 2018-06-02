package br.com.gestao_horario_aulas.enums;

public enum TipoSalaEnum {
	LAMI(1, "Lami"), SALA(2, "Sala"), AUDITORIO(3, "Auditório");

	private int codigo;
	private String descricao;

	TipoSalaEnum(int codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public static TipoSalaEnum getSalaEnum(String cod) {
		for (TipoSalaEnum tipo : TipoSalaEnum.values()) {
			if (Integer.parseInt(cod) == tipo.getCodigo()) {
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
