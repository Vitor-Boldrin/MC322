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
import biblioteca.models.Excecao.ExcecaoEmprestimo;
import biblioteca.models.Excecao.ExcecaoNumeroDeEmprestimoExcedido;
import biblioteca.models.Item.Item;
import biblioteca.models.ItemMultimidia.ItemMultimidia;
import biblioteca.models.ItemMultimidia.Livro_eletronico;
import biblioteca.models.ItemMultimidia.StatusItem;
import biblioteca.models.Membro.*;
import biblioteca.models.Recursos_Biblioteca.Categoria_equipamento;
import biblioteca.models.Recursos_Biblioteca.Equipamento;
import biblioteca.models.Recursos_Biblioteca.Evento;
import biblioteca.models.Recursos_Biblioteca.Formato_multimidia;
import biblioteca.models.Recursos_Biblioteca.Recurso;
import biblioteca.models.Recursos_Biblioteca.Recurso.Video;
import biblioteca.models.Recursos_Biblioteca.SalaBiblioteca.Sala;
import java.lang.reflect.*;
import biblioteca.metadados.*;


public class MainTestes {

	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
		// TODO Auto-generated method stub


		Equipamento equipamento1 = new Equipamento(1,Categoria_equipamento.AUDIOVISUAL);
		Equipamento.Audiovisual emprestimeEquipamento1 = equipamento1.new Audiovisual("notebook", "windowns");
		
		Equipamento equipamento2 = new Equipamento(1,Categoria_equipamento.AUDIOVISUAL);
		Equipamento.Audiovisual emprestimeEquipamento2 = equipamento2.new Audiovisual("notebook", "windowns");
		
		//Recurso recurso1 = new Recurso(2,Formato_multimidia.VIDEO);
		//Recurso.Video recursoEmprestimo1 = recurso1.new Video("opa","não");

		
		LocalDateTime data1 = LocalDateTime.parse("2023-10-01T06:30:04");
		
		//try {
		//	throw new ExcecaoNumeroDeEmprestimoExcedido("nao");
		//} catch(ExcecaoEmprestimo e) {
		//	System.out.println("AAAAAAAAAAA");
		//}
		
		System.out.println("AAAAAA");
		
		Date data_disponibilidades2 = new Date();
		
		Livro_eletronico livro2 = new Livro_eletronico(
        		1,
        		"titulo2",
        		"autor2",
        		"editora2",
        		"ano2",
        		"genero2",
        		"sinopse2",
        		"capa2",
        		StatusItem.DISPONIVEL,
        		"formato2",
        		"formato_arquivo2",
        		"url_acesso2",
        		"requisitos_leitura2",
        		data_disponibilidades2);
		
		System.out.println(livro2.toString());
		
		BibliotecaStatic.getItens().add(livro2);
		
		
		
		
		Date dat1 = new Date();
		
		Estudante_graduacao aluno1 = new Estudante_graduacao(
        		"oie",
        		"id_faculdade1",
        		"endereco1",
        		"contato1",
				dat1,
				true);
		
		BibliotecaStatic.getMembros().add(aluno1);
		
		Estudante_graduacao aluno2 = new Estudante_graduacao(
        		"oie",
        		"id_facadsuldade1",
        		"enderecasdasdaso1",
        		"contatAAAAAAAo1",
				dat1,
				true);
		
		BibliotecaStatic.getMembros().add(aluno2);
		
		
	    CReflection ref = new CReflection();
	    
	    ref.MetadadosLista(BibliotecaStatic.getMembros());

	    
	    
	}

}
