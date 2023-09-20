package biblioteca.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import biblioteca.models.BibliotecaStatic.BibliotecaStatic;
import biblioteca.models.Controle_livros.Emprestimo;
import biblioteca.models.Controle_livros.Reserva;
import biblioteca.models.ItemMultimidia.ItemMultimidia;
import biblioteca.models.ItemMultimidia.Status_item_multimidia;
import biblioteca.models.Membro.Membro;

public class BibliotecaControllerImpl implements BibliotecaController {
    private List<ItemMultimidia> itens;

    public BibliotecaControllerImpl() {
        itens = new ArrayList<>();
    }

    @Override
    public List<ItemMultimidia> consultarItensDisponiveis() {
        return itens;
    }

    @Override
    public boolean emprestarItem(Membro membro, ItemMultimidia item) {
        // Primeiro, checar se o livro está disponível
    	Status_item_multimidia status_item = item.getStatus();
    	
    	// Checa se o membro já tem esse item emprestado
    	Set<Emprestimo> emprestimos = BibliotecaStatic.getEmprestimos();
    	
    	for( Emprestimo emprestimo : emprestimos) {
    		if(emprestimo.getPessoa().equals(membro)) {
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
    		
    		//Checando se o próximo na lista é o membro
    		LinkedList<Reserva> reservas = BibliotecaStatic.getReservas();
    		
    		int aux = 0;
    		Reserva reserva_membro = null;
    		
    		for( Reserva reserva : reservas) {
    			if(reserva.getItem_multimidia().equals(item)) {
					aux++;
		    		if(reserva.getPessoa().equals(membro)) {
		    			reserva_membro = reserva;
		    			break;
		    		}
    			}
        	}
    		
    		if(aux == 1 && reserva_membro != null) {
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
    			
    			
    		} else {
    			System.out.println("O membro ainda não tem a reserva");
    			
    			//Cria a reserva
        		Date data = new Date();
        		Reserva reserva = new Reserva(data, membro, item);
        		
        		//Adiciona na lista
        		BibliotecaStatic.getReservas().add(reserva);
        		
        		System.out.println("Uma reserva foi gerada");
        		
        		return false;
    		}
    		
    	} else { // O LIVRO EXPLODIU
    		System.out.println("Livro está indisponível");
    		return false;
    	}
    	
		return false;

    }

    @Override
    public boolean devolverItem(Membro membro, ItemMultimidia item) {
        // Lógica de devolução
        return true;
    }
}