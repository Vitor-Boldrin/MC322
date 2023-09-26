package main;

import biblioteca.controllers.*;
import biblioteca.models.BibliotecaStatic.BibliotecaStatic;
import biblioteca.models.BibliotecaStatic.ItemBiblioteca;
import biblioteca.models.Controle_livros.Emprestimo;
import biblioteca.models.Controle_livros.Reserva;
import biblioteca.models.ItemMultimidia.CD_de_audio;
import biblioteca.models.ItemMultimidia.DVD_de_video;
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
import biblioteca.views.*;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;
import java.util.Set;

public class BibliotecaMain {
    private static BibliotecaController bibliotecaController;
    private static MembroController membroController;
    private static RelatorioController relatorioController;
    private static ItemBiblioteca<ItemMultimidia> bibliotecaItemBiblioteca;

    public static void main(String[] args) throws IllegalAccessException {
        bibliotecaController = new BibliotecaControllerImpl();
        membroController = new MembroControllerImpl();
        relatorioController = new RelatorioControllerImpl();
        bibliotecaItemBiblioteca = new ItemBiblioteca();

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

    private static void menuGerenciamentoItens(Scanner scanner, BibliotecaView bibliotecaView) throws IllegalAccessException {
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
                    List<ItemMultimidia> itens = BibliotecaStatic.getItens();
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
                case 8:
                	devolverMainItem(scanner);
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
        
        //Primeiro, colentado os objetos, ITEM e MEMBRO
        System.out.print("Insira o ID do membro requisitando o empréstimo:");
    	String id_membro = scanner.nextLine();
    	Membro membro = membroController.buscarMembroPorIdentificacao(id_membro);
    	
    	System.out.print("Insira o ID do livro a ser emprestado:");
    	int id_livro = scanner.nextInt();
    	scanner.nextLine(); //captura o \n
    	ItemMultimidia item = bibliotecaController.buscarItenPorIdentificacao(id_livro);
    	
    	// Joga na função e boa
    	try {
    		bibliotecaItemBiblioteca.emprestarItem(membro, item);
    	} catch (IllegalAccessException e) {
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
        // Lógica para fazer uma reserva de item
        System.out.println("Operação de Reserva de Itens");
      //Primeiro, colentado os objetos, ITEM e MEMBRO
        System.out.print("Insira o ID do membro que está reservando o item:");
    	String id_membro = scanner.nextLine();
    	Membro membro = membroController.buscarMembroPorIdentificacao(id_membro);
    	
    	System.out.print("Insira o ID do livro a ser reservado:");
    	int id_livro = scanner.nextInt();
    	scanner.nextLine(); //captura o \n
    	ItemMultimidia item = bibliotecaController.buscarItenPorIdentificacao(id_livro);
        
        bibliotecaItemBiblioteca.reservarItem(membro, item);
    }
    
    private static void devolverMainItem(Scanner scanner) {
    	
    	//Primeiro, colentado os objetos, ITEM e MEMBRO
        System.out.print("Insira o ID do membro que está devolvendo o item:");
    	String id_membro = scanner.nextLine();
    	Membro membro = membroController.buscarMembroPorIdentificacao(id_membro);
    	
    	System.out.print("Insira o ID do livro a ser devolvido:");
    	int id_livro = scanner.nextInt();
    	scanner.nextLine(); //captura o \n
    	ItemMultimidia item = bibliotecaController.buscarItenPorIdentificacao(id_livro);
    	
    	bibliotecaItemBiblioteca.devolverItem(membro, item);
    }

    // Métodos para adicionar, editar e remover itens e membros
    private static void adicionarItem(Scanner scanner) {
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
		        
		        //Instancia as variáveis do Item
		        System.out.print("ID do Livro:");
		        int id1 = scanner.nextInt();
		        scanner.nextLine(); //capturar o \n
		        //Checa se o ID já existe na biblioteca para evitar duplicidades
		        if(BibliotecaStatic.getItens_id().contains(id1)) {
		        	System.out.println("ERRO: ID já cadastrato, retornando ao menu.");
		        	return;
		        }
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
		        System.out.print("Edição (apenas o número):");
		        int edicao1 = scanner.nextInt();
		        scanner.nextLine(); //capturar o \n
		        System.out.print("Localização:");
		        String loc1 = scanner.nextLine();
		        System.out.print("Estado de Conservação:");
		        String estado1 = scanner.nextLine();
		        
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
		        System.out.print("ID do Livro:");
		        int id2 = scanner.nextInt();
		        scanner.nextLine(); //capturar o \n
		        //Checa se o ID já existe na biblioteca para evitar duplicidades
		        if(BibliotecaStatic.getItens_id().contains(id2)) {
		        	System.out.println("ERRO: ID já cadastrato, retornando ao menu.");
		        	return;
		        }
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
		        System.out.print("ID do CD:");
		        int id3 = scanner.nextInt();
		        scanner.nextLine(); //capturar o \n
		        //Checa se o ID já existe na biblioteca para evitar duplicidades
		        if(BibliotecaStatic.getItens_id().contains(id3)) {
		        	System.out.println("ERRO: ID já cadastrato, retornando ao menu.");
		        	return;
		        }
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
		        System.out.print("Duração:");
		        String duracao3 = scanner.nextLine();
		        System.out.print("Estado de Conservação:");
		        String estado_de_conservacao3 = scanner.nextLine();
		        
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
		        System.out.print("ID do DVD:");
		        int id4 = scanner.nextInt();
		        scanner.nextLine(); //capturar o \n
		        //Checa se o ID já existe na biblioteca para evitar duplicidades
		        if(BibliotecaStatic.getItens_id().contains(id4)) {
		        	System.out.println("ERRO: ID já cadastrato, retornando ao menu.");
		        	return;
		        }
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
		        System.out.print("Duração:");
		        String duracao4 = scanner.nextLine();
		        System.out.print("Legendas e Áudio (s)(n):");
		        String legendas_e_audio4 = scanner.nextLine();
		        boolean legendas_e_audio_boolean;
		        if(legendas_e_audio4.equals("s")) {
		        	legendas_e_audio_boolean = true;
		        } else {
		        	legendas_e_audio_boolean = false;
		        }
		        System.out.print("Estado de Conservação:");
		        String estado_de_conservacao4 = scanner.nextLine();
		        
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
		        System.out.print("ID do Item:");
		        int id5 = scanner.nextInt();
		        scanner.nextLine(); //capturar o \n
		        //Checa se o ID já existe na biblioteca para evitar duplicidades
		        if(BibliotecaStatic.getItens_id().contains(id5)) {
		        	System.out.println("ERRO: ID já cadastrato, retornando ao menu.");
		        	return;
		        }
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
		        System.out.print("Estado de Conservação:");
		        String estado_de_conservacao5 = scanner.nextLine();
		        
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

    private static void editarItem(Scanner scanner) {
        // Lógica para editar um item existente
        System.out.println("Operação de Edição de Item");
        
        System.out.print("Insira o ID do livro a ser editado:");
    	int id_livro = scanner.nextInt();
    	scanner.nextLine(); //captura o \n
    	ItemMultimidia item = bibliotecaController.buscarItenPorIdentificacao(id_livro);
        
        while (true) {
            System.out.println("---- Menu Edição de Itens ----");
            System.out.println("Selecione a opção que deseja editar.");
            System.out.println();
            System.out.println("1. STATUS Item");
            System.out.println("2. Condição Item");
            System.out.println();
            System.out.println();
            System.out.print("Escolha uma opção: ");

            int opcaoItens = scanner.nextInt();
            scanner.nextLine();

            switch (opcaoItens) {
                case 1:
                    
	            	if (item.getStatus().equals(StatusItem.DISPONIVEL)) {
	            		System.out.println("O item está disponível, deseja torna-lo indisponível ? y/n");
	            		String opcaoStatus = scanner.nextLine();
	            		if(opcaoStatus.equals("y")) {
	            			item.setStatus(StatusItem.INDISPONIVEL);
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
	            	else if (item.getStatus().equals(StatusItem.INDISPONIVEL)) {
	            		System.out.println("O item está disponível, deseja torna-lo disponivel ? y/n");
	            		String opcaoStatus = scanner.nextLine();
	            		if(opcaoStatus.equals("y")) {
	            			item.setStatus(StatusItem.DISPONIVEL);
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
                	System.out.println("TODO");
                    return;
                default:
                    System.out.println("Opção inválida. Por favor, escolha novamente.");
            }
        }
    }

    private static void removerItem(Scanner scanner) {
    	System.out.print("Insira o ID do livro a ser removido:");
    	int ID = scanner.nextInt();
    	
    	//Inicializando variável do membro a ser deletado
    	ItemMultimidia item_deletar = null;
    	
    	//Loop para achar o Item a partir do ID
    	List<ItemMultimidia> itens = BibliotecaStatic.getItens();
    	for( ItemMultimidia item : itens) {
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
			    
	        	System.out.println("Tem certeza que deseja deletar o item" + item_deletar.getTitulo() + " ?:");
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
		        
		        // Cria objeto
		        Funcionario funcionario = new Funcionario(
		        		nome3,
		        		id_faculdade3,
		        		endereco3,
		        		contato3,
						data3,
						nivel_acesso,
						statusMembro3);
		        
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
        			System.out.println(emprestimo.getItem_multimidia().toString());
        		}
        	}
    		System.out.println("Possui os seguintes itens reservados:");
    		for( Reserva reserva : reservas) {
        		if(reserva.getPessoa().equals(membro)) {
        			System.out.println(reserva.getItem_multimidia().getTitulo());
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
        
        LinkedList<ItemMultimidia> itens = BibliotecaStatic.getItens();
        
        for( ItemMultimidia item : itens) {
    		System.out.println(item.getTitulo() + ' ' + item.getStatus());
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
