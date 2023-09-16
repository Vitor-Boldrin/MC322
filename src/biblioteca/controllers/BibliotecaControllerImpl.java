package biblioteca.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import biblioteca.models.BibliotecaStatic.BibliotecaStatic;
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
    	if(status_item.equals(Status_item_multimidia.DISPONIVEL)) {
    		//Continua
    	} else if(status_item.equals(Status_item_multimidia.EMPRESTADO)
    			|| status_item.equals(Status_item_multimidia.RESERVADO)
    			|| status_item.equals(Status_item_multimidia.EMPRESTADO_E_RESERVADO)) {
    		
    		//Cria a reserva
    		Date data = new Date();
    		Reserva reserva = new Reserva(data, membro, item);
    		
    		//Adiciona na lista
    		BibliotecaStatic.getReservas().add(reserva);
    		
    		
    	} else {
    		System.out.println("Livro está indisponível");
    		return false;
    	}
    	
        return true;
    }

    @Override
    public boolean devolverItem(Membro membro, ItemMultimidia item) {
        // Lógica de devolução
        return true;
    }
}