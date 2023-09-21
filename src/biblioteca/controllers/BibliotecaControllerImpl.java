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

}