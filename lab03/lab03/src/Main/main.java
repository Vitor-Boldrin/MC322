package Main;

import Pessoa.Membro;
import Pessoa.Funcionario;
import Biblioteca.Biblioteca;
import Biblioteca.Item_multimidia;
import Biblioteca.Relatorio;

import Controle_Itens.Emprestimo;
import Controle_Itens.Reserva;

public class main {

	public static void main(String[] args) {
		
		// Criando objetos
		
		Biblioteca BIMECC = new Biblioteca("BIMECC");
		
		Relatorio Relatorio = new Relatorio("chatGPT",BIMECC);
	
		Membro Vitor = new Membro(
				"Vitor Boldrin",
				"65 98152 7404",
				"vitor.boldrin7@gmail.com",
				"07808918130",
				"245500",
				"Matematica Aplicada",
				"Graduação"
				);
		
		Funcionario Ze = new Funcionario(
				"Ze",
				"-",
				"-",
				"-",
				"5456",
				"Bibliotecario",
				5700
				);
		
		Membro Nuggets = new Membro(
				"Guilherme Lenzolari",
				"12 94255 4689",
				"-",
				"-",
				"174520",
				"Engenharia Quimica",
				"Graduação"
				);
		
		Item_multimidia Livro_1 = new Item_multimidia(
				"1",
				"spivak",
				"Calculo 1",
				"1",
				(short)2010,
				"Livro",
				(byte)1
				);
		
		Item_multimidia Livro_2 = new Item_multimidia(
				"2",
				"reginaldo",
				"GA",
				"1",
				(short)2009,
				"Livro",
				(byte)1
				);
		
		Item_multimidia Livro_3 = new Item_multimidia(
				"3",
				"R R Martin",
				"Game of Thrones",
				"1",
				(short)2005,
				"Livro",
				(byte)1
				);
		
		// Adicionando objetos à Biblioteca:
		
		BIMECC.getFuncionario().add(Ze);
		BIMECC.getMembro().add(Nuggets);
		BIMECC.getMembro().add(Vitor);
		BIMECC.getItem_multimidia().add(Livro_3);
		BIMECC.getItem_multimidia().add(Livro_2);
		BIMECC.getItem_multimidia().add(Livro_1);
		
		// Criando iterações
		
		System.out.println("TESTES 1 -------------------------------------------------------");
		
		Reserva reserva_1 = new Reserva(Livro_1, Nuggets);
		Nuggets.reserva_item_multimidia(reserva_1);
		
		// Tenta emprestar item do amiguinho
		
		Emprestimo emprestimo_1 = new Emprestimo(Livro_1,Vitor);
		Ze.empresta_item_multimidia(emprestimo_1);
		
		System.out.println("Como podemos ver, o item não pode ser emprestado pelo Vitor, tentando então com o nuggets:");
		
		Emprestimo emprestimo_2 = new Emprestimo(Livro_1, Nuggets);
		Ze.empresta_item_multimidia(emprestimo_2);
		
		System.out.println("Vitor ficou de mal e decidiu reservar todos os outros livros");
		
		Emprestimo emprestimo_3 = new Emprestimo(Livro_2, Vitor);
		Ze.empresta_item_multimidia(emprestimo_3);
		
		Emprestimo emprestimo_4 = new Emprestimo(Livro_3, Vitor);
		Ze.empresta_item_multimidia(emprestimo_4);
		
		System.out.println("Maravilha, vamos então ver os status dos nossos livros, reservas e emprestimos");
		Relatorio.relatorio_membros();
		System.out.println("Relatorio Items:");
		Relatorio.relatorio_itens();
		
		System.out.println("Vamos limpar a bagunça e devolver todos os livros");
		System.out.println(" ");
		
		Vitor.devolve_item_multimidia(Livro_3);
		Vitor.devolve_item_multimidia(Livro_2);
		
		Nuggets.devolve_item_multimidia(Livro_1);
		
		System.out.println("Checando mais uma vez a situacao");
		Relatorio.relatorio_membros();
		
		System.out.println("TESTES 2 -------------------------------------------------------");
		
		// Construindo uma outra configuração de emprestimos
		// E acompanhando o staus do livro
		System.out.println(Livro_1.getStatus()); // Livro disponível
		
		//Vitor empresta
		Emprestimo emprestimo_5 = new Emprestimo(Livro_1, Vitor);
		Ze.empresta_item_multimidia(emprestimo_5);
		System.out.println(Livro_1.getStatus()); // Livro emprestado
		
		//Nuggets reserva
		Reserva reserva_2 = new Reserva(Livro_1, Nuggets);
		Nuggets.reserva_item_multimidia(reserva_2);
		System.out.println(Livro_1.getStatus()); // Livro emprestado e reservado
		
		//Vitor devolve
		Vitor.devolve_item_multimidia(Livro_1);
		System.out.println(Livro_1.getStatus()); // Lirvo reservado
		
		//Nuggets empresta
		Emprestimo emprestimo_6 = new Emprestimo(Livro_1, Nuggets);
		Ze.empresta_item_multimidia(emprestimo_6);
		System.out.println(Livro_1.getStatus()); // Livro emprestado
		
		System.out.println(" ");
		System.out.println("Checando status dos livros:");
		
		Relatorio.relatorio_itens();
	}

}
