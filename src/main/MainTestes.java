package main;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Iterator;
import java.util.Scanner;

import biblioteca.models.BibliotecaStatic.BibliotecaStatic;
import biblioteca.models.ItemMultimidia.ItemMultimidia;
import biblioteca.models.Membro.*;

public class MainTestes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String a = "olar";
		
		Date data4 = new Date();
		
		Date data = new Date();
        
		//Estudante_graduacao.class;
		
        // Cria objeto
        Estudante_graduacao professor = new Estudante_graduacao(
        		"nome4",
        		"",
        		"endereco4",
        		"contato4",
				data4);
		
		System.out.println(data.getClass().equals(Estudante_graduacao.class));
		
	}

}
