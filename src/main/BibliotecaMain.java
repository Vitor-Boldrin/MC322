package main;

import biblioteca.controllers.*;
import biblioteca.metadados.CReflection;
import biblioteca.models.BibliotecaStatic.BibliotecaStatic;
import biblioteca.models.BibliotecaStatic.ItemBiblioteca;
import biblioteca.models.Controle_livros.Emprestimo;
import biblioteca.models.Controle_livros.Reserva;
import biblioteca.models.Excecao.ExcecaoEmprestimo;
import biblioteca.models.Excecao.ExcecaoIdJaCadastrado;
import biblioteca.models.Excecao.ExcecaoReservaSala;
import biblioteca.models.Excecao.ExcecaoUsuarioeouSenhaInvalido;
import biblioteca.models.Excecao.ExecaoDevolucaoItemNaoEmprestado;
import biblioteca.models.Item.Item;
import biblioteca.models.ItemMultimidia.CD_de_audio;
import biblioteca.models.ItemMultimidia.DVD_de_video;
import biblioteca.models.ItemMultimidia.EstadoItemMultimidia;
import biblioteca.models.ItemMultimidia.ItemMultimidia;
import biblioteca.models.ItemMultimidia.Livro_eletronico;
import biblioteca.models.ItemMultimidia.Livro_fisico;
import biblioteca.models.ItemMultimidia.Outros_itens_multimidia;
import biblioteca.models.ItemMultimidia.StatusItem;
import biblioteca.models.Membro.Estudante_graduacao;
import biblioteca.models.Membro.Estudante_pos;
import biblioteca.models.Membro.Funcionario;
import biblioteca.models.Membro.Membro;
import biblioteca.models.Membro.Nivel_acesso;
import biblioteca.models.Membro.Professor;
import biblioteca.models.Recursos_Biblioteca.SalaBiblioteca.Sala;
import biblioteca.models.Recursos_Biblioteca.SalaBiblioteca.SalaGrupo;
import biblioteca.models.Recursos_Biblioteca.SalaBiblioteca.SalaIndividual;
import biblioteca.models.Recursos_Biblioteca.SalaBiblioteca.SalaMultimidia;
import biblioteca.models.Recursos_Biblioteca.SalaBiblioteca.SalaSilenciosa;
import biblioteca.views.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class BibliotecaMain {
    private static BibliotecaController bibliotecaController;
    private static MembroController membroController;
    private static RelatorioController relatorioController;
    private static ItemBiblioteca<Item> bibliotecaItemBiblioteca;

    public static void main(String[] args) {
        bibliotecaController = new BibliotecaControllerImpl();
        membroController = new MembroControllerImpl();
        relatorioController = new RelatorioControllerImpl();
        bibliotecaItemBiblioteca = new ItemBiblioteca<Item>();

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
            System.out.println("8. Devolução de Itens");
            System.out.println("9. Voltar");
            System.out.println();
            System.out.println();
            System.out.print("Escolha uma opção: ");

            int opcaoItens = scanner.nextInt();
            scanner.nextLine();

            switch (opcaoItens) {
                case 1:
                    List<Item> itens = BibliotecaStatic.getItens();
                    BibliotecaViewImpl bibliotecaViewImpl = new BibliotecaViewImpl(bibliotecaController);
                    bibliotecaViewImpl.mostrarItensDisponiveis(itens);
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
                case 8: //blabla
                	try{
                		devolverMainItem(scanner);
                	}
                	catch(ExecaoDevolucaoItemNaoEmprestado e) {
                		System.err.println("----- A OPERAÇÃO FOI BLOQUEADA -----");
                		System.err.println(e.getMessage());
                	}
                case 9:
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
    	Funcionario funcionario = (Funcionario) membroController.efetuaLogin(scanner);
    	
    	try {
    		if(funcionario == null) {
	    		throw new ExcecaoUsuarioeouSenhaInvalido("Usuário ou senha inválido.");
    		} else if(! funcionario.getNivel_acesso().equals(Nivel_acesso.ADMINISTRADOR)) {
    			throw new ExcecaoUsuarioeouSenhaInvalido("Usuário sem permissão para acessar o menu selecionado.");
    		}
	    } catch(ExcecaoUsuarioeouSenhaInvalido e) {
	    		System.err.println(e.getMessage());
	    		System.out.println("Retornando.");
    	}
    	
    	System.out.println("Login realizado com sucesso.");
    	
    	while (true) {
            System.out.println("---- Menu Adminstração ----");
            System.out.println();
            System.out.println("1. Metadados - Atributos Membros e Itens Multimidia");
            System.out.println("2. Metadados - Métodos Membros e Itens Multimidia");
            System.out.println("4. Voltar");
            System.out.println();
            System.out.println();
            System.out.print("Escolha uma opção: ");

            int opcaoFuncionarios = scanner.nextInt();
            scanner.nextLine();

            switch (opcaoFuncionarios) {
                case 1:
                    // Menu de Administração de Administradores
                	menuAdministradoresMetadadosAtributos(scanner);
                    break;
                case 2:
                    // Menu de Administração de Atendentes
                	menuAdministradoresMetadadosMetodos(scanner);
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Opção inválida. Por favor, escolha novamente.");
            }
        }
    	
    	
    }
    
    private static void menuAdministradoresMetadadosMetodos(Scanner scanner) {
    	CReflection ref = new CReflection();
		ref.ImprimeMetodos(BibliotecaStatic.getMembros(), BibliotecaStatic.getItens());
    }
    
    private static void menuAdministradoresMetadadosAtributos(Scanner scanner) {
    	CReflection ref = new CReflection();
	    try {
			ref.ImprimiAtributos(BibliotecaStatic.getMembros(), BibliotecaStatic.getItens());
		} catch (IllegalArgumentException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    private static void menuAtendentes(Scanner scanner) {
        // Lógica para administração de atendentes
    	Funcionario funcionario = (Funcionario) membroController.efetuaLogin(scanner);
    	
    	try {
    		if(funcionario == null) {
	    		throw new ExcecaoUsuarioeouSenhaInvalido("Usuário ou senha inválido.");
    		} else if(! funcionario.getNivel_acesso().equals(Nivel_acesso.ATENDETE)) {
    			throw new ExcecaoUsuarioeouSenhaInvalido("Usuário sem permissão para acessar o menu selecionado.");
    		}
	    } catch(ExcecaoUsuarioeouSenhaInvalido e) {
	    		System.err.println(e.getMessage());
	    		System.out.println("Retornando.");
    	}
    	
    	System.out.println("Login realizado com sucesso.");
    }

    private static void menuGerentes(Scanner scanner) {
        // Lógica para administração de gerentes
    	Funcionario funcionario = (Funcionario) membroController.efetuaLogin(scanner);
    	
    	try {
    		if(funcionario == null) {
	    		throw new ExcecaoUsuarioeouSenhaInvalido("Usuário ou senha inválido.");
    		} else if(! funcionario.getNivel_acesso().equals(Nivel_acesso.GERENTE)) {
    			throw new ExcecaoUsuarioeouSenhaInvalido("Usuário sem permissão para acessar o menu selecionado.");
    		}
	    } catch(ExcecaoUsuarioeouSenhaInvalido e) {
	    		System.err.println(e.getMessage());
	    		System.out.println("Retornando.");
    	}
    	
    	System.out.println("Login realizado com sucesso.");
    }

    // Métodos para realizar empréstimo, renovação e reserva
    private static void realizarEmprestimo(Scanner scanner) {
        // Lógica para realizar um empréstimo
        System.out.println("Operação de Empréstimo de Itens");
        
        //Primeiro, colentado os objetos, ITEM e MEMBRO
        System.out.print("Insira o ID do membro requisitando o empréstimo:");
    	String id_membro = scanner.nextLine();
    	Membro membro = membroController.buscarMembroPorIdentificacao(id_membro);
    	
    	System.out.print("Insira o ID do livro a ser emprestado:");
    	int id_livro = scanner.nextInt();
    	scanner.nextLine(); //captura o \n
    	Item item = bibliotecaController.buscarItenPorIdentificacao(id_livro);
    	
    	// Joga na função e boa
    	try {
    		bibliotecaItemBiblioteca.emprestarItem(membro, item);
    	} catch (ExcecaoEmprestimo e) {
    		System.err.println("----- A OPERAÇÃO FOI BLOQUEADA -----");
    		System.err.println("Alguma regra para o emprestimo do item foi violada");
    		System.err.println(e.getMessage());
    	}
    }

    private static void realizarRenovacao(Scanner scanner) {
        // Lógica para realizar uma renovação de empréstimo
        System.out.println("Operação de Renovação de Empréstimos");
    }

    private static void fazerReserva(Scanner scanner) {
    	
    	while (true) {
            System.out.println("---- Menu Reserva de Itens ----");
            System.out.println("Selecione o que deseja reservar.");
            System.out.println();
            System.out.println("1. Item/Equipamento/Recurso");
            System.out.println("2. Sala");
            System.out.println();
            System.out.println();
            System.out.print("Escolha uma opção: ");

            int opcaoItens = scanner.nextInt();
            scanner.nextLine();

            switch (opcaoItens) {
                case 1:
                	// Lógica para fazer uma reserva de item
                    System.out.println("Operação de Reserva de Itens");
                    //Primeiro, colentado os objetos, ITEM e MEMBRO
                    System.out.print("Insira o ID do membro que está reservando o item:");
                	String id_membro = scanner.nextLine();
                	Membro membro = membroController.buscarMembroPorIdentificacao(id_membro);
                	
                	System.out.print("Insira o ID do livro a ser reservado:");
                	int id_livro = scanner.nextInt();
                	scanner.nextLine(); //captura o \n
                	Item item = bibliotecaController.buscarItenPorIdentificacao(id_livro);
                	
                	//Confirma se é uma sala
                	if( (item instanceof Sala) ) {
                		System.out.println("O ID selecionado não é um item/recurso/equipamento.");
                		System.out.println("Operação Cancelada.");
                		return;
                	}
                	
                    bibliotecaItemBiblioteca.reservarItem(membro, item);
                case 2:
                	// Lógica para fazer uma reserva de sala
                    System.out.println("Operação de Reserva de Itens");
                    //Primeiro, colentado os objetos, SALA e MEMBRO
                    System.out.print("Insira o ID do membro que está reservando o item:");
                	String id_membro2 = scanner.nextLine();
                	Membro membro2 = membroController.buscarMembroPorIdentificacao(id_membro2);
                	
                	System.out.print("Insira o ID da sala a ser reservado:");
                	int id_sala = scanner.nextInt();
                	scanner.nextLine(); //captura o \n
                	Item sala = bibliotecaController.buscarItenPorIdentificacao(id_sala);
                	
                	//Confirma se é uma sala
                	if( !(sala instanceof Sala) ) {
                		System.out.println("O ID selecionado não é uma sala.");
                		System.out.println("Operação Cancelada.");
                		return;
                	}
                	
                	LocalDateTime dateTimeFinal;LocalDateTime dateTimeInicio;
                	while(true) {
                		System.out.print("Insira o dia do inicio da reserva (YYYY-MM-DD):");
                    	String dataInicio = scanner.nextLine();
                    	System.out.print("Insira o horário o inicio da reserva (HH:MM):");
                    	String horaInicio = scanner.nextLine();
                    	try {
                    		dateTimeInicio = LocalDateTime.parse(dataInicio + "T" + horaInicio + ":00");
                    	} catch(DateTimeParseException e) {
                    		System.out.println("As datas inseridas estão no formado errado.");
                    		System.out.println("Tente novamente.");
                    		continue;
                    	}
                    	
                    	System.out.print("Insira o dia do final da reserva (YYYY-MM-DD):");
                    	String dataFinal = scanner.nextLine();
                    	System.out.print("Insira o horário o final da reserva (HH:MM):");
                    	String horaFinal = scanner.nextLine();
                    	try {
                    		dateTimeFinal = LocalDateTime.parse(dataFinal + "T" + horaFinal + ":00");
                    	} catch(DateTimeParseException e) {
                    		System.out.println("As datas inseridas estão no formado errado.");
                    		System.out.println("Tente novamente.");
                    		continue;
                    	}
                    	
                    	if(dateTimeInicio.isAfter(dateTimeFinal)) {
                    		System.out.println("A data inicial não deve ser depois da data final.");
                    		System.out.println("Tente novamente");
                    		continue;
                    	}
                    	
                    	break;
                	}
                	
                	boolean auxAddItem1 = true;
    			    int numPessoas = 1;
    			    do {
    			        System.out.print("Número de pessoas que utilizaram a sala:");
    			        
    			        try {
    			        	numPessoas = scanner.nextInt();
    			        	scanner.nextLine();
    			        } catch(InputMismatchException e) {
    			        	System.out.println("Deve ser um número");
    			        	scanner.next();
    			        	continue;
    			        }
    			        if (numPessoas <= 0) {
    			        	System.out.println("O número de pessoas deve ser maior do que zero.");
    			        }
    			        
    			        auxAddItem1 = false;
    		        }while(auxAddItem1) ;
    			    
    			    if(sala instanceof SalaGrupo) {
    			    	if( ((SalaGrupo) sala).getCapacidade_maxima() <= numPessoas) {
    			    		System.out.println("O número de pessoas é maior que a capacidade máxima da sala.");
    			    		System.out.println("Operação cancelada.");
    			    		return;
    			    	}
    			    } else if(sala instanceof SalaIndividual) {
    			    	if(numPessoas != 1) {
    			    		System.out.println("A sala individual aceita apenas uma pessoa.");
    			    		System.out.println("Operação cancelada.");
    			    	}
    			    }
                	
                try {
                	bibliotecaItemBiblioteca.reservarSala(membro2, sala, dateTimeInicio, dateTimeFinal);
                	System.out.println("Sala reservada com sucesso.");
                	return;
                } catch(ExcecaoReservaSala e) {
                	System.err.println("A reserva não pode ser criada.");
                	System.err.println(e.getMessage());
                	System.out.println("A operação foi cancelada.");
                }
                default:
                    System.out.println("Opção inválida. Por favor, escolha novamente.");
            }
        }
    	
    }
    
    private static void devolverMainItem(Scanner scanner) throws ExecaoDevolucaoItemNaoEmprestado {
    	
    	//Primeiro, colentado os objetos, ITEM e MEMBRO
        System.out.print("Insira o ID do membro que está devolvendo o item:");
    	String id_membro = scanner.nextLine();
    	Membro membro = membroController.buscarMembroPorIdentificacao(id_membro);
    	
    	System.out.print("Insira o ID do livro a ser devolvido:");
    	int id_livro = scanner.nextInt();
    	scanner.nextLine(); //captura o \n
    	Item item = bibliotecaController.buscarItenPorIdentificacao(id_livro);
    	
    	bibliotecaItemBiblioteca.devolverItem(membro, item);
    }

    // Métodos para adicionar, editar e remover itens e membros
    private static void adicionarItem(Scanner scanner) {
    	while (true) {
            System.out.println("---- Menu Adição de Itens ----");
            System.out.println();
            System.out.println("1. Adicionar Item Multimidia");
            System.out.println("2. Adicionar Sala");
            System.out.println("3. Voltar");
            System.out.println();
            System.out.println();
            System.out.print("Escolha uma opção: ");

            int opcaoItens = scanner.nextInt();
            scanner.nextLine();

            switch (opcaoItens) {
                case 1:
                	adicionarItemMultimidia(scanner);
                    break;
                case 2:
                	adicionarSala(scanner);
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Opção inválida. Por favor, escolha novamente.");
            }
        }
    }
    
    // Métodos para adicionar, editar e remover itens e membros
    private static void adicionarItemMultimidia(Scanner scanner) {
        // Lógica para adicionar um novo item
        System.out.println("Operação de Adição de Item");
        System.out.println("----------------------------");
    	while(true) {

			System.out.println("Insira o tipo do ItemMultimidia:");
			System.out.println("");
			System.out.println("1. Livro Físico");
			System.out.println("2. Livro Eletronico");
			System.out.println("3. CD de Aúdico");
			System.out.println("4. DVD de Vídeo");
			System.out.println("5. Outros Itens Multimidia");
			System.out.println("");
			System.out.print("Digite o número: ");
			
		    int codigo = scanner.nextInt();
		    scanner.nextLine();
		    
		    
			switch (codigo) {
		    case 1:
		        System.out.println("Livro Físico");
		        System.out.println("----------------------");
		        
		        boolean auxAddItem1 = true;
		        int id1 = -1;
		        do {
			        //Instancia as variáveis do Item
			        System.out.print("ID do Livro:");
			        try {
			        	id1 = scanner.nextInt();
			        	scanner.nextLine();
			        } catch(InputMismatchException e) {
			        	System.out.println("O ID deve ser um número, tente novamente.");
			        	scanner.next();
			        	continue;
			        }
			         //capturar o \n
			        //Checa se o ID já existe na biblioteca para evitar duplicidades
			        try {
				        if(BibliotecaStatic.getItens_id().contains(id1)) {
				        	throw new ExcecaoIdJaCadastrado("ERRO: ID já cadastrado.");
				        }
			        } catch(ExcecaoIdJaCadastrado e) {
			        	System.err.println(e.getMessage());
			        	System.out.println("Tente outro ID.");
			        	continue;
			        }
			        auxAddItem1 = false;
		        }while(auxAddItem1) ;
		        
		        System.out.print("Título do Livro:");
		        String titulo1 = scanner.nextLine();
		        System.out.print("Autor:");
		        String autor1 = scanner.nextLine();
		        System.out.print("Editora:");
		        String editora1 = scanner.nextLine();
		        System.out.print("Ano:");
		        String ano1 = scanner.nextLine(); 
		        System.out.print("Genero:");
		        String genero1 = scanner.nextLine(); 
		        System.out.print("Sinopse:");
		        String sinopse1 = scanner.nextLine();
		        System.out.print("Capa:");
		        String capa1 = scanner.nextLine();
		        StatusItem status1 = StatusItem.DISPONIVEL;
		        System.out.print("ISBN:");
		        String isbn1 = scanner.nextLine();
		        
		        auxAddItem1 = true;
			    int edicao1 = 1;
			    do {
			        System.out.print("Edição:");
			        
			        try {
			        	edicao1 = scanner.nextInt();
			        	scanner.nextLine();
			        } catch(InputMismatchException e) {
			        	System.out.println("A edição deve ser um número, tente novamente.");
			        	scanner.next();
			        	continue;
			        }
			        if(edicao1 <= 0) {
			        	System.out.println("O número da edição não deve ser negativo, tente novamente.");
			        	continue;
			        }
			        
			        auxAddItem1 = false;
		        }while(auxAddItem1) ;
		        
		        System.out.print("Localização:");
		        String loc1 = scanner.nextLine();
		        
		        EstadoItemMultimidia estado1 = null;
		        auxAddItem1 = true;
		        do {
		        	System.out.print("Está em Bom Estado de Conservação?:(y/n):");
		        	try {
		        		String opcaoStatus1 = scanner.nextLine();
		        		if(opcaoStatus1.equals("y")) {
		        			estado1 = EstadoItemMultimidia.BOM;
		        		} else if(opcaoStatus1.equals("n")) {
		        			estado1 = EstadoItemMultimidia.MAU;
		        		} else {
		        			throw new InputMismatchException("Opção inválida.");
		        		}
		        	} catch (InputMismatchException e) {
		        		System.err.println(e.getMessage());
		        		System.out.println("Tente novamente.");
		        		continue;
		        	}
		        	auxAddItem1 = false;
		        } while(auxAddItem1);
	        		
		        // Cria objeto
		        Livro_fisico livro1 = new Livro_fisico(
		        		id1,
		        		titulo1,
		        		autor1,
		        		editora1,
		        		ano1,
		        		genero1,
		        		sinopse1,
		        		capa1,
		        		status1,
		        		isbn1,
		        		edicao1,
		        		loc1,
		        		estado1);
		        
		        
		        //Armazena na biblioteca
		        BibliotecaStatic.getItens().add(livro1);
		        //Armazena ID
		        BibliotecaStatic.getItens_id().add(id1);
		        
		        System.out.println("Livro Adicionado.");
		        
		        return;
		    case 2:
		    	System.out.println("Livro Eletrônico");
		        System.out.println("----------------------");
		        
		        //Instancia as variáveis do Item
		        boolean auxAddItem2 = true;
		        int id2 = -1;
		        do {
			        //Instancia as variáveis do Item
			        System.out.print("ID do Livro:");
			        try {
			        	id2 = scanner.nextInt();
			        	scanner.nextLine();
			        } catch(InputMismatchException e) {
			        	System.out.println("O ID deve ser um número, tente novamente.");
			        	scanner.next();
			        	continue;
			        }
			         //capturar o \n
			        //Checa se o ID já existe na biblioteca para evitar duplicidades
			        try {
				        if(BibliotecaStatic.getItens_id().contains(id2)) {
				        	throw new ExcecaoIdJaCadastrado("ERRO: ID já cadastrado.");
				        }
			        } catch(ExcecaoIdJaCadastrado e) {
			        	System.err.println(e.getMessage());
			        	System.out.println("Tente outro ID.");
			        	continue;
			        }
			        auxAddItem2 = false;
		        }while(auxAddItem2) ;
		        
		        System.out.print("Título do Livro:");
		        String titulo2 = scanner.nextLine();
		        System.out.print("Autor:");
		        String autor2 = scanner.nextLine();
		        System.out.print("Editora:");
		        String editora2 = scanner.nextLine();
		        System.out.print("Ano:");
		        String ano2 = scanner.nextLine(); 
		        System.out.print("Genero:");
		        String genero2 = scanner.nextLine(); 
		        System.out.print("Sinopse:");
		        String sinopse2 = scanner.nextLine();
		        System.out.print("Capa:");
		        String capa2 = scanner.nextLine();
		        StatusItem status2 = StatusItem.DISPONIVEL;
		        System.out.print("Formato:");
		        String formato2 = scanner.nextLine();
		        System.out.print("Formato Arquivo:");
		        String formato_arquivo2 = scanner.nextLine();
		        System.out.print("URL Acesso:");
		        String url_acesso2 = scanner.nextLine();
		        System.out.print("Requisitos Leitura:");
		        String requisitos_leitura2 = scanner.nextLine();
		        Date data_disponibilidades2 = new Date();
		        
		        // Cria objeto
		        Livro_eletronico livro2 = new Livro_eletronico(
		        		id2,
		        		titulo2,
		        		autor2,
		        		editora2,
		        		ano2,
		        		genero2,
		        		sinopse2,
		        		capa2,
		        		status2,
		        		formato2,
		        		formato_arquivo2,
		        		url_acesso2,
		        		requisitos_leitura2,
		        		data_disponibilidades2);
		        
		        
		        //Armazena na biblioteca
		        BibliotecaStatic.getItens().add(livro2);
		        //Armazena ID
		        BibliotecaStatic.getItens_id().add(id2);
		        
		        System.out.println("Livro Eletrônico Adicionado.");
		        
		    	return;
		    case 3:
		    	System.out.println("CD de Áudio");
		        System.out.println("----------------------");
		        
		        //Instancia as variáveis do Item
		        boolean auxAddItem3 = true;
		        int id3 = -1;
		        do {
			        //Instancia as variáveis do Item
			        System.out.print("ID do Livro:");
			        try {
			        	id2 = scanner.nextInt();
			        	scanner.nextLine();
			        } catch(InputMismatchException e) {
			        	System.out.println("O ID deve ser um número, tente novamente.");
			        	scanner.next();
			        	continue;
			        }
			         //capturar o \n
			        //Checa se o ID já existe na biblioteca para evitar duplicidades
			        try {
				        if(BibliotecaStatic.getItens_id().contains(id3)) {
				        	throw new ExcecaoIdJaCadastrado("ERRO: ID já cadastrado.");
				        }
			        } catch(ExcecaoIdJaCadastrado e) {
			        	System.err.println(e.getMessage());
			        	System.out.println("Tente outro ID.");
			        	continue;
			        }
			        auxAddItem3 = false;
		        }while(auxAddItem3) ;
		        
		        System.out.print("Título do CD:");
		        String titulo3 = scanner.nextLine();
		        System.out.print("Autor:");
		        String autor3 = scanner.nextLine();
		        System.out.print("Editora:");
		        String editora3 = scanner.nextLine();
		        System.out.print("Ano:");
		        String ano3 = scanner.nextLine(); 
		        System.out.print("Genero:");
		        String genero3 = scanner.nextLine(); 
		        System.out.print("Sinopse:");
		        String sinopse3 = scanner.nextLine();
		        System.out.print("Capa:");
		        String capa3 = scanner.nextLine();
		        StatusItem status3 = StatusItem.DISPONIVEL;
		        System.out.print("Lista de Faixas:");
		        String lista_de_faixas3 = scanner.nextLine();
		        
		        auxAddItem3 = true;
			    int duracao3 = 1;
			    do {
			        System.out.print("Duração em Segundos:");
			        
			        try {
			        	duracao3 = scanner.nextInt();
			        	scanner.nextLine();
			        } catch(InputMismatchException e) {
			        	System.out.println("A duração deve ser um número, tente novamente.");
			        	scanner.next();
			        	continue;
			        }
			        if(duracao3 <= 0) {
			        	System.out.println("O tempo de duração não deve ser negativo, tente novamente.");
			        	continue;
			        }
			        
			        auxAddItem3 = false;
		        }while(auxAddItem3) ;
		        
		        EstadoItemMultimidia estado_de_conservacao3 = null;
		        auxAddItem3 = true;
		        do {
		        	System.out.print("Está em Bom Estado de Conservação?:(y/n):");
		        	try {
		        		String opcaoStatus3 = scanner.nextLine();
		        		if(opcaoStatus3.equals("y")) {
		        			estado_de_conservacao3 = EstadoItemMultimidia.BOM;
		        		} else if(opcaoStatus3.equals("n")) {
		        			estado_de_conservacao3 = EstadoItemMultimidia.MAU;
		        		} else {
		        			throw new InputMismatchException("Opção inválida.");
		        		}
		        	} catch (InputMismatchException e) {
		        		System.err.println(e.getMessage());
		        		System.out.println("Tente novamente.");
		        		continue;
		        	}
		        	auxAddItem3 = false;
		        } while(auxAddItem3);
		        
		        // Cria objeto
		        CD_de_audio livro3 = new CD_de_audio(
		        		id3,
		        		titulo3,
		        		autor3,
		        		editora3,
		        		ano3,
		        		genero3,
		        		sinopse3,
		        		capa3,
		        		lista_de_faixas3,
		        		duracao3,
		        		estado_de_conservacao3,
		        		status3);
		        
		        
		        //Armazena na biblioteca
		        BibliotecaStatic.getItens().add(livro3);
		        //Armazena ID
		        BibliotecaStatic.getItens_id().add(id3);
		        
		        System.out.println("CD de Áudio Adicionado.");
		        
		    	return;
		    case 4:
		    	System.out.println("DVD de Vídeo");
		        System.out.println("----------------------");
		        
		        //Instancia as variáveis do Item
		        boolean auxAddItem4 = true;
		        int id4 = -1;
		        do {
			        //Instancia as variáveis do Item
			        System.out.print("ID do Livro:");
			        try {
			        	id4 = scanner.nextInt();
			        	scanner.nextLine();
			        } catch(InputMismatchException e) {
			        	System.out.println("O ID deve ser um número, tente novamente.");
			        	scanner.next();
			        	continue;
			        }
			         //capturar o \n
			        //Checa se o ID já existe na biblioteca para evitar duplicidades
			        try {
				        if(BibliotecaStatic.getItens_id().contains(id4)) {
				        	throw new ExcecaoIdJaCadastrado("ERRO: ID já cadastrado.");
				        }
			        } catch(ExcecaoIdJaCadastrado e) {
			        	System.err.println(e.getMessage());
			        	System.out.println("Tente outro ID.");
			        	continue;
			        }
			        auxAddItem4 = false;
		        }while(auxAddItem4) ;
		        
		        System.out.print("Título do DVD:");
		        String titulo4 = scanner.nextLine();
		        System.out.print("Autor:");
		        String autor4 = scanner.nextLine();
		        System.out.print("Editora:");
		        String editora4 = scanner.nextLine();
		        System.out.print("Ano:");
		        String ano4 = scanner.nextLine(); 
		        System.out.print("Genero:");
		        String genero4 = scanner.nextLine(); 
		        System.out.print("Sinopse:");
		        String sinopse4 = scanner.nextLine();
		        System.out.print("Capa:");
		        String capa4 = scanner.nextLine();
		        StatusItem status4 = StatusItem.DISPONIVEL;
		        System.out.print("Elenco:");
		        String elenco4 = scanner.nextLine();
		        
		        auxAddItem4 = true;
			    int duracao4 = 1;
			    do {
			        System.out.print("Duração em Segundos:");
			        
			        try {
			        	duracao4 = scanner.nextInt();
			        	scanner.nextLine();
			        } catch(InputMismatchException e) {
			        	System.out.println("A duração deve ser um número, tente novamente.");
			        	scanner.next();
			        	continue;
			        }
			        if(duracao4 <= 0) {
			        	System.out.println("O tempo de duração não deve ser negativo, tente novamente.");
			        	continue;
			        }
			        
			        auxAddItem4 = false;
		        }while(auxAddItem4) ;
		        
		        System.out.print("Legendas e Áudio (s)(n):");
		        String legendas_e_audio4 = scanner.nextLine();
		        boolean legendas_e_audio_boolean;
		        if(legendas_e_audio4.equals("s")) {
		        	legendas_e_audio_boolean = true;
		        } else {
		        	legendas_e_audio_boolean = false;
		        }
		        
		        EstadoItemMultimidia estado_de_conservacao4 = null;
		        auxAddItem4 = true;
		        do {
		        	System.out.print("Está em Bom Estado de Conservação?:(y/n):");
		        	try {
		        		String opcaoStatus4 = scanner.nextLine();
		        		if(opcaoStatus4.equals("y")) {
		        			estado_de_conservacao4 = EstadoItemMultimidia.BOM;
		        		} else if(opcaoStatus4.equals("n")) {
		        			estado_de_conservacao4 = EstadoItemMultimidia.MAU;
		        		} else {
		        			throw new InputMismatchException("Opção inválida.");
		        		}
		        	} catch (InputMismatchException e) {
		        		System.err.println(e.getMessage());
		        		System.out.println("Tente novamente.");
		        		continue;
		        	}
		        	auxAddItem4 = false;
		        } while(auxAddItem4);
		        
		        // Cria objeto
		        DVD_de_video livro4 = new DVD_de_video(
		        		id4,
		        		titulo4,
		        		autor4,
		        		editora4,
		        		ano4,
		        		genero4,
		        		sinopse4,
		        		capa4,
		        		elenco4,
		        		duracao4,
		        		legendas_e_audio_boolean,
		        		estado_de_conservacao4,
		        		status4);
		        
		        
		        //Armazena na biblioteca
		        BibliotecaStatic.getItens().add(livro4);
		        //Armazena ID
		        BibliotecaStatic.getItens_id().add(id4);
		        
		        System.out.println("CD de Áudio Adicionado.");
		        
		        return;
		    case 5:
		    	System.out.println("Outro Item Multimidia");
		        System.out.println("----------------------");
		        
		        //Instancia as variáveis do Item
		        boolean auxAddItem5 = true;
		        int id5 = -1;
		        do {
			        //Instancia as variáveis do Item
			        System.out.print("ID do Livro:");
			        try {
			        	id5 = scanner.nextInt();
			        	scanner.nextLine();
			        } catch(InputMismatchException e) {
			        	System.out.println("O ID deve ser um número, tente novamente.");
			        	scanner.next();
			        	continue;
			        }
			         //capturar o \n
			        //Checa se o ID já existe na biblioteca para evitar duplicidades
			        try {
				        if(BibliotecaStatic.getItens_id().contains(id5)) {
				        	throw new ExcecaoIdJaCadastrado("ERRO: ID já cadastrado.");
				        }
			        } catch(ExcecaoIdJaCadastrado e) {
			        	System.err.println(e.getMessage());
			        	System.out.println("Tente outro ID.");
			        	continue;
			        }
			        auxAddItem5 = false;
		        }while(auxAddItem5) ;
		        
		        System.out.print("Título do DVD:");
		        String titulo5 = scanner.nextLine();
		        System.out.print("Autor:");
		        String autor5 = scanner.nextLine();
		        System.out.print("Editora:");
		        String editora5 = scanner.nextLine();
		        System.out.print("Ano:");
		        String ano5 = scanner.nextLine(); 
		        System.out.print("Genero:");
		        String genero5 = scanner.nextLine(); 
		        System.out.print("Sinopse:");
		        String sinopse5 = scanner.nextLine();
		        System.out.print("Capa:");
		        String capa5 = scanner.nextLine();
		        StatusItem status5 = StatusItem.DISPONIVEL;
		        System.out.print("Tipo Recurso:");
		        String tipo_recurso5 = scanner.nextLine();
		        System.out.print("Formato:");
		        String formato5 = scanner.nextLine();
		        System.out.print("Localização:");
		        String localizacao5 = scanner.nextLine();
		        
		        EstadoItemMultimidia estado_de_conservacao5 = null;
		        auxAddItem5 = true;
		        do {
		        	System.out.print("Está em Bom Estado de Conservação?:(y/n):");
		        	try {
		        		String opcaoStatus5 = scanner.nextLine();
		        		if(opcaoStatus5.equals("y")) {
		        			estado_de_conservacao5 = EstadoItemMultimidia.BOM;
		        		} else if(opcaoStatus5.equals("n")) {
		        			estado_de_conservacao5 = EstadoItemMultimidia.MAU;
		        		} else {
		        			throw new InputMismatchException("Opção inválida.");
		        		}
		        	} catch (InputMismatchException e) {
		        		System.err.println(e.getMessage());
		        		System.out.println("Tente novamente.");
		        		continue;
		        	}
		        	auxAddItem5 = false;
		        } while(auxAddItem5);
		        
		        // Cria objeto
		        Outros_itens_multimidia livro5 = new Outros_itens_multimidia(
		        		id5,
		        		titulo5,
		        		autor5,
		        		editora5,
		        		ano5,
		        		genero5,
		        		sinopse5,
		        		capa5,
		        		status5,
		        		tipo_recurso5,
		        		formato5,
		        		localizacao5,
		        		estado_de_conservacao5
		        		);
		        
		        
		        //Armazena na biblioteca
		        BibliotecaStatic.getItens().add(livro5);
		        //Armazena ID
		        BibliotecaStatic.getItens_id().add(id5);
		        
		        System.out.println("CD de Áudio Adicionado.");
		        
		        return;
		    default:
		        System.out.print("Opção inválida. Por favor, escolha novamente: ");
		    }
        
		}
    }
    
    private static void adicionarSala(Scanner scanner) {
        // Lógica para adicionar um novo item
        System.out.println("Operação de Adição de Sala Biblioteca");
        System.out.println("----------------------------");
    	while(true) {

			System.out.println("Insira o tipo da Sala:");
			System.out.println("");
			System.out.println("1. Sala Individual");
			System.out.println("2. Sala em Grupo");
			System.out.println("3. Sala Silenciosa");
			System.out.println("4. Sala Multimidia");
			System.out.println("");
			System.out.print("Digite o número: ");
			
		    int codigo = scanner.nextInt();
		    scanner.nextLine();
		    
		    switch (codigo) {
		    case 1:
		        System.out.println("Sala Individual");
		        System.out.println("----------------------");
		        
		        //Instancia as variáveis do Item
		        boolean auxAddItem1 = true;
		        int id1 = -1;
		        do {
			        //Instancia as variáveis do Item
			        System.out.print("ID do Livro:");
			        try {
			        	id1 = scanner.nextInt();
			        	scanner.nextLine();
			        } catch(InputMismatchException e) {
			        	System.out.println("O ID deve ser um número, tente novamente.");
			        	scanner.next();
			        	continue;
			        }
			         //capturar o \n
			        //Checa se o ID já existe na biblioteca para evitar duplicidades
			        try {
				        if(BibliotecaStatic.getItens_id().contains(id1)) {
				        	throw new ExcecaoIdJaCadastrado("ERRO: ID já cadastrado.");
				        }
			        } catch(ExcecaoIdJaCadastrado e) {
			        	System.err.println(e.getMessage());
			        	System.out.println("Tente outro ID.");
			        	continue;
			        }
			        auxAddItem1 = false;
		        }while(auxAddItem1) ;
		        
		        System.out.print("Nome da Sala:");
		        String nomeSala1 = scanner.nextLine();
		        
		        System.out.print("Possui computador ?(y/n):");
		        boolean temComputador1;
		        String opcaoStatus1 = scanner.nextLine();
        		if(opcaoStatus1.equals("y")) {
        			temComputador1 = true;
        		} else if(opcaoStatus1.equals("n")) {
        			temComputador1 = false;
        		} else {
        			System.out.println("Opção inválida.");
        			System.out.println("Operação cancelada.");
        			return;
        		}
		        
		        System.out.print("Numero da Sala:");
		        int numeroSala1 = scanner.nextInt();
			    scanner.nextLine();
		        
		        // Cria objeto
			    SalaIndividual salaIndividual = new SalaIndividual(
		        		id1,
		        		nomeSala1,
		        		temComputador1,
		        		numeroSala1);
		        
		        
		        //Armazena na biblioteca
		        BibliotecaStatic.getItens().add(salaIndividual);
		        //Armazena ID
		        BibliotecaStatic.getItens_id().add(id1);
		        
		        System.out.println("Sala Adicionada.");
		        
		        return;
		    case 2:        
		        System.out.println("Sala Grupo");
		        System.out.println("----------------------");
		        
		        //Instancia as variáveis da sala
		        boolean auxAddItem2 = true;
		        int id2 = -1;
		        do {
			        //Instancia as variáveis do Item
			        System.out.print("ID do Livro:");
			        try {
			        	id2 = scanner.nextInt();
			        	scanner.nextLine();
			        } catch(InputMismatchException e) {
			        	System.out.println("O ID deve ser um número, tente novamente.");
			        	scanner.next();
			        	continue;
			        }
			         //capturar o \n
			        //Checa se o ID já existe na biblioteca para evitar duplicidades
			        try {
				        if(BibliotecaStatic.getItens_id().contains(id2)) {
				        	throw new ExcecaoIdJaCadastrado("ERRO: ID já cadastrado.");
				        }
			        } catch(ExcecaoIdJaCadastrado e) {
			        	System.err.println(e.getMessage());
			        	System.out.println("Tente outro ID.");
			        	continue;
			        }
			        auxAddItem2 = false;
		        }while(auxAddItem2) ;
		        
		        System.out.print("Nome da Sala:");
		        String nomeSala2 = scanner.nextLine();
		        
		        System.out.print("Possui Recurso ?(y/n):");
		        boolean temRecurso2;
		        String opcaoStatus2 = scanner.nextLine();
        		if(opcaoStatus2.equals("y")) {
        			temRecurso2 = true;
        		} else if(opcaoStatus2.equals("n")) {
        			temRecurso2 = false;
        		} else {
        			System.out.println("Opção inválida.");
        			System.out.println("Operação cancelada.");
        			return;
        		}
        		System.out.print("Numero da Sala:");
		        int capacidadeMaxima1 = scanner.nextInt();
			    scanner.nextLine();
		        
		        // Cria objeto
		        SalaGrupo salaGrupo = new SalaGrupo(
		        		id2,
		        		nomeSala2,
		        		temRecurso2,
		        		capacidadeMaxima1
		        		);
		        
		        
		        //Armazena na biblioteca
		        BibliotecaStatic.getItens().add(salaGrupo);
		        //Armazena ID
		        BibliotecaStatic.getItens_id().add(id2);
		        
		        System.out.println("Sala em grupo adicionada.");
		        
		    	return;
		    case 3:
		    	System.out.println("Sala Silenciosa");
		        System.out.println("----------------------");
		        
		        //Instancia as variáveis da sala
		        boolean auxAddItem3 = true;
		        int id3 = -1;
		        do {
			        //Instancia as variáveis do Item
			        System.out.print("ID do Livro:");
			        try {
			        	id3 = scanner.nextInt();
			        	scanner.nextLine();
			        } catch(InputMismatchException e) {
			        	System.out.println("O ID deve ser um número, tente novamente.");
			        	scanner.next();
			        	continue;
			        }
			         //capturar o \n
			        //Checa se o ID já existe na biblioteca para evitar duplicidades
			        try {
				        if(BibliotecaStatic.getItens_id().contains(id3)) {
				        	throw new ExcecaoIdJaCadastrado("ERRO: ID já cadastrado.");
				        }
			        } catch(ExcecaoIdJaCadastrado e) {
			        	System.err.println(e.getMessage());
			        	System.out.println("Tente outro ID.");
			        	continue;
			        }
			        auxAddItem3 = false;
		        }while(auxAddItem3) ;
		        
		        System.out.print("Nome da Sala:");
		        String nomeSala3 = scanner.nextLine();
		        
		        System.out.print("Possui Cabine Individual ?(y/n):");
		        boolean temCabineIndividual;
		        String opcaoStatus3 = scanner.nextLine();
        		if(opcaoStatus3.equals("y")) {
        			temCabineIndividual = true;
        		} else if(opcaoStatus3.equals("n")) {
        			temCabineIndividual = false;
        		} else {
        			System.out.println("Opção inválida.");
        			System.out.println("Operação cancelada.");
        			return;
        		}
        		System.out.print("Numero de Assentos:");
		        int numeroAssentos3 = scanner.nextInt();
			    scanner.nextLine();
		        
		        // Cria objeto
		        SalaSilenciosa salaSilenciosa = new SalaSilenciosa(
		        		id3,
		        		nomeSala3,
		        		temCabineIndividual,
		        		numeroAssentos3
		        		);
		        
		        
		        //Armazena na biblioteca
		        BibliotecaStatic.getItens().add(salaSilenciosa);
		        //Armazena ID
		        BibliotecaStatic.getItens_id().add(id3);
		        
		        System.out.println("Sala em grupo adicionada.");
		        
		    	return;
		    case 4:
		    	System.out.println("Sala Multimidia");
		        System.out.println("----------------------");
		        
		        //Instancia as variáveis da sala
		        System.out.print("ID da Sala:");
		        int id4 = scanner.nextInt();
		        scanner.nextLine(); //capturar o \n
		        //Checa se o ID já existe na biblioteca para evitar duplicidades
		        if(BibliotecaStatic.getItens_id().contains(id4)) {
		        	System.out.println("ERRO: ID já cadastrato, retornando ao menu.");
		        	return;
		        }
		        System.out.print("Nome da Sala:");
		        String nomeSala4 = scanner.nextLine();
		      
		        String equipamentos4 = scanner.nextLine();
			    scanner.nextLine();
		        
		        // Cria objeto
		        SalaMultimidia salaMultimidia = new SalaMultimidia(
		        		id4,
		        		nomeSala4,
		        		equipamentos4
		        		);
		        
		        
		        //Armazena na biblioteca
		        BibliotecaStatic.getItens().add(salaMultimidia);
		        //Armazena ID
		        BibliotecaStatic.getItens_id().add(id4);
		        
		        System.out.println("Sala Multimidia Adicionada.");
		        
		    	return;
		    default:
		        System.out.print("Opção inválida. Por favor, escolha novamente: ");
		    }
        
		}
    }

    private static void editarItem(Scanner scanner) {
        // Lógica para editar um item existente
        System.out.println("Operação de Edição de Item");
        
        System.out.print("Insira o ID do livro a ser editado:");
    	int id_livro = scanner.nextInt();
    	scanner.nextLine(); //captura o \n
    	Item item = bibliotecaController.buscarItenPorIdentificacao(id_livro);
        
        while (true) {
            System.out.println("---- Menu Edição de Itens ----");
            System.out.println("Selecione a opção que deseja editar.");
            System.out.println();
            System.out.println("1. STATUS Item");
            System.out.println("2. Condição Item (Apenas Itens Multimidia");
            System.out.println();
            System.out.println();
            System.out.print("Escolha uma opção: ");

            int opcaoItens = scanner.nextInt();
            scanner.nextLine();

            switch (opcaoItens) {
                case 1:
                    
	            	if (item.getStatusItem().equals(StatusItem.DISPONIVEL)) {
	            		System.out.println("O item está disponível, deseja torna-lo indisponível ? y/n");
	            		String opcaoStatus = scanner.nextLine();
	            		if(opcaoStatus.equals("y")) {
	            			item.setStatusItem(StatusItem.INDISPONIVEL);
		            		System.out.println("Operação realizada com sucesso.");
		            		return;
	            		} else if(opcaoStatus.equals("n")) {
	            			System.out.println("Operação cancelada.");
	            			return;
	            		} else {
	            			System.out.println("Opção inválida.");
	            			System.out.println("Operação cancelada.");
	            			return;
	            		}
	            		
	            	}
	            	else if (item.getStatusItem().equals(StatusItem.INDISPONIVEL)) {
	            		System.out.println("O item está disponível, deseja torna-lo disponivel ? y/n");
	            		String opcaoStatus = scanner.nextLine();
	            		if(opcaoStatus.equals("y")) {
	            			item.setStatusItem(StatusItem.DISPONIVEL);
		            		System.out.println("Operação realizada com sucesso.");
		            		return;
	            		} else if(opcaoStatus.equals("n")) {
	            			System.out.println("Operação cancelada.");
	            			return;
	            		} else {
	            			System.out.println("Opção inválida.");
	            			System.out.println("Operação cancelada.");
	            			return;
	            		}
	            	}
	            	else {
	            		System.out.println("O item deve estar disponível ou indisponível para a edicação do status");
	            		System.out.println("Operação cancelada.");
	            		return;
	            	}
                case 2:
                	
                	if( !(item instanceof ItemMultimidia) ) {
                		System.out.println("O item não é do tipo Item Multimidia.");
                		System.out.println("Operação Cancelada.");
                		return;
                	}
                	
                	ItemMultimidia itemMultimidia = (ItemMultimidia) item;
                	while(true) {
                		System.out.println("Selecione o novo estado do Item.");
                        System.out.println();
                        System.out.println("1. Bom Estado");
                        System.out.println("2. Mau Estado");
                        System.out.println();
                        System.out.println();
                        System.out.print("Escolha uma opção: ");
                        
                        int opcaoEstadoIten = scanner.nextInt();
                        scanner.nextLine();
                        
                        if(opcaoEstadoIten == 1) {
                        	itemMultimidia.setEstado_conservacao(EstadoItemMultimidia.BOM);
		            		System.out.println("Operação realizada com sucesso.");
		            		return;
	            		} else if(opcaoEstadoIten == 2) {
	            			itemMultimidia.setEstado_conservacao(EstadoItemMultimidia.MAU);
	            			System.out.println("Operação realizada com sucesso.");
	            			return;
	            		} else {
	            			System.out.println("Opção inválida, tente novamente.");
	            		}
                	}
                default:
                    System.out.println("Opção inválida. Por favor, escolha novamente.");
            }
        }
    }

    private static void removerItem(Scanner scanner) {
    	System.out.print("Insira o ID do livro a ser removido:");
    	int ID = scanner.nextInt();
    	
    	//Inicializando variável do membro a ser deletado
    	Item item_deletar = null;
    	
    	//Loop para achar o Item a partir do ID
    	List<Item> itens = BibliotecaStatic.getItens();
    	for( Item item : itens) {
    		if(item.getId() == ID ) {
    			item_deletar = item;
    			break;
    		}
    	}
    	
    	//Checa se o Item existe
    	if(item_deletar == null) {
    		System.out.println("Nenhum item possui tal ID.");
    		return;
    	} else { //Caso existir, confirmar se realmente quer excluir o item selecionado
    		int opcao = 0;
	        while(opcao == 0) {
			    
	        	System.out.println("Tem certeza que deseja deletar o item" + item_deletar.toString() + " ?:");
	    		System.out.println("1. Sim");
	    		System.out.println("2. Não");
	    		System.out.print("Insira a opção: ");
				
				int codigo_excl = scanner.nextInt();
			    scanner.nextLine();
				
				switch (codigo_excl) {
				case 1:
					opcao = 1;
					break;
				case 2:
					opcao = 2;
					break;
				default:
			        System.out.print("Opção inválida. Por favor, escolha novamente: ");
				}
			    
	        }
    		
	        //Deletar ou não deletar ? eis a questão
	        if(opcao == 1) {
	        	//Remove o ID
	        	BibliotecaStatic.getItens_id().remove(item_deletar.getId());
	        	
	        	//Remove do "banco de dados"
	        	itens.remove(item_deletar);
	        	System.out.println("Item removido.");
	        	return;
	        } else {
	        	System.out.println("Operação cancelada.");
	        }
    	}
    	
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
		        System.out.print("Nome do estudante:");
		        String nome1 = scanner.nextLine();
		        System.out.print("ID:");
		        String id_faculdade1 = scanner.nextLine();
		        //Checa se o ID já existe na biblioteca para evitar duplicidades
		        if(BibliotecaStatic.getMembros_id().contains(id_faculdade1)) {
		        	System.out.println("ERRO: ID já cadastrato, retornando ao menu.");
		        	return;
		        }
		        
		        System.out.print("Endereço do estudante:");
		        String endereco1 = scanner.nextLine();
		        System.out.print("Contato:");
		        String contato1 = scanner.nextLine();

		        boolean statusMembro1;
		        System.out.println("Membro bloqueado (y/n):");
        		String opcaoStatus1 = scanner.nextLine();
        		if(opcaoStatus1.equals("y")) {
        			statusMembro1 = true;
        		} else if(opcaoStatus1.equals("n")) {
        			statusMembro1 = false;
        		} else {
        			System.out.println("Opção inválida.");
        			System.out.println("Operação cancelada.");
        			return;
        		}
		        
		        Date data1 = new Date();
		        
		        // Cria objeto
		        Estudante_graduacao aluno1 = new Estudante_graduacao(
		        		nome1,
		        		id_faculdade1,
		        		endereco1,
		        		contato1,
						data1,
						statusMembro1);
		        
		        
		        //Armazena na biblioteca
		        BibliotecaStatic.getMembros().add(aluno1);
		        //Armazena ID
		        BibliotecaStatic.getMembros_id().add(id_faculdade1);
		        
		        System.out.println("Estudante criado.");
		        
		        return;
		    case 2:
		    	System.out.println("Estudante da pós");
		    	System.out.println("----------------------");
		        
		        //Instancia as variáveis do aluno
		        System.out.print("Nome do estudante:");
		        String nome2 = scanner.nextLine();
		        System.out.print("ID:");
		        String id_faculdade2 = scanner.nextLine();
		        //Checa se o ID já existe na biblioteca para evitar duplicidades
		        if(BibliotecaStatic.getMembros_id().contains(id_faculdade2)) {
		        	System.out.println("ERRO: ID já cadastrato, retornando ao menu.");
		        	return;
		        }
		        System.out.print("Endereço do estudante:");
		        String endereco2 = scanner.nextLine();
		        System.out.print("Contato:");
		        String contato2 = scanner.nextLine();
		        
		        boolean statusMembro2;
		        System.out.println("Membro bloqueado (y/n):");
        		String opcaoStatus2 = scanner.nextLine();
        		if(opcaoStatus2.equals("y")) {
        			statusMembro2 = true;
        		} else if(opcaoStatus2.equals("n")) {
        			statusMembro2 = false;
        		} else {
        			System.out.println("Opção inválida.");
        			System.out.println("Operação cancelada.");
        			return;
        		}
		        
		        Date data2 = new Date();
		        
		        // Cria objeto
		        Estudante_pos aluno2 = new Estudante_pos(
		        		nome2,
		        		id_faculdade2,
		        		endereco2,
		        		contato2,
						data2,
						statusMembro2);
		        
		        //Armazena na biblioteca
		        BibliotecaStatic.getMembros().add(aluno2);
		      //Armazena ID
		        BibliotecaStatic.getMembros_id().add(id_faculdade2);
		        
		        System.out.println("Estudante criado.");
		    	return;
		    case 3:
		    	System.out.println("Funcionario");
		    	System.out.println("----------------------");
		        
		        //Instancia as variáveis do aluno
		        System.out.print("Nome do funcionario:");
		        String nome3 = scanner.nextLine();
		        System.out.print("ID:");
		        String id_faculdade3 = scanner.nextLine();
		        //Checa se o ID já existe na biblioteca para evitar duplicidades
		        if(BibliotecaStatic.getMembros_id().contains(id_faculdade3)) {
		        	System.out.println("ERRO: ID já cadastrato, retornando ao menu.");
		        	return;
		        }
		        System.out.print("Endereço do funcionario:");
		        String endereco3 = scanner.nextLine();
		        System.out.print("Contato:");
		        String contato3 = scanner.nextLine();
		        
		        boolean statusMembro3;
		        System.out.println("Membro bloqueado (y/n):");
        		String opcaoStatus3 = scanner.nextLine();
        		if(opcaoStatus3.equals("y")) {
        			statusMembro3 = true;
        		} else if(opcaoStatus3.equals("n")) {
        			statusMembro3 = false;
        		} else {
        			System.out.println("Opção inválida.");
        			System.out.println("Operação cancelada.");
        			return;
        		}
		        
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
		        
		        System.out.print("Usuario de Acesso:");
		        String usuario3 = scanner.nextLine();
		        System.out.print("Senha de Acesso:");
		        String senha3 = scanner.nextLine();
		        
		        // Cria objeto
		        Funcionario funcionario = new Funcionario(
		        		nome3,
		        		id_faculdade3,
		        		endereco3,
		        		contato3,
						data3,
						nivel_acesso,
						statusMembro3,
						usuario3,
						senha3);
		        
		        //Armazena na biblioteca
		        BibliotecaStatic.getMembros().add(funcionario);
		      //Armazena ID
		        BibliotecaStatic.getMembros_id().add(id_faculdade3);
		        
		        System.out.println("Funcionário criado.");
		    	return;
		    case 4:
		    	System.out.println("Professor");
		        System.out.println("----------------------");
		        
		        //Instancia as variáveis do aluno
		        System.out.print("Nome do professor:");
		        String nome4 = scanner.nextLine();
		        System.out.print("ID:");
		        String id_faculdade4 = scanner.nextLine();
		        //Checa se o ID já existe na biblioteca para evitar duplicidades
		        if(BibliotecaStatic.getMembros_id().contains(id_faculdade4)) {
		        	System.out.println("ERRO: ID já cadastrato, retornando ao menu.");
		        	return;
		        }
		        System.out.print("Endereço do professor:");
		        String endereco4 = scanner.nextLine();
		        System.out.print("Contato:");
		        String contato4 = scanner.nextLine();
		        
		        boolean statusMembro4;
		        System.out.println("Membro bloqueado (y/n):");
        		String opcaoStatus4 = scanner.nextLine();
        		if(opcaoStatus4.equals("y")) {
        			statusMembro4 = true;
        		} else if(opcaoStatus4.equals("n")) {
        			statusMembro4 = false;
        		} else {
        			System.out.println("Opção inválida.");
        			System.out.println("Operação cancelada.");
        			return;
        		}
		        
		        Date data4 = new Date();
		        
		        // Cria objeto
		        Professor professor = new Professor(
		        		nome4,
		        		id_faculdade4,
		        		endereco4,
		        		contato4,
						data4,
						statusMembro4);
		        
		        //Armazena na biblioteca
		        BibliotecaStatic.getMembros().add(professor);
		      //Armazena ID
		        BibliotecaStatic.getMembros_id().add(id_faculdade4);
		        
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
        System.out.println("----------------------------");
        System.out.print("Insira o ID do membro a ser editado:");
    	String ID = scanner.nextLine();
    	
    	Membro membro_editar = membroController.buscarMembroPorIdentificacao(ID);
    	//Atualizando atributos comuns
    	
    	//Cada classe tem seus atributos, então, separando
    	if(membro_editar.getClass().equals(Estudante_graduacao.class)) {
    		
    	} else if(membro_editar.getClass().equals(Estudante_pos.class)) {
    		
    	} else if(membro_editar.getClass().equals(Funcionario.class)) {
    		
    	} else if(membro_editar.getClass().equals(Professor.class)) {
    		
    	} else {
    		System.out.println("ERRO CRÍTICO: CONTATAR O ADMINISTRADOR URGENTEMENTE!");
    	}
    	
    	
    }

    private static void removerMembro(Scanner scanner) {

    	System.out.print("Insira o ID do membro a ser removido:");
    	String ID = scanner.nextLine();
    	
    	//Inicializando variável do membro a ser deletado
    	Membro membro_deletar = null;
    	
    	membro_deletar = membroController.buscarMembroPorIdentificacao(ID);
    	
    	//Checa se o membro existe
    	if(membro_deletar == null) {
    		System.out.println("Nenhum membro possui tal ID.");
    		return;
    	} else { //Caso existir, confirmar se realmente quer excluir o membro selecionado
    		int opcao = 0;
	        while(opcao == 0) {
			    
	        	System.out.println("Tem certeza que deseja deletar o membro" + membro_deletar.getNome() + " ?:");
	    		System.out.println("1. Sim");
	    		System.out.println("2. Não");
	    		System.out.print("Insira a opção: ");
				
				int codigo_funcionario = scanner.nextInt();
			    scanner.nextLine();
				
				switch (codigo_funcionario) {
				case 1:
					opcao = 1;
					break;
				case 2:
					opcao = 2;
					break;
				default:
			        System.out.print("Opção inválida. Por favor, escolha novamente: ");
				}
			    
	        }
    		
	        //Deletar ou não deletar ? eis a questão
	        if(opcao == 1) {
	        	//Remove o ID
	        	BibliotecaStatic.getMembros_id().remove(membro_deletar.getId_faculdade());
	        	
	        	//Remove do "banco de dados"
	        	List<Membro> Membros = BibliotecaStatic.getMembros();
	        	Membros.remove(membro_deletar);
	        	System.out.println("Membro removido.");
	        	return;
	        } else {
	        	System.out.println("Operação cancelada.");
	        }
    	}
    }

    // Métodos para gerar relatórios e estatísticas
    private static void gerarRelatorioAtividadesMembros() {
        //Printar membros existentes
        System.out.println("Gerando Relatório de Atividades de Membros");
        
        LinkedList<Membro> membros = BibliotecaStatic.getMembros();
        Set<Emprestimo> emprestimos = BibliotecaStatic.getEmprestimos();
        LinkedList<Reserva> reservas = BibliotecaStatic.getReservas();
        
        for( Membro membro : membros) {
        	System.out.println("------------------------------------------");
    		System.out.println(membro.getNome()+':');
    		System.out.println("Possui os seguintes itens emprestados:");
    		for( Emprestimo emprestimo : emprestimos) {
        		if(emprestimo.getPessoa().equals(membro)) {
        			System.out.println(emprestimo.getItem().toString());
        		}
        	}
    		System.out.println("Possui os seguintes itens reservados:");
    		for( Reserva reserva : reservas) {
        		if(reserva.getPessoa().equals(membro)) {
        			System.out.println(reserva.getItem().toString());
        		}
        	}
    	}
        
        return;
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
        
        LinkedList<Item> itens = BibliotecaStatic.getItens();
        
        for( Item item : itens) {
    		System.out.println(item.toString() + ' ' + item.getStatusItem());
    	}
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
