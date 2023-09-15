package biblioteca.views;

import java.util.List;
import biblioteca.models.ItemMultimidia.ItemMultimidia;
import biblioteca.models.ItemMultimidia.Status_item_multimidia;
import biblioteca.controllers.BibliotecaController;

public class BibliotecaViewImpl implements BibliotecaView {
    private BibliotecaController bibliotecaController;

    public BibliotecaViewImpl(BibliotecaController controller) {
        bibliotecaController = controller;
    }

    @Override
    public void mostrarItensDisponiveis(List<ItemMultimidia> itens) {
        // Implementação da exibição de itens disponíveis
    	System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAA");
    	Status_item_multimidia disponivel = Status_item_multimidia.DISPONIVEL;
    	
    	for( ItemMultimidia item : itens) {
    		if(item.getStatus().equals(disponivel)) {
    			System.out.println(item.getTitulo());
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