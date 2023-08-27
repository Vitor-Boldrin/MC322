package Pessoa;

abstract class Pessoa {

	// Atributos
	private String nome;
	private String celular;
	private String email;
	private String cpf;
	
	// Construtor
	public Pessoa(String nome, String celular, String email, String cpf) {
		this.nome = nome;
		this.celular = celular;
		this.email = email;
		this.cpf = cpf;
	}
	
	//Sets e gets
	public String getNome() {
		return this.nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCelular() {
		return this.celular;
	}
	
	public void setCelular(String celular) {
		this.celular = celular;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getCpf() {
		return this.cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
}
