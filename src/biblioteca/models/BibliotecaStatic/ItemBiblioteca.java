package biblioteca.models.BibliotecaStatic;

import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

import biblioteca.models.Controle_livros.Emprestimo;
import biblioteca.models.Controle_livros.Reserva;
import biblioteca.models.ItemMultimidia.ItemMultimidia;
import biblioteca.models.ItemMultimidia.Status_item_multimidia;
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
	
	private boolean emprestarItemReservaEmprestimo(Membro membro, ItemMultimidia item) {
        // Primeiro, checar se o livro está disponível
    	Status_item_multimidia status_item = item.getStatus();
    	
    	// Checa se o membro já tem esse item emprestado
    	Set<Emprestimo> emprestimos = BibliotecaStatic.getEmprestimos();
    	
    	for( Emprestimo emprestimo : emprestimos) {
    		if(emprestimo.getPessoa().equals(membro) && emprestimo.getItem_multimidia().equals(item)) {
    			System.out.println("Membro já tem esse item emprestado.");
    			System.out.println("Operação encerrada.");
    			return false;
    		}
    	}
    	
    	if(status_item.equals(Status_item_multimidia.DISPONIVEL)) { 
    		// DISPONÍVEL
    		//Cria o emprestimo
    		Date data = new Date();
    		Emprestimo emprestimo = new Emprestimo(data,data,membro,item);
    		
    		//Adiciona o emprestimo no Set
    		BibliotecaStatic.getEmprestimos().add(emprestimo);
    		item.setStatus(Status_item_multimidia.EMPRESTADO);
    		
    		System.out.println("Livro emprestado com sucesso.");
    		
    		return true;
    		
    	} else if(status_item.equals(Status_item_multimidia.EMPRESTADO)
    			|| status_item.equals(Status_item_multimidia.EMPRESTADO_E_RESERVADO)) { 
    		// ITEM JÁ EMPRESTADO
    		System.out.println("Livro está emprestado.");
    		
    		//Checa se o membro já tem uma reserva no item, antes de criar outra
    		LinkedList<Reserva> reservas = BibliotecaStatic.getReservas();
    		
    		for( Reserva reserva : reservas) {
        		if(reserva.getPessoa().equals(membro) && reserva.getItem_multimidia().equals(item)) {
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
    		item.setStatus(Status_item_multimidia.EMPRESTADO_E_RESERVADO);
    		
    		System.out.println("Uma reserva foi gerada");
    		
    		return false;
    		
    		
    	} else if(status_item.equals(Status_item_multimidia.RESERVADO)) {
    		//Livro está reservado
    		System.out.println("Livro está reservado.");

    		
    		//Checando se o próximo na lista é o membro e se ele tem a reserva
    		LinkedList<Reserva> reservas = BibliotecaStatic.getReservas();
    		
    		int aux = 0;
    		int aux2 = 0;
    		Reserva reserva_membro = null;
    		
    		for( Reserva reserva : reservas) {
    			if(reserva.getItem_multimidia().equals(item)) {
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
        		item.setStatus(Status_item_multimidia.EMPRESTADO);
        		
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
    		System.out.println("Livro está indisponível");
    		return false;
    	}
    	
		return false;

    }
	
	private boolean emprestarItemCheckItemStatus(Membro membro, ItemMultimidia item) {
		//Checa o status do item após o emprestimo
		Status_item_multimidia status_item = item.getStatus();
		
		//Faz a alocação dos itens no set da classe atual dependento do seu status
		if(status_item.equals(Status_item_multimidia.EMPRESTADO)) {
			//Livro somente emprestado, retirando do set de reservas e adicionando na set de emprestimos
			this.itensEmprestados.add((T) item);
			this.itensReservados.remove((T) item);
			
		} else if(status_item.equals(Status_item_multimidia.EMPRESTADO_E_RESERVADO)) {
			//Livro emprestado e reservado, adicionando nos 2 sets
			this.itensEmprestados.add((T) item);
			this.itensReservados.add((T) item);
			
		} else if(status_item.equals(Status_item_multimidia.RESERVADO)) {
			//Livro reservado, retirando dos emprestimos e adicionadno nas reservas
			this.itensEmprestados.remove((T) item);
			this.itensReservados.add((T) item);
			
		} else if(status_item.equals(Status_item_multimidia.INDISPONIVEL)) {
			return false;
			
		}
		//qualquer outro status não irá entrar nesse caso, visto que após um emprestimo o livro não ficara disponível
		
		return true;
	}
	
	public boolean emprestarItem(Membro membro, T item) {
		//Primeiro, realiza o emprestimo, trata os objetos emprestimos e reservas e o status do item
		emprestarItemReservaEmprestimo(membro, (ItemMultimidia) item);
		
		//Realiza o manejo nos set's emprestados e reservados
		emprestarItemCheckItemStatus(membro, (ItemMultimidia) item);
		return true;
	}
}
