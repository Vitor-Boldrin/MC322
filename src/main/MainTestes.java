package main;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeParseException;
import java.util.Collection;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import biblioteca.models.BibliotecaStatic.BibliotecaStatic;
import biblioteca.models.BibliotecaStatic.ListaReservas;
import biblioteca.models.Item.Item;
import biblioteca.models.ItemMultimidia.ItemMultimidia;
import biblioteca.models.ItemMultimidia.StatusItem;
import biblioteca.models.Membro.*;
import biblioteca.models.Recursos_Biblioteca.Categoria_equipamento;
import biblioteca.models.Recursos_Biblioteca.Equipamento;
import biblioteca.models.Recursos_Biblioteca.Evento;
import biblioteca.models.Recursos_Biblioteca.Formato_multimidia;
import biblioteca.models.Recursos_Biblioteca.Recurso;
import biblioteca.models.Recursos_Biblioteca.Recurso.Video;
import biblioteca.models.Recursos_Biblioteca.SalaBiblioteca.Sala;



public class MainTestes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		Equipamento equipamento1 = new Equipamento(1,Categoria_equipamento.AUDIOVISUAL);
		Equipamento.Audiovisual emprestimeEquipamento1 = equipamento1.new Audiovisual("notebook", "windowns");
		
		Equipamento equipamento2 = new Equipamento(1,Categoria_equipamento.AUDIOVISUAL);
		Equipamento.Audiovisual emprestimeEquipamento2 = equipamento2.new Audiovisual("notebook", "windowns");
		
		//Recurso recurso1 = new Recurso(2,Formato_multimidia.VIDEO);
		//Recurso.Video recursoEmprestimo1 = recurso1.new Video("opa","não");

		
		LocalDateTime data1 = LocalDateTime.parse("2023-10-01T06:30:04");
		
		try {
			LocalDateTime data2 = LocalDateTime.parse("2023-10-01T07:30:00");
		} catch(DateTimeParseException e) {
			System.out.println("Formato inválido");
		}
		
		if(data1.isBefore(data1) || data1.isEqual(data1)) {
			System.out.println(data1);
		}
		
	}

}
