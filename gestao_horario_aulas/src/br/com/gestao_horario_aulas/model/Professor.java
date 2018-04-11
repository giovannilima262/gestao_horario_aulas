package br.com.gestao_horario_aulas.model;

public class Professor {
	private Integer id;
	private String cpf;
	private String nome;
	
	public Integer getId() {
		return this.id;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	@Override
	public boolean equals(Object arg0) {
		Professor outra = (Professor) arg0; 
		return this.getId().equals(outra.getId());
	}
}
