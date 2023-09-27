package biblioteca.models.BibliotecaStatic;

import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Set;

import biblioteca.models.Controle_livros.Emprestimo;
import biblioteca.models.Controle_livros.Reserva;
import biblioteca.models.Item.Item;
import biblioteca.models.ItemMultimidia.StatusItem;
import biblioteca.models.Membro.Membro;

public class ItemBiblioteca<T> {
	
	private Set<T> itensReservados;
	private Set<T> itensEmprestados;
	private int numeroDeItensEmprestados;
	private int numeroDeItensReservados;
	
	//Construtor
	public ItemBiblioteca() {
		this.itensReservados = new HashSet<>();
		this.itensEmprestados = new HashSet<>();
		this.numeroDeItensEmprestados = 0;
		this.numeroDeItensReservados = 0;
	}
	
	//Geters e Seters
	public Set<T> getItensReservados() {
	      return this.itensReservados;
	}
	
	public void setitensReservados(Set<T> itensReservados) {
	    this.itensReservados = itensReservados;
	}
	
	public Set<T> getItensEmprestados() {
	      return this.itensEmprestados;
	}
	
	public void setItensEmprestados(Set<T> itensEmprestados) {
	    this.itensEmprestados = itensEmprestados;
	}
	
	public int getNumeroDeItensEmprestados() {
		return this.numeroDeItensEmprestados;
	}
	
	public void setNumeroDeItensEmprestados(int numeroDeItensEmprestados) {
		this.numeroDeItensEmprestados = numeroDeItensEmprestados;
	}
	
	public int getNumeroDeItensReservados() {
		return this.numeroDeItensReservados;
	}
	
	public void setNumeroDeItensReservados(int numeroDeItensReservados) {
		this.numeroDeItensReservados = numeroDeItensReservados;
	}
	
	private boolean emprestarItemReservaEmprestimo(Membro membro, Item item) {
    	//Checa se o membro já tem esse item emprestado. Importante, pois mesmo
		// emprestado, ao solicitar o emprestimo é criado uma reserva
    	Set<Emprestimo> emprestimos = BibliotecaStatic.getEmprestimos();
    	
    	for( Emprestimo emprestimo : emprestimos) {
    		if(emprestimo.getPessoa().equals(membro) && emprestimo.getItem().equals(item)) {
    			System.out.println("Membro já tem esse item emprestado.");
    			System.out.println("Operação encerrada.");
    			return false;
    		}
    	}
    	
    	//Checar se o livro está disponível
    	StatusItem status_item = item.getStatusItem();
    	
    	if(status_item.equals(StatusItem.DISPONIVEL)) { 
    		// DISPONÍVEL
    		//Cria o emprestimo
    		Date data = new Date();
    		Emprestimo emprestimo = new Emprestimo(data,data,membro,item);
    		
    		//Adiciona o emprestimo no Set
    		BibliotecaStatic.getEmprestimos().add(emprestimo);
    		item.setStatusItem(StatusItem.EMPRESTADO);
    		
    		//Aumenta o número de emprestimos
    		membro.setNumEmprestimo((short) (membro.getNumEmprestimo() + 1));
    		
    		System.out.println("Livro emprestado com sucesso.");
    		
    		return true;
    		
    	} else if(status_item.equals(StatusItem.EMPRESTADO)
    			|| status_item.equals(StatusItem.EMPRESTADO_E_RESERVADO)) { 
    		// ITEM JÁ EMPRESTADO
    		System.out.println("Livro está emprestado.");
    		
    		//Checa se o membro já tem uma reserva no item, antes de criar outra
    		LinkedList<Reserva> reservas = BibliotecaStatic.getReservas();
    		
    		for( Reserva reserva : reservas) {
        		if(reserva.getPessoa().equals(membro) && reserva.getItem().equals(item)) {
        			//Membro já tem uma reserva nesse item
        			System.out.println("Membro já tem esse item reservado.");
        			System.out.println("Operação encerrada.");
        			return false;
        		}
        	}
    		
    		//Membro ainda nao tem reserva no item
    		//Cria a reserva
    		Date data = new Date();
    		Reserva reserva = new Reserva(data, membro, item);
    		
    		//Adiciona na lista
    		BibliotecaStatic.getReservas().add(reserva);
    		item.setStatusItem(StatusItem.EMPRESTADO_E_RESERVADO);
    		
    		System.out.println("Uma reserva foi gerada");
    		
    		return false;
    		
    		
    	} else if(status_item.equals(StatusItem.RESERVADO)) {
    		//Livro está reservado
    		System.out.println("Livro está reservado.");

    		
    		//Checando se o próximo na lista é o membro e se ele tem a reserva
    		LinkedList<Reserva> reservas = BibliotecaStatic.getReservas();
    		
    		int aux = 0;
    		int aux2 = 0;
    		Reserva reserva_membro = null;
    		
    		for( Reserva reserva : reservas) {
    			if(reserva.getItem().equals(item)) {
					aux++; 
		    		if(reserva.getPessoa().equals(membro)) {
		    			reserva_membro = reserva;
		    			aux2 = 1;
		    			if(aux == 1) { break; } 
		    		}
    			}
        	}
    		
    		if(aux == 1 && reserva_membro != null) { // Se a primeira vez que o livro for encontrado e for do membro, ele é o proximo na fila
    			//O membro é o próximo na fila
    			//Dando lhe o livro e cancelando a reserva
    			
    			//Cria o emprestimo
        		Date data = new Date();
        		Emprestimo emprestimo = new Emprestimo(data,data,membro,item);
        		
        		//Adiciona o emprestimo no Set
        		BibliotecaStatic.getEmprestimos().add(emprestimo);
        		item.setStatusItem(StatusItem.EMPRESTADO);
        		
        		//Aumenta o número de emprestimos
        		membro.setNumEmprestimo((short) (membro.getNumEmprestimo() + 1));
        		
        		System.out.println("O membro é o próximo na fila para o livro.");
        		System.out.println("Livro emprestado com sucesso.");
        		
        		//Deleta a reserva
        		reservas.remove(reserva_membro);
    			
    			
    		} else if(aux2 == 0) { // Nao foi encontrado uma reserva desse livro para o membro
    			System.out.println("O membro ainda não tem a reserva");
    			
    			//Cria a reserva
        		Date data = new Date();
        		Reserva reserva = new Reserva(data, membro, item);
        		
        		//Adiciona na lista
        		BibliotecaStatic.getReservas().add(reserva);
        		
        		System.out.println("Uma reserva foi gerada");
        		
        		return false;
    		} else if(aux2 == 1) { //Existe uma reserva do membro em cima do livro, porém ele não é o proximo
    			System.out.println("Membro tem a reserva porém não é o próximo da fila.");
    			return false;
    		}
    		
    		
    	} else { // O LIVRO EXPLODIU
    		throw new UnsupportedOperationException("O livro está indisponível.");
    	}
    	
		return false;

    }
	
