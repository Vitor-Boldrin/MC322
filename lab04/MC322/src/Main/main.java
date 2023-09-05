package Main;
import java.util.Date;
import Pessoa.*;
import Controle_livros.*;
import Item_multimidia.*;

import java.util.Date;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Estudante_graduacao Vitor = new Estudante_graduacao(
				   "Vitor", 
				   "245500", 
				   "Logo ali", 
				   "Zap",
				   new Date());
		
		System.out.println("Gerado estudante de graduação");
		
		Funcionario Ze = new Funcionario(
				   "Ze", 
				   "235349", 
				   "Logo ali", 
				   "Zap",
				   new Date(),
				   Nivel_acesso.ATENDETE);
		
		System.out.println("Gerando funcionario");
		
		DVD_de_video DVD = new DVD_de_video(
				"Filme",
				"Alguem",
				"Paramount",
				"2012",
				"Terror",
				"Muito medo na floresta",
				"capa bonita",
				"atores",
				"2 horas",
				true,
				"bem conservado",
				Status_item_multimidia.DISPONIVEL
				);
		
		System.out.println("Criado de item");
		
	}
	
	

}
