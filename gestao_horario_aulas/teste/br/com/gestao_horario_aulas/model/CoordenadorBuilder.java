package br.com.gestao_horario_aulas.model;

public class CoordenadorBuilder {
	Integer id = 1; 
	String nome = "Osvaldo";
	
	public static CoordenadorBuilder umCoordenador() {
		return new CoordenadorBuilder();

	}
	
	public CoordenadorBuilder comNome(String nome) {
		this.nome = nome;
		return this;
	}
	
	public CoordenadorBuilder comId(Integer id) {
		this.id = id;
		return this;
	}
	
	public CoordenadorBuilder semNome() {
		this.nome = null;
		return this;
	}
	
	public CoordenadorBuilder semId() {
		this.id = null;
		return this;
	}
	
	public Coordenador build() {
		Coordenador c = new Coordenador(nome);
		c.setId(id);
		return c;
	}
	
}
