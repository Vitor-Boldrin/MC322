package pessoa;

public class Funcionario {

	// Atributos da classe
	private String cargo;
	private float salario;
	
	// Construtor da Classe
	public Funcionario(String cargo, float salario) {
		this.cargo = cargo;
		this.salario = salario;
	}
	
	// Gatters e Setters
	public String getCargo() {
		return this.cargo;
	}
	
	public float getSalario() {
		return this.salario;
	}
	
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	
	public void setSalario(float salario) {
		this.salario = salario;
	}
	
}
