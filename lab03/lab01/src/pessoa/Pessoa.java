package pessoa;

public class Pessoa {
	
	// Atributos da classe
	private String nome;
	private String celular;
	private String email;
	private String cpf;
	private Estudante estudante;
	private Funcionario funcionario;
	
	// Construtor da Classe
	public Pessoa(String nome,
					   String celular,
					   String cpf,
					   String email,
					   Estudante estudante,
					   Funcionario funcionario) {
		this.nome = nome;
		this.celular = celular;
		this.email = email;
		this.cpf = cpf;
		this.estudante = estudante;
		this.funcionario = funcionario;
	}
	
	// Gatters e Setters
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
	
	public String getCpf() {
		return this.cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Estudante getEstudante() {
		return this.estudante;
	}
	
	public void setEmail(Estudante estudante) {
		this.estudante = estudante;
	}
	
	public Funcionario getFuncionario() {
		return this.funcionario;
	}
	
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	
}
