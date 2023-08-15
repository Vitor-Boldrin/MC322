package Controle_Livros;

import pessoa.Estudante;
import Livros.Livro;

public class Emprestimo {

	//Atributos da classe
	private Estudante estudante;
	private Livro livro;
	
	//Construtor
	public Emprestimo(Estudante estudante,
					  Livro livro) {
		this.estudante = estudante;
		this.livro = livro;
	}
	
	// Métodos
	
	public void atribui_emprestimo() {
		if (this.livro.pode_emprestar() == 1) { //Testa se o livro pode ser emprestado
			
			if (this.estudante.getNum_emprestimos() < this.estudante.getEmprestimos().length) { //Testa se tem espaço para novos emprestimos
				this.estudante.getEmprestimos()[this.estudante.getNum_emprestimos()] = this; // Novo emprestimo no estudante apontando para o proprio objeto Emprestimo
				
				short Numero_de_emprestimos_atual = this.estudante.getNum_emprestimos(); // Adiciona o número total de emprestimos desse estudante
				this.estudante.setNum_emprestimos( (short)(Numero_de_emprestimos_atual + 1) );
				
				this.livro.setStatus("Emprestado"); //Seta o livro como emprestado
				System.out.println("Livro emprestado");
			} else {
				System.out.println("Estudante atingiu o número máximo de empréstimos.");
			}
			
		} else {
			System.out.println("O livro não pode ser emprestado");
		}
	} //REPETIR E ATRIBUIR AGORA O DEVOLVE O LIVRO;
	
	// Gatters e Setters
	public Estudante getEstudate() {
		return this.estudante;
	}
	
	public void setEstudante(Estudante estudante) {
		this.estudante = estudante;
	}
	
	public Livro getLivro() {
		return this.livro;
	}
	
	public void setLivro(Livro livro) {
		this.livro = livro;
	}
	
}
