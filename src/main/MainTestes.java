package main;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Iterator;

import biblioteca.models.BibliotecaStatic.BibliotecaStatic;
import biblioteca.models.Membro.*;

public class MainTestes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Chama");
		
		Date data = new Date();
		
		Estudante_graduacao aluno = new Estudante_graduacao(
				"Vitor",
				"245500",
				"IE",
				"Fumaça",
				data);
		
		LinkedList<Membro> membros = BibliotecaStatic.getMembros();
		
		membros.add(aluno);
		
		membros.add(aluno);
		
		for(Membro i : BibliotecaStatic.getMembros()) {
			System.out.println(i.getNome());
		}
		
		
	}

}
