package Main;
import java.util.Date;
import Pessoa.*;
import Controle_livros.*;
import Item_multimidia.*;
import Recursos_Biblioteca.*;

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
		
		System.out.println("Criado item");
		
		Recurso_multimidia Recurso = new Recurso_multimidia(Formato_multimidia.SOFTWARE);
		Recurso_multimidia.Software MatLab = Recurso.new Software("MatLab","Software matemático");
		
		System.out.println("Recurso para memáticos aplicados:");
		
		System.out.println(MatLab.getTitulo());
		
		Date nao_sei_usar_dates_ainda = new Date();
		
		Evento Novo_evento = new Evento (Tipo_evento.PALESTRA);
		Evento.Palestra Palestra_IC = Novo_evento.new Palestra(
													nao_sei_usar_dates_ainda,
													nao_sei_usar_dates_ainda,
													"IC",
													"IA",
													"Seu Jorge");
		
		System.out.println("Palestra marcada:");
		
		System.out.println(Palestra_IC.getTopico());
		
		System.out.println(Palestra_IC.duracao_evento_minutos());
		
	}
	
	

}
