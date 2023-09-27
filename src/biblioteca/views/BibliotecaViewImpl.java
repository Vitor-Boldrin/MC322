package biblioteca.views;

import java.util.List;

import biblioteca.models.Item.Item;
import biblioteca.models.ItemMultimidia.ItemMultimidia;
import biblioteca.models.ItemMultimidia.StatusItem;
import biblioteca.controllers.BibliotecaController;

public class BibliotecaViewImpl implements BibliotecaView {
    private BibliotecaController bibliotecaController;

    public BibliotecaViewImpl(BibliotecaController controller) {
        bibliotecaController = controller;
    }

    @Override
    public void mostrarItensDisponiveis(List<Item> itens) {
        // Implementação da exibição de itens disponíveis
    	StatusItem disponivel = StatusItem.DISPONIVEL;
    	
    	for( Item item : itens) {
    		if(item.getStatusItem().equals(disponivel)) {
    			System.out.println(item.toString());
    		}
    	}
    }

    @Override
    public void mostrarEmprestimoStatus(boolean sucesso) {
        if (sucesso) {
            System.out.println("Empréstimo realizado com sucesso.");
        } else {
            System.out.println("Falha ao realizar o empréstimo.");
        }
    }

    @Override
    public void mostrarDevolucaoStatus(boolean sucesso) {
        if (sucesso) {
            System.out.println("Devolução realizada com sucesso.");
        } else {
            System.out.println("Falha ao realizar a devolução.");
        }
    }
}