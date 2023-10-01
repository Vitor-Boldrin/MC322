package biblioteca.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import biblioteca.models.BibliotecaStatic.BibliotecaStatic;
import biblioteca.models.Membro.Funcionario;
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
    	//Inicializando variável do membro a ser editado
    	Membro membro_editar = null;
    	
    	//Loop para achar o membro a partir do ID
    	List<Membro> Membros = BibliotecaStatic.getMembros();
    	for( Membro membro : Membros) {
    		if(membro.getId_faculdade().equals(identificacao)) {
    			membro_editar = membro;
    			break;
    		}
    	}
    	//Checa se o membro existe
    	if(membro_editar == null) {
    		System.out.println("Nenhum membro possui tal ID.");
    		return null;
    	}
        return membro_editar;
    }
    
    public Membro efetuaLogin(Scanner scanner) {
    	System.out.println("Efetue o Login:");
    	
    	System.out.print("Usuário:");
    	String usuario = scanner.nextLine();
    	System.out.print("Senha:");
    	String senha = scanner.nextLine();
    	
    	List<Membro> Membros = BibliotecaStatic.getMembros();
    	for( Membro membro : Membros) {
    		if( membro instanceof Funcionario) {
    			if( ((Funcionario) membro).getUsuario().equals(usuario) && ((Funcionario) membro).getSenha().equals(senha)) {
    				return membro;
    			}
    		}
    	}
    	
    	return null;
    }
}