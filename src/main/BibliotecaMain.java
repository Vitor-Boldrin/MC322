package main;

import biblioteca.controllers.*;
import biblioteca.models.BibliotecaStatic.BibliotecaStatic;
import biblioteca.models.ItemMultimidia.ItemMultimidia;
import biblioteca.models.Membro.Estudante_graduacao;
import biblioteca.models.Membro.Estudante_pos;
import biblioteca.models.Membro.Funcionario;
import biblioteca.models.Membro.Membro;
import biblioteca.models.Membro.Nivel_acesso;
import biblioteca.views.*;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class BibliotecaMain {
    private static BibliotecaController bibliotecaController;
    private static MembroController membroController;
    private static RelatorioController relatorioController;

    public static void main(String[] args) {
        bibliotecaController = new BibliotecaControllerImpl();
        membroController = new MembroControllerImpl();
        relatorioController = new RelatorioControllerImpl();

        BibliotecaView bibliotecaView = new BibliotecaViewImpl(bibliotecaController);
        MembroView membroView = new MembroViewImpl(membroController);
        RelatorioView relatorioView = new RelatorioViewImpl(relatorioController);

        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("---- Menu Biblioteca ----");
            System.out.println();
            System.out.println("1. Gerenciamento de Itens");
            System.out.println("2. Gerenciamento de Membros");
            System.out.println("3. Geração de Relatórios e Estatísticas");
            System.out.println("4. Administração de Funcionários");
            System.out.println("5. Sair");
            System.out.println();
            System.out.println();
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    // Menu de Gerenciamento de Itens
                    menuGerenciamentoItens(scanner, bibliotecaView);
                    break;
                case 2:
                    // Menu de Gerenciamento de Membros
                    menuGerenciamentoMembros(scanner, membroView);
                    break;
                case 3:
                    // Menu de Geração de Relatórios e Estatísticas
                    menuRelatoriosEstatisticas(scanner, relatorioView);
                    break;
                case 4:
                    // Menu de Administração de Funcionários
                    menuAdministracaoFuncionarios(scanner);
                    break;
                case 5:
                    System.out.println("Saindo do menu. Até logo!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida. Por favor, escolha novamente.");
            }
        }
    }

    private static void menuGerenciamentoItens(Scanner scanner, BibliotecaView bibliotecaView) {
        while (true) {
            System.out.println("---- Menu Gerenciamento de Itens ----");
            System.out.println();
            System.out.println("1. Listar Itens Disponíveis");
            System.out.println("2. Adicionar Item");
            System.out.println("3. Editar Item");
            System.out.println("4. Remover Item");
            System.out.println("5. Empréstimo de Itens");
            System.out.println("6. Renovação de Empréstimos");
            System.out.println("7. Reservas de Itens");
            System.out.println("8. Voltar");
            System.out.println();
            System.out.println();
            System.out.print("Escolha uma opção: ");

            int opcaoItens = scanner.nextInt();
            scanner.nextLine();

            switch (opcaoItens) {
                case 1:
                    List<ItemMultimidia> itens = bibliotecaController.consultarItensDisponiveis();
                    bibliotecaView.mostrarItensDisponiveis(itens);
                    break;
                case 2:
                    adicionarItem(scanner);
                    break;
                case 3:
                    editarItem(scanner);
                    break;
                case 4:
                    removerItem(scanner);
                    break;
                case 5:
                    realizarEmprestimo(scanner);
                    break;
                case 6:
                    realizarRenovacao(scanner);
                    break;
                case 7:
                    fazerReserva(scanner);
                    break;
                case 8:
                    return;
                default:
                    System.out.println("Opção inválida. Por favor, escolha novamente.");
            }
        }
    }

    private static void menuGerenciamentoMembros(Scanner scanner, MembroView membroView) {
        while (true) {
            System.out.println("---- Menu Gerenciamento de Membros ----");
            System.out.println();
            System.out.println("1. Listar Membros");
            System.out.println("2. Adicionar Membro");
            System.out.println("3. Editar Membro");
            System.out.println("4. Remover Membro");
            System.out.println("5. Voltar");
            System.out.println();
            System.out.println();
            System.out.print("Escolha uma opção: ");

            int opcaoMembros = scanner.nextInt();
            scanner.nextLine();

            switch (opcaoMembros) {
                case 1:
                    List<Membro> membros = membroController.listarMembros();
                    membroView.mostrarListaMembros(membros);
                    break;
                case 2:
                    adicionarMembro(scanner);
                    break;
                case 3:
                    editarMembro(scanner);
                    break;
                case 4:
                    removerMembro(scanner);
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Opção inválida. Por favor, escolha novamente.");
            }
        }
    }

    private static void menuRelatoriosEstatisticas(Scanner scanner, RelatorioView relatorioView) {
        while (true) {
            System.out.println("---- Menu Relatórios e Estatísticas ----");
            System.out.println();
            System.out.println("1. Gerar Relatório de Atividades de Membros");
            System.out.println("2. Gerar Relatório de Uso de Itens Multimídia");
            System.out.println("3. Gerar Relatório de Multas e Pagamentos");
            System.out.println("4. Gerar Relatório de Disponibilidade de Itens");
            System.out.println("5. Gerar Estatísticas de Uso por Perfil de Membro");
            System.out.println("6. Gerar Relatório de Itens Mais Populares");
            System.out.println("7. Voltar");
            System.out.println();
            System.out.println();
            System.out.print("Escolha uma opção: ");

            int opcaoRelatorios = scanner.nextInt();
            scanner.nextLine();

            switch (opcaoRelatorios) {
                case 1:
                    gerarRelatorioAtividadesMembros();
                    break;
                case 2:
                    gerarRelatorioUsoItens();
                    break;
                case 3:
                    gerarRelatorioMultas();
                    break;
                case 4:
                    gerarRelatorioDisponibilidadeItens();
                    break;
                case 5:
                    gerarEstatisticasUsoPorPerfil();
                    break;
                case 6:
                    gerarRelatorioItensPopulares();
                    break;
                case 7:
                    return;
                default:
                    System.out.println("Opção inválida. Por favor, escolha novamente.");
            }
        }
    }

    private static void menuAdministracaoFuncionarios(Scanner scanner) {
        while (true) {
            System.out.println("---- Menu Administração de Funcionários ----");
            System.out.println();
            System.out.println("1. Administradores");
            System.out.println("2. Atendentes");
            System.out.println("3. Gerentes");
            System.out.println("4. Voltar");
            System.out.println();
            System.out.println();
            System.out.print("Escolha uma opção: ");

            int opcaoFuncionarios = scanner.nextInt();
            scanner.nextLine();

            switch (opcaoFuncionarios) {
                case 1:
                    // Menu de Administração de Administradores
                    menuAdministradores(scanner);
                    break;
                case 2:
                    // Menu de Administração de Atendentes
                    menuAtendentes(scanner);
                    break;
                case 3:
                    // Menu de Administração de Gerentes
                    menuGerentes(scanner);
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Opção inválida. Por favor, escolha novamente.");
            }
        }
    }

    private static void menuAdministradores(Scanner scanner) {
        // Lógica para administração de administradores
    }

    private static void menuAtendentes(Scanner scanner) {
        // Lógica para administração de atendentes
    }

    private static void menuGerentes(Scanner scanner) {
        // Lógica para administração de gerentes
    }

    // Métodos para realizar empréstimo, renovação e reserva
    private static void realizarEmprestimo(Scanner scanner) {
        // Lógica para realizar um empréstimo
        System.out.println("Operação de Empréstimo de Itens");
    }

    private static void realizarRenovacao(Scanner scanner) {
        // Lógica para realizar uma renovação de empréstimo
        System.out.println("Operação de Renovação de Empréstimos");
    }

    private static void fazerReserva(Scanner scanner) {
        // Lógica para fazer uma reserva de item
        System.out.println("Operação de Reserva de Itens");
    }

    // Métodos para adicionar, editar e remover itens e membros
    private static void adicionarItem(Scanner scanner) {
        // Lógica para adicionar um novo item
        System.out.println("Operação de Adição de Item");
    }

    private static void editarItem(Scanner scanner) {
        // Lógica para editar um item existente
        System.out.println("Operação de Edição de Item");
    }

    private static void removerItem(Scanner scanner) {
        // Lógica para remover um item
        System.out.println("Operação de Remoção de Item");
    }

    private static void adicionarMembro(Scanner scanner) {
    	System.out.println("Operação de Adição de Membro");
		System.out.println("----------------------------");
    	while(true) {

			System.out.println("Insira o tipo do membro:");
			System.out.println("");
			System.out.println("1. Estudante da Graduação");
			System.out.println("2. Estudante Pós");
			System.out.println("3. Funcionario");
			System.out.println("4. Professor");
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
					System.out.println("1. Administrador");
					System.out.println("2. Gerente");
					System.out.println("3. Atendente");
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
		        
		        System.out.println("Funcionário criado.");
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

    private static void editarMembro(Scanner scanner) {
        // Lógica para editar um membro existente
        System.out.println("Operação de Edição de Membro");
    }

    private static void removerMembro(Scanner scanner) {
        // Lógica para remover um membro
        System.out.println("Operação de Remoção de Membro");
    }

    // Métodos para gerar relatórios e estatísticas
    private static void gerarRelatorioAtividadesMembros() {
        //Printar membros existentes
    	
    	List<Membro> Membros = BibliotecaStatic.getMembros();
    	for( Membro membro : Membros) {
    		System.out.println(membro.getNome());
    	}
    	
        System.out.println("Gerando Relatório de Atividades de Membros");
    }

    private static void gerarRelatorioUsoItens() {
        // Lógica para gerar o Relatório de Uso de Itens Multimídia
        System.out.println("Gerando Relatório de Uso de Itens Multimídia");
    }

    private static void gerarRelatorioMultas() {
        // Lógica para gerar o Relatório de Multas e Pagamentos
        System.out.println("Gerando Relatório de Multas e Pagamentos");
    }

    private static void gerarRelatorioDisponibilidadeItens() {
        // Lógica para gerar o Relatório de Disponibilidade de Itens
        System.out.println("Gerando Relatório de Disponibilidade de Itens");
    }

    private static void gerarEstatisticasUsoPorPerfil() {
        // Lógica para gerar as Estatísticas de Uso por Perfil de Membro
        System.out.println("Gerando Estatísticas de Uso por Perfil de Membro");
    }

    private static void gerarRelatorioItensPopulares() {
        // Lógica para gerar o Relatório de Itens Mais Populares
        System.out.println("Gerando Relatório de Itens Mais Populares");
    }
}
