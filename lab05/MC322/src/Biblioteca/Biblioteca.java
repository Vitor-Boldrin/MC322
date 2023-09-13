package Biblioteca;

import java.util.LinkedList;

import Controle_livros.*;
import Item_multimidia.*;
import Pessoa.*;
import Recursos_Biblioteca.Equipamento.Equipamento_emprestimo;
import Recursos_Biblioteca.Reserva_sala.Sala_biblioteca;
import Recursos_Biblioteca.Evento.Evento_biblioteca;
import Recursos_Biblioteca.Recurso.Recurso_multimidia;

public class Biblioteca {
	   private String nome;
	   // Membros
	   private LinkedList<Pessoa> pessoa;
	   // Livros
	   private LinkedList<Item_multimidia> item_multimidia;
	   // Controle dos livros
	   private LinkedList<Emprestimo_item_multimidia> emprestimo_item_multimidia;
	   private LinkedList<Reserva_item_multimidia> reserva_item_multimidia;
	   // Recursos Biblioteca
	   private LinkedList<Sala_biblioteca> sala_biblioteca;
	   private LinkedList<Equipamento_emprestimo> equipamento_emprestimo;
	   private LinkedList<Evento_biblioteca> evento_biblioteca;
	   private LinkedList<Recurso_multimidia> recurso_multimidia;

	   public Biblioteca(String nome) {
	      this.nome = nome;
	      this.pessoa = new LinkedList<Pessoa>();
	      this.item_multimidia = new LinkedList<Item_multimidia>();
	      this.emprestimo_item_multimidia = new LinkedList<Emprestimo_item_multimidia>();
	      this.reserva_item_multimidia = new LinkedList<Reserva_item_multimidia>();
	      this.sala_biblioteca = new LinkedList<Sala_biblioteca>();
	      this.equipamento_emprestimo = new LinkedList<Equipamento_emprestimo>();
	      this.evento_biblioteca = new LinkedList<Evento_biblioteca>();
	      this.recurso_multimidia = new LinkedList<Recurso_multimidia>();
	   }

	   //seters e geters
	   public String getNome() {
		  return this.nome;
	   }

	   public void setNome(String nome) {
	      this.nome = nome;
	   }
	   
	   public LinkedList<Pessoa> getPessoa() {
	      return this.pessoa;
	   }

	   public void setPessoa(LinkedList<Pessoa> pessoa) {
	      this.pessoa = pessoa;
	   }

	   public LinkedList<Item_multimidia> getItem_multimidia() {
	      return this.item_multimidia;
	   }

	   public void setItem_multimidia(LinkedList<Item_multimidia> item_multimidia) {
	      this.item_multimidia = item_multimidia;
	   }
	   
	   public LinkedList<Emprestimo_item_multimidia> getEmprestimo_item_multimidia() {
		      return this.emprestimo_item_multimidia;
	   }

	   public void setEmprestimo_item_multimidia(LinkedList<Emprestimo_item_multimidia> emprestimo_item_multimidia) {
		      this.emprestimo_item_multimidia = emprestimo_item_multimidia;
	   }
	   
	   public LinkedList<Reserva_item_multimidia> getReserva_item_multimidia() {
		      return this.reserva_item_multimidia;
	   }

	   public void setReserva_item_multimidia(LinkedList<Reserva_item_multimidia> reserva_item_multimidia) {
		      this.reserva_item_multimidia = reserva_item_multimidia;
	   }
	   
	   public LinkedList<Sala_biblioteca> getSala_biblioteca() {
		      return this.sala_biblioteca;
	   }

	   public void setSala_biblioteca(LinkedList<Sala_biblioteca> sala_biblioteca) {
		      this.sala_biblioteca = sala_biblioteca;
	   }
	   
	   public LinkedList<Equipamento_emprestimo> getEquipamento_emprestimo() {
		      return this.equipamento_emprestimo;
	   }

	   public void setEquipamento_emprestimo(LinkedList<Equipamento_emprestimo> equipamento_emprestimo) {
		      this.equipamento_emprestimo = equipamento_emprestimo;
	   }
	   
	   public LinkedList<Evento_biblioteca> getEvento_biblioteca() {
		      return this.evento_biblioteca;
	   }

	   public void setEvento_biblioteca(LinkedList<Evento_biblioteca> evento_biblioteca) {
		      this.evento_biblioteca = evento_biblioteca;
	   }
	   
	   public LinkedList<Recurso_multimidia> getRecurso_multimidia() {
		      return this.recurso_multimidia;
	   }

	   public void setRecurso_multimidia(LinkedList<Recurso_multimidia> recurso_multimidia) {
		      this.recurso_multimidia = recurso_multimidia;
	   }
	   
	}