	private boolean itemCheckItemStatus(Membro membro, Item item) {
		//Checa o status do item após o emprestimo
		StatusItem status_item = item.getStatusItem();
		
		//Faz a alocação dos itens no set da classe atual dependento do seu status
		if(status_item.equals(StatusItem.EMPRESTADO)) {
			//Livro somente emprestado, retirando do set de reservas e adicionando na set de emprestimos
			this.itensEmprestados.add((T) item);
			this.itensReservados.remove((T) item);
			
		} else if(status_item.equals(StatusItem.EMPRESTADO_E_RESERVADO)) {
			//Livro emprestado e reservado, adicionando nos 2 sets
			this.itensEmprestados.add((T) item);
			this.itensReservados.add((T) item);
			
		} else if(status_item.equals(StatusItem.RESERVADO)) {
			//Livro reservado, retirando dos emprestimos e adicionadno nas reservas
			this.itensEmprestados.remove((T) item);
			this.itensReservados.add((T) item);
			
		} else if(status_item.equals(StatusItem.INDISPONIVEL)) {
			return false;
			
		}
		//qualquer outro status não irá entrar nesse caso, visto que após um emprestimo o livro não ficara disponível
		
		return true;
	}
	
	public boolean emprestarItem(Membro membro, T item) throws IllegalAccessException {
		//Checa se o membro está bloqueado
    	if(membro.getBloqueado()) {
    		throw new IllegalAccessException("Membro está bloqueado e não pode realizar emprestimos.");
    	}
    	
    	//Checa se membro não passou do limite de livros emprestados
    	if(membro.getNumEmprestimo() >= membro.getLimite_emprestimo()) {
    		throw new IllegalAccessException("Membro excedeu o número de livros emprestados e não pode realizar emprestimos.");
    	}
		
		//Primeiro, realiza o emprestimo, trata os objetos emprestimos e reservas e o status do item
		emprestarItemReservaEmprestimo(membro, (Item) item);
		
		//Realiza o manejo nos set's emprestados e reservados
		itemCheckItemStatus(membro, (Item) item);
		return true;
	}
	
