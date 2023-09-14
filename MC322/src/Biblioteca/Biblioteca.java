package Biblioteca;

import java.util.LinkedList;

import Controle_livros.*;
import Item_multimidia.*;
import Pessoa.*;
import Recursos_Biblioteca.*;

public class Biblioteca {
	   private String nome;
	   // Membros
	   private LinkedList<Estudante_graduacao> estudante_graduacao;
	   private LinkedList<Funcionario> funcionario;
	   private LinkedList<Estudante_pos> estudante_pos;
	   private LinkedList<Professor> professor;
	   // Livros
	   private LinkedList<CD_de_audio> cd_de_audio;
	   private LinkedList<DVD_de_video> dvd_de_video;
	   private LinkedList<Livro_eletronico> livro_eletronico;
	   private LinkedList<Livro_fisico> livro_fisico;
	   private LinkedList<Outros_itens_multimidia> outros_itens_multimidia;
	   // Controle dos livros
	   private LinkedList<Emprestimo_item_multimidia> emprestimo_item_multimidia;
	   private LinkedList<Reserva_item_multimidia> reserva_item_multimidia;
	   // Recursos Biblioteca
	   private LinkedList<Reserva_sala> reserva_sala;
	   private LinkedList<Recurso_multimidia> recurso_multimidia;
	   private LinkedList<Equipamento> equipamento;
	   private LinkedList<Evento> evento;

	   public Biblioteca(String nome) {
	      this.nome = nome;
	      this.estudante_graduacao = new LinkedList<Estudante_graduacao>();
	      this.funcionario = new LinkedList<Funcionario>();
	      this.estudante_pos = new LinkedList<Estudante_pos>();
	      this.professor = new LinkedList<Professor>();
	      this.cd_de_audio = new LinkedList<CD_de_audio>();
	      this.dvd_de_video = new LinkedList<DVD_de_video>();
	      this.livro_eletronico = new LinkedList<Livro_eletronico>();
	      this.livro_fisico = new LinkedList<Livro_fisico>();
	      this.outros_itens_multimidia = new LinkedList<Outros_itens_multimidia>();
	      this.emprestimo_item_multimidia = new LinkedList<Emprestimo_item_multimidia>();
	      this.reserva_item_multimidia = new LinkedList<Reserva_item_multimidia>();
	   }

	   //seters e geters
	   public String getNome() {
		  return this.nome;
	   }

	   public void setNome(String nome) {
	      this.nome = nome;
	   }
	   
	   public LinkedList<Estudante_graduacao> getEstudante_graduacao() {
	      return this.estudante_graduacao;
	   }

	   public void setEstudante_graduacao(LinkedList<Estudante_graduacao> estudante_graduacao) {
	      this.estudante_graduacao = estudante_graduacao;
	   }

	   public LinkedList<Funcionario> getFuncionario() {
	      return this.funcionario;
	   }

	   public void setFuncionario(LinkedList<Funcionario> funcionario) {
	      this.funcionario = funcionario;
	   }
	   
	   public LinkedList<Estudante_pos> getEstudante_pos() {
		      return this.estudante_pos;
	   }

	   public void setEstudante_pos(LinkedList<Estudante_pos> estudante_pos) {
		      this.estudante_pos = estudante_pos;
	   }
	   
	   public LinkedList<Professor> getProfessor() {
		      return this.professor;
	   }

	   public void setProfessor(LinkedList<Professor> professor) {
		      this.professor = professor;
	   }
	   
	   public LinkedList<CD_de_audio> getCD_de_audio() {
		      return this.cd_de_audio;
	   }

	   public void setCD_de_audio(LinkedList<CD_de_audio> cd_de_audio) {
		      this.cd_de_audio = cd_de_audio;
	   }
	   
	   public LinkedList<DVD_de_video> getDVD_de_video() {
		      return this.dvd_de_video;
	   }

	   public void setDVD_de_video(LinkedList<DVD_de_video> dvd_de_video) {
		      this.dvd_de_video = dvd_de_video;
	   }
	   
	   public LinkedList<Livro_eletronico> getLivro_eletronico() {
		      return this.livro_eletronico;
	   }

	   public void setLivro_eletronico(LinkedList<Livro_eletronico> livro_eletronico) {
		      this.livro_eletronico = livro_eletronico;
	   }
	   
	   public LinkedList<Livro_fisico> getLivro_fisico() {
		      return this.livro_fisico;
	   }

	   public void setLivro_fisico(LinkedList<Livro_fisico> livro_fisico) {
		      this.livro_fisico = livro_fisico;
	   }
	   
	   public LinkedList<Outros_itens_multimidia> getOutros_itens_multimidia() {
		      return this.outros_itens_multimidia;
	   }

	   public void setOutros_itens_multimidia(LinkedList<Outros_itens_multimidia> outros_itens_multimidia) {
		      this.outros_itens_multimidia = outros_itens_multimidia;
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
	   
	   public LinkedList<Reserva_sala> getReserva_sala() {
		      return this.reserva_sala;
	   }

	   public void setReserva_sala(LinkedList<Reserva_sala> reserva_sala) {
		      this.reserva_sala = reserva_sala;
	   }
	   
	   public LinkedList<Recurso_multimidia> getRecurso_multimidia() {
		      return this.recurso_multimidia;
	   }

	   public void setRecurso_multimidia(LinkedList<Recurso_multimidia> recurso_multimidia) {
		      this.recurso_multimidia = recurso_multimidia;
	   }
	   
	   public LinkedList<Equipamento> getEquipamento() {
		      return this.equipamento;
	   }

	   public void setEquipamento(LinkedList<Equipamento> equipamento) {
		      this.equipamento = equipamento;
	   }
	   
	   public LinkedList<Evento> getEvento() {
		      return this.evento;
	   }

	   public void setEvento(LinkedList<Evento> evento) {
		      this.evento = evento;
	   }
	   
	}

