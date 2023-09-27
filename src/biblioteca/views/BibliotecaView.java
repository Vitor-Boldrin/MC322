package biblioteca.views;

import java.util.List;

import biblioteca.models.Item.Item;

public interface BibliotecaView {
    void mostrarItensDisponiveis(List<Item> itens);
    void mostrarEmprestimoStatus(boolean sucesso);
    void mostrarDevolucaoStatus(boolean sucesso);
}