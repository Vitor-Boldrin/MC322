package Main;

import Livros.Livro;
import pessoa.Estudante;
import pessoa.Funcionario;
import pessoa.Pessoa;

public class main {
	
	/*
	 * Lab01 Contém as classes mais essenciais para o funcionamento
	 * de uma biblioteca. Estudantes para emprestar livros, e livros para serem
	 * Emprestados.
	 * 
	 * Nessa primeita versão o laboratório suporta um sistema simples
	 * em que o estudante pode emprestar livros e devolvelos.
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Criando as pessoas
		Estudante Estudante_Vitor = new Estudante("245500", "Matemática Aplicada");
		Funcionario Funcionario_Seu_Ze = new Funcionario("Bibliotecario", 2000);
		
		Pessoa Vitor = new Pessoa("Vitor Boldrin",
								  "65 98152 7405",
								  "078.089.182-34",
								  "v245500@dac.unicamp.br",
								  Estudante_Vitor,
								  null);
		
		Pessoa Ze = new Pessoa("Jose",
				  "19 97232 5435",
				  "448.462.780-32",
				  "z153306@dac.unicamp.br",
				  null,
				  Funcionario_Seu_Ze);
		
		// Criando livros
		Livro Calculo_1 = new Livro("1",
				 					"Spivak",
									"Dor",
									(short)1,
									(short)1999,
									"Editora Unicamp"
									 );
		
		// Emprestando o livro
		Vitor.getEstudante().empresta_livro(Calculo_1);
		
		//Tenta emprestar o livro novamente
		Vitor.getEstudante().empresta_livro(Calculo_1);
		
		//Devolve o livro
		Vitor.getEstudante().devolve_livro(Calculo_1);
		
		//Empresta novamente
		Vitor.getEstudante().empresta_livro(Calculo_1);
		
		//Devolve novamente
		Vitor.getEstudante().devolve_livro(Calculo_1);
		
		//Finalizado lab01
		
	}

}
