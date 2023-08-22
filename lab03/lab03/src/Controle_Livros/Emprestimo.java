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
