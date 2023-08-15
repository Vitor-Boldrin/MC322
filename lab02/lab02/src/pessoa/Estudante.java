package pessoa;

import Livros.Livro;
import Controle_Livros.Emprestimo;

public class Estudante {

	// Atributos da classe
	private String ra;
	private String curso;
	private short num_emprestimos;
	private Emprestimo[] emprestimos;
	
	// Construtor da Classe
	public Estudante(String ra, String curso) {
		this.ra = ra;
		this.curso = curso;
		this.num_emprestimos = 0;
		this.emprestimos = new Emprestimo[1]; // O máximo de empréstimo é 1 (Por enquanto)
	}
	
	// Métodos
	public void empresta_livro(Emprestimo emprestimo) {
		if (emprestimo.getLivro().pode_emprestar() == 1) { // Testa se o livro pode ser emprestado
			
			if (this.num_emprestimos < emprestimos.length) {
				this.emprestimos[num_emprestimos] = emprestimo;
				this.num_emprestimos++;
				emprestimo.getLivro().setStatus("Emprestado"); //Seta o livro como emprestado
				System.out.println("Livro emprestado");
			} else {
				System.out.println("Estudante atingiu o número máximo de empréstimos.");
			}
			
		} else {
			System.out.println("Livro não pode ser emprestado");
		}
	}
	
	public void devolve_livro(Emprestimo emprestimo) {
		if (this.num_emprestimos == 0) {
			System.out.println("Estudante não tem livros para devolver.");
		} else {
			emprestimo.getLivro().setStatus("disponivel");
			this.emprestimos[this.num_emprestimos - 1] = null;
			this.num_emprestimos--;
			System.out.println("Livro Devolvido");
		}
	}
	
	// Gatters e Setters
	public String getRa() {
		return this.ra;
	}
	
	public void setRa(String ra) {
		this.ra = ra;
	}
	
	public String getCurso() {
		return this.curso;
	}
	
	public void setCurso(String curso) {
		this.curso = curso;
	}
	
	public void setNum_emprestimos(short num_emprestimos) {
		this.num_emprestimos = num_emprestimos;
	}
	
	public short getNum_emprestimos() {
		return this.num_emprestimos;
	}
	
	public Emprestimo[] getEmprestimos() {
		return this.emprestimos;
	}
	
}
