package Main;

import Livros.Livro;
import pessoa.Estudante;
import pessoa.Funcionario;
import pessoa.Pessoa;
import Controle_Livros.Emprestimo;

public class main {
	
	/*
	 * Lab02 Contém as classes mais essenciais para o funcionamento
	 * de uma biblioteca. Estudantes para emprestar livros, e livros para serem
	 * Emprestados.
	 * 
	 * Nessa segunda versão foi aperfeiçoado o sistema de emprestimo de livros, que
	 * agora, os emprestimos são armazenados em listas e em cima dessas listas foi
	 * criado métodos para devolver e emprestar livros
	 * 
	 * Foi também aperfeiçoado os tipos dos dados necessários para as classes e
	 * revisto o tipo de modifier para os atributos e métodos.
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Criando as pessoas
		Estudante Estudante_Vitor = new Estudante("245500", "Matemática Aplicada");
		Funcionario Funcionario_Seu_Ze = new Funcionario("Bibliotecario", 50000);
		
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
		
		Livro GA_1 = new Livro("2",
					"Reginaldo",
					"Dor",
					(short)1,
					(short)2001,
					"Editora Unicamp"
					 );
		
		Emprestimo emprestimo_1 = new Emprestimo(Vitor.getEstudante(), Calculo_1);  // Cria emprestimo para o Vitor
		
		Ze.getFuncionario().empresta_livro(emprestimo_1); // Empresta Spivak pro Vitor
		
		Emprestimo emprestimo_2 = new Emprestimo(Vitor.getEstudante(), Calculo_1); // Cria mesmo emprestimo para o vitor
		
		Ze.getFuncionario().empresta_livro(emprestimo_2); // Tenta emprestar o mesmo emprestimo
		
		Emprestimo emprestimo_3 = new Emprestimo(Vitor.getEstudante(), GA_1); // Cria segundo emprestimo válido para o vitor
		
		Ze.getFuncionario().empresta_livro(emprestimo_3); // Dá o segundo emprestimo
		
		Vitor.getEstudante().devolve_emprestimo(emprestimo_1); // Devolve o primeiro emprestimo
		
		System.out.println(Calculo_1.getStatus()); // Testa status do livro devolvido
		
		
	}

}
