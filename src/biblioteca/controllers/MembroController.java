package biblioteca.controllers;

import java.util.List;
import java.util.Scanner;

import biblioteca.models.Membro.Membro;

public interface MembroController {
    List<Membro> listarMembros();
    Membro buscarMembroPorIdentificacao(String identificacao);
    Membro efetuaLogin(Scanner scanner);
}