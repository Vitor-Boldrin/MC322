package main;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Iterator;
import java.util.Scanner;

import biblioteca.models.BibliotecaStatic.BibliotecaStatic;
import biblioteca.models.ItemMultimidia.ItemMultimidia;
import biblioteca.models.Membro.*;

public class MainTestes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Chama");
		
		Scanner scanner = new Scanner(System.in);
		
		
		
		while(true) {
		
			System.out.println("Insira o tipo do membro:");
			System.out.println("");
			System.out.println("Estudante da Graduação (1)");
			System.out.println("Estudante Pós (2)");
			System.out.println("Funcionario (3)");
			System.out.println("Professor (4)");
			System.out.println("");
			System.out.print("Digite o número: ");
			
		    int codigo = scanner.nextInt();
		    scanner.nextLine();
		    
		    switch (codigo) {
		    case 1:
		        System.out.println("Estudante da graduação");
		        System.out.println("----------------------");
		        
		        //Instancia as variáveis do aluno
		        System.out.print("Nome do estudante: ");
		        String nome1 = scanner.nextLine();
		        System.out.print("RA do estudante: ");
		        String id_faculdade1 = scanner.nextLine();
		        System.out.print("Endereço do estudante: ");
		        String endereco1 = scanner.nextLine();
		        System.out.print("Contato: ");
		        String contato1 = scanner.nextLine();
		        Date data1 = new Date();
		        
		        // Cria objeto
		        Estudante_graduacao aluno1 = new Estudante_graduacao(
		        		nome1,
		        		id_faculdade1,
		        		endereco1,
		        		contato1,
						data1);
		        
		        //Armazena na biblioteca
		        BibliotecaStatic.getMembros().add(aluno1);
		        
		        System.out.println("Estudante criado.");
		        
		        return;
		    case 2:
		    	System.out.println("Estudante da pós");
		    	System.out.println("----------------------");
		        
		        //Instancia as variáveis do aluno
		        System.out.print("Nome do estudante: ");
		        String nome2 = scanner.nextLine();
		        System.out.print("RA do estudante: ");
		        String id_faculdade2 = scanner.nextLine();
		        System.out.print("Endereço do estudante: ");
		        String endereco2 = scanner.nextLine();
		        System.out.print("Contato: ");
		        String contato2 = scanner.nextLine();
		        Date data2 = new Date();
		        
		        // Cria objeto
		        Estudante_pos aluno2 = new Estudante_pos(
		        		nome2,
		        		id_faculdade2,
		        		endereco2,
		        		contato2,
						data2);
		        
		        //Armazena na biblioteca
		        BibliotecaStatic.getMembros().add(aluno2);
		        
		        System.out.println("Estudante criado.");
		    	return;
		    case 3:
		    	System.out.println("Funcionario");
		    	System.out.println("----------------------");
		        
		        //Instancia as variáveis do aluno
		        System.out.print("Nome do funcionario: ");
		        String nome3 = scanner.nextLine();
		        System.out.print("ID do funcionario: ");
		        String id_faculdade3 = scanner.nextLine();
		        System.out.print("Endereço do funcionario: ");
		        String endereco3 = scanner.nextLine();
		        System.out.print("Contato: ");
		        String contato3 = scanner.nextLine();
		        Date data3 = new Date();
		        
		      //Set do nível do funcionario
		        
		        Nivel_acesso nivel_acesso = Nivel_acesso.ADMINISTRADOR; //Inicializando, pois a IDLE está reclamando
		        
		        int aux = 0;
		        while(aux == 0) {
				    
				    System.out.println("Insira o nível do funcionario:");
					System.out.println("");
					System.out.println("Administrador (1)");
					System.out.println("Gerente (2)");
					System.out.println("Atendente (3)");
					System.out.println("");
					System.out.print("Digite o número: ");
					
					int codigo_funcionario = scanner.nextInt();
				    scanner.nextLine();
					
					switch (codigo_funcionario) {
					case 1:
						nivel_acesso = Nivel_acesso.ADMINISTRADOR;
						aux++;
						break;
					case 2:
						nivel_acesso = Nivel_acesso.ATENDETE;
						aux++;
						break;
					case 3:
						nivel_acesso = Nivel_acesso.GERENTE;
						aux++;
						break;
					default:
				        System.out.print("Opção inválida. Por favor, escolha novamente: ");
					}
				    
		        }
		        
		        // Cria objeto
		        Funcionario funcionario = new Funcionario(
		        		nome3,
		        		id_faculdade3,
		        		endereco3,
		        		contato3,
						data3,
						nivel_acesso);
		        
		        //Armazena na biblioteca
		        BibliotecaStatic.getMembros().add(funcionario);
		        
		        System.out.println("Funcionario criado.");
		    	return;
		    case 4:
		    	System.out.println("Professor");
		        System.out.println("----------------------");
		        
		        //Instancia as variáveis do aluno
		        System.out.print("Nome do professor: ");
		        String nome4 = scanner.nextLine();
		        System.out.print("Matricula do professor: ");
		        String id_faculdade4 = scanner.nextLine();
		        System.out.print("Endereço do professor: ");
		        String endereco4 = scanner.nextLine();
		        System.out.print("Contato: ");
		        String contato4 = scanner.nextLine();
		        Date data4 = new Date();
		        
		        // Cria objeto
		        Estudante_graduacao professor = new Estudante_graduacao(
		        		nome4,
		        		id_faculdade4,
		        		endereco4,
		        		contato4,
						data4);
		        
		        //Armazena na biblioteca
		        BibliotecaStatic.getMembros().add(professor);
		        
		        System.out.println("Professor criado.");
		        
		        return;
		    default:
		        System.out.print("Opção inválida. Por favor, escolha novamente: ");
		    }
        
		}
		
	}

}
