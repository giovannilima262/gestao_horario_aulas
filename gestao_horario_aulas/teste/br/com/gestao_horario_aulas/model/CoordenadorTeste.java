package br.com.gestao_horario_aulas.model;

public class CoordenadorTeste {

	public static CoordenadorBuilder umCoordenadorDefaut() {
		return CoordenadorBuilder.umCoordenador().comId(1).comNome("Osvaldo");
	}

	public static CoordenadorBuilder semNome() {
		return CoordenadorBuilder.umCoordenador().comNome(null);
	}

	public static CoordenadorBuilder semId() {
		return CoordenadorBuilder.umCoordenador().comId(null);
	}

}