	private boolean reservarItemReservaEmprestimo(Membro membro, Item item) {
		//Primeiro, checar se o livro está indisponível
    	StatusItem status_item = item.getStatusItem();
    	
    	if(status_item.equals(StatusItem.INDISPONIVEL)) {
    		System.out.println("Item está indisponível e portanto não pode ser reservado.");
    	}
    	
    	//Checa se o membro já tem esse item reservado
    	LinkedList<Reserva> reservas = BibliotecaStatic.getReservas();
    	
    	for( Reserva reserva : reservas) {
    		if(reserva.getPessoa().equals(membro) && reserva.getItem().equals(item)) {
    			System.out.println("Membro já tem esse item reservado.");
    			System.out.println("Operação encerrada.");
    			return false;
    		}
    	}
    	
    	//Checa o status do item e faz o tratamento de acordo
    	//Primeiramente, independente do status do item, ele sempre poderá ser reservado, portanto, criando a reserva
    	//Cria a reserva
		Date data = new Date();
		Reserva reserva_nova = new Reserva(data,membro,item);
		
		if(status_item.equals(StatusItem.EMPRESTADO)) {
			//Altera status para emprestado e reservado
			
			item.setStatusItem(StatusItem.EMPRESTADO_E_RESERVADO);
			
		} else if (status_item.equals(StatusItem.DISPONIVEL)) {
			//Altera status para reservado
			
			item.setStatusItem(StatusItem.RESERVADO);
		}
		//Qualquer outro status se manterá o mesmo
		//Adicionando a reserva
		
		BibliotecaStatic.getReservas().add(reserva_nova);
    	
		return true;
	}
	
	public boolean reservarItem(Membro membro, T item) {
		//Primeiro, realiza o emprestimo, trata os objetos emprestimos e reservas e o status do item
		reservarItemReservaEmprestimo(membro, (Item) item);
		
		//Realiza o manejo nos set's emprestados e reservados
		itemCheckItemStatus(membro, (Item) item);
		return true;
	}
	
	private static void devolverItemReservaEmprestimo(Membro membro, Item item) {
    	
		//Procurando o emprestimo
    	Set<Emprestimo> emprestimos = BibliotecaStatic.getEmprestimos();
    	for (Emprestimo emprestimo : emprestimos) {
    		if(emprestimo.getItem().equals(item) && emprestimo.getPessoa().equals(membro)) {
    			//Encontrado o emprestimo
    			//Se desfazendo dele
    			emprestimos.remove(emprestimo);
    			
    			//Diminiui número de livros emprestados
	    		membro.setNumEmprestimo((short) (membro.getNumEmprestimo() - 1));
    			
    			//Adicionando esse emprestimo ao histórico do membro
    			membro.getHistorico_emprestimos().add(emprestimo);
    			//Avaliando o status do livro
    			
    			if(item.getStatusItem().equals(StatusItem.EMPRESTADO)) {
    				//Livro estava apenas emprestado, apenas alterando o status
    				item.setStatusItem(StatusItem.DISPONIVEL);

    				System.out.println("Livro devolvido");
    				return;
    				
    			} else if (item.getStatusItem().equals(StatusItem.EMPRESTADO_E_RESERVADO)) {
    				//Livro estava emprestado também, atribuindo o emprestimo à reserva que tem dele
    				//Iterando a lista de reservas
    				
    				boolean aux = false; //AUX irá no ajudar na iteração para ver se o item possui mais de uma reserva
    				LinkedList<Reserva> reservas = BibliotecaStatic.getReservas();
    				
    				ListIterator<Reserva> iter = reservas.listIterator();
    				while(iter.hasNext()) {
    					Reserva reserva = iter.next();
    					// procurando o reserva que existe
    					if(reserva.getItem().equals(item)) {
    						
    						if(aux == false) {
	    						//encontrado a reserva
	    						aux = true;
	    						//deletando a reserva
	    						reservas.remove(reserva);
	    						//criando novo emprestimo dessa reserva que foi deletada
	    						Emprestimo novo_emprestimo = new Emprestimo(null, null, reserva.getPessoa(), item);
	    						emprestimos.add(novo_emprestimo);
	    						//alterando status livro
	    						item.setStatusItem(StatusItem.EMPRESTADO);
    						} else {
    							//item tinha uma outra reserva, retornando ao status emprestado e reservado
    							item.setStatusItem(StatusItem.EMPRESTADO_E_RESERVADO);
    						}
    					}
    					
    					System.out.println("Livro devolvido e foi criado um novo emprestimo.");
    					return;
    				}
    				
    			}
    		}
    	}
    	
    	System.out.println("Não foi encontrado o emprestimo no sistema.");
    	return;
    }
	
	public boolean devolverItem(Membro membro, T item) {
		//Primeiro, devolve o livro, trata os objetos emprestimos e reservas e o status do item
		devolverItemReservaEmprestimo(membro, (Item) item);
		
		//Realiza o manejo nos set's emprestados e reservados
		itemCheckItemStatus(membro, (Item) item);
		return true;
	}
	
}
