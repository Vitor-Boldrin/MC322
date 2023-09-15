package biblioteca.controllers;

import java.util.ArrayList;
import java.util.List;

import biblioteca.models.BibliotecaStatic.BibliotecaStatic;
import biblioteca.models.Membro.Membro;

public class MembroControllerImpl implements MembroController {
    private List<Membro> membros;

    public MembroControllerImpl() {
        membros = new ArrayList<>();
    }

    @Override
    public List<Membro> listarMembros() {
    	membros = BibliotecaStatic.getMembros();
        return membros;
    }

    @Override
    public Membro buscarMembroPorIdentificacao(String identificacao) {
        // Lógica de busca
        return null;
    }
}