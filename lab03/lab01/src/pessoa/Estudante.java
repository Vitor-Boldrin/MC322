package pessoa;

import Livros.Livro;

public class Estudante {

	// Atributos da classe
	private String ra;
	private String curso;
	private short num_emprestimos;
	private Livro[] livros_emprestados;
	
	// Construtor da Classe
	public Estudante(String ra, String curso) {
		this.ra = ra;
		this.curso = curso;
		this.num_emprestimos = 0;
		this.livros_emprestados = new Livro[1]; // O máximo de empréstimo é 1 (Por enquanto)
	}
	
	// Métodos
	public void empresta_livro(Livro livro) {
		if (livro.pode_emprestar() == 1) { // Testa se o livro pode ser emprestado
			
			if (this.num_emprestimos < livros_emprestados.length) {
				this.livros_emprestados[num_emprestimos] = livro;
				this.num_emprestimos++;
				livro.setStatus("Emprestado"); //Seta o livro como emprestado
				System.out.println("Livro emprestado");
			} else {
				System.out.println("Estudante atingiu o número máximo de empréstimos.");
			}
			
		} else {
			System.out.println("Livro não pode ser emprestado");
		}
	}
	
	public void devolve_livro(Livro livro) {
		if (this.num_emprestimos == 0) {
			System.out.println("Estudante não tem livros para devolver.");
		} else {
			livro.setStatus("disponivel");
			this.livros_emprestados[this.num_emprestimos - 1] = null;
			this.num_emprestimos--;
			System.out.println("Livro Devolvido");
		}
	}
	
	// Gatters e Setters
	public String getRa() {
		return this.ra;
	}
	
	public String getCurso() {
		return this.curso;
	}
	
	public void setRa(String ra) {
		this.ra = ra;
	}
	
	public void setSalario(String curso) {
		this.curso = curso;
	}
	
	public Livro[] getLivros_emprestados() {
		return this.livros_emprestados;
	}
	
}
