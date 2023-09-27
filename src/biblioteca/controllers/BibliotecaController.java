package biblioteca.controllers;

import java.util.List;

import biblioteca.models.Item.Item;
import biblioteca.models.ItemMultimidia.ItemMultimidia;

public interface BibliotecaController {
    List<ItemMultimidia> consultarItensDisponiveis();
    Item buscarItenPorIdentificacao(int identificacao);
}