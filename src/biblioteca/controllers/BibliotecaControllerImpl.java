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
import biblioteca.models.ItemMultimidia.StatusItem;
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
    
    public ItemMultimidia buscarItenPorIdentificacao(int identificacao) {
    	//Inicializando variável do membro a ser editado
    	ItemMultimidia item_editar = null;
    	
    	//Loop para achar o membro a partir do ID
    	List<ItemMultimidia> Itens = BibliotecaStatic.getItens();
    	for( ItemMultimidia item : Itens) {
    		if(item.getId() == identificacao) {
    			item_editar = item;
    			break;
    		}
    	}
    	//Checa se o membro existe
    	if(item_editar == null) {
    		System.out.println("Nenhum membro possui tal ID.");
    		return null;
    	}
        return item_editar;
    }

}