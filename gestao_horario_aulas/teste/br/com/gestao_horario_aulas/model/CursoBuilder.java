package br.com.gestao_horario_aulas.model;

public class CursoBuilder {
	Integer id = 1; 
	String nome = "Eng. Software";
	Coordenador coordenador = CoordenadorBuilder.umCoordenador().build();
	
	public static CursoBuilder umCurso() {
		return new CursoBuilder();

	}
	
	public CursoBuilder comNome(String nome) {
		this.nome = nome;
		return this;
	}
	
	public CursoBuilder comId(Integer id) {
		this.id = id;
		return this;
	}
	
	public CursoBuilder semNome() {
		this.nome = null;
		return this;
	}
	
	public CursoBuilder semId() {
		this.id = null;
		return this;
	}
	
	public CursoBuilder comCoordenador(CoordenadorBuilder coordenador) {
		this.coordenador = coordenador.build();
		return this;		
		
	}
	
	public Curso build() {
		Curso c = new Curso(nome, coordenador);
		c.setId(id);
		return c;
	}
}
