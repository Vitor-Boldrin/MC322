package biblioteca.controllers;

import java.util.List;

import biblioteca.models.ItemMultimidia.ItemMultimidia;
import biblioteca.models.Membro.Membro;

public interface BibliotecaController<T> {
    List<ItemMultimidia> consultarItensDisponiveis();
    ItemMultimidia buscarItenPorIdentificacao(int identificacao);
}