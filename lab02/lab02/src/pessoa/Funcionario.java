package pessoa;

import Controle_Livros.Emprestimo;

public class Funcionario {

	// Atributos da classe
	private String cargo;
	private float salario;
	
	// Construtor da Classe
	public Funcionario(String cargo, float salario) {
		this.cargo = cargo;
		this.salario = salario;
	}
	
	// Métodos
	public void empresta_livro(Emprestimo emprestimo) {
		if ( emprestimo.getLivro().pode_emprestar() ) { // Testa se o livro pode ser emprestado
			
			if (emprestimo.getEstudate().getEmprestimos().size()
					< emprestimo.getEstudate().getMax_Emprestimos()) { // Checa se o estudante pode emprestar livros
				
				emprestimo.getEstudate().getEmprestimos().add(emprestimo); // Adiciona o emprestimo
				emprestimo.getLivro().setStatus("emprestado"); //Muda status do livro
				System.out.println("Livro emprestado.");
				
				
			} else {
				System.out.println("O estudante não pode emprestar mais livros.");
			}
			
		} else {
			System.out.println("Livro não pode ser emprestado");
		}
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
