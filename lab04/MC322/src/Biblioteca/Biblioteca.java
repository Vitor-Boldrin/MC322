package Biblioteca;

import java.util.ArrayList;

import Controle_livros.*;
import Item_multimidia.*;
import Pessoa.*;

public class Biblioteca {
	   private String nome;
	   // Membros
	   private ArrayList<Estudante_graduacao> estudante_graduacao;
	   private ArrayList<Funcionario> funcionario;
	   private ArrayList<Estudante_pos> estudante_pos;
	   private ArrayList<Professor> professor;
	   // Livros
	   private ArrayList<CD_de_audio> cd_de_audio;
	   private ArrayList<DVD_de_video> dvd_de_video;
	   private ArrayList<Livro_eletronico> livro_eletronico;
	   private ArrayList<Livro_fisico> livro_fisico;
	   private ArrayList<Outros_itens_multimidia> outros_itens_multimidia;
	   // Controle dos livros
	   private ArrayList<Emprestimo_item_multimidia> emprestimo_item_multimidia;
	   private ArrayList<Reserva_item_multimidia> reserva_item_multimidia;

	   public Biblioteca(String nome) {
	      this.nome = nome;
	      this.estudante_graduacao = new ArrayList<Estudante_graduacao>();
	      this.funcionario = new ArrayList<Funcionario>();
	      this.estudante_pos = new ArrayList<Estudante_pos>();
	      this.professor = new ArrayList<Professor>();
	      this.cd_de_audio = new ArrayList<CD_de_audio>();
	      this.dvd_de_video = new ArrayList<DVD_de_video>();
	      this.livro_eletronico = new ArrayList<Livro_eletronico>();
	      this.livro_fisico = new ArrayList<Livro_fisico>();
	      this.outros_itens_multimidia = new ArrayList<Outros_itens_multimidia>();
	      this.emprestimo_item_multimidia = new ArrayList<Emprestimo_item_multimidia>();
	      this.reserva_item_multimidia = new ArrayList<Reserva_item_multimidia>();
	   }

	   //seters e geters
	   public String getNome() {
		  return this.nome;
	   }

	   public void setNome(String nome) {
	      this.nome = nome;
	   }
	   
	   public ArrayList<Estudante_graduacao> getEstudante_graduacao() {
	      return this.estudante_graduacao;
	   }

	   public void setEstudante_graduacao(ArrayList<Estudante_graduacao> estudante_graduacao) {
	      this.estudante_graduacao = estudante_graduacao;
	   }

	   public ArrayList<Funcionario> getFuncionario() {
	      return this.funcionario;
	   }

	   public void setFuncionario(ArrayList<Funcionario> funcionario) {
	      this.funcionario = funcionario;
	   }
	   
	   public ArrayList<Estudante_pos> getEstudante_pos() {
		      return this.estudante_pos;
	   }

	   public void setEstudante_pos(ArrayList<Estudante_pos> estudante_pos) {
		      this.estudante_pos = estudante_pos;
	   }
	   
	   public ArrayList<Professor> getProfessor() {
		      return this.professor;
	   }

	   public void setProfessor(ArrayList<Professor> professor) {
		      this.professor = professor;
	   }
	   
	   public ArrayList<CD_de_audio> getCD_de_audio() {
		      return this.cd_de_audio;
	   }

	   public void setCD_de_audio(ArrayList<CD_de_audio> cd_de_audio) {
		      this.cd_de_audio = cd_de_audio;
	   }
	   
	   public ArrayList<DVD_de_video> getDVD_de_video() {
		      return this.dvd_de_video;
	   }

	   public void setDVD_de_video(ArrayList<DVD_de_video> dvd_de_video) {
		      this.dvd_de_video = dvd_de_video;
	   }
	   
	   public ArrayList<Livro_eletronico> getLivro_eletronico() {
		      return this.livro_eletronico;
	   }

	   public void setLivro_eletronico(ArrayList<Livro_eletronico> livro_eletronico) {
		      this.livro_eletronico = livro_eletronico;
	   }
	   
	   public ArrayList<Livro_fisico> getLivro_fisico() {
		      return this.livro_fisico;
	   }

	   public void setLivro_fisico(ArrayList<Livro_fisico> livro_fisico) {
		      this.livro_fisico = livro_fisico;
	   }
	   
	   public ArrayList<Outros_itens_multimidia> getOutros_itens_multimidia() {
		      return this.outros_itens_multimidia;
	   }

	   public void setOutros_itens_multimidia(ArrayList<Outros_itens_multimidia> outros_itens_multimidia) {
		      this.outros_itens_multimidia = outros_itens_multimidia;
	   }
	   
	   public ArrayList<Emprestimo_item_multimidia> getEmprestimo_item_multimidia() {
		      return this.emprestimo_item_multimidia;
	   }

	   public void setEmprestimo_item_multimidia(ArrayList<Emprestimo_item_multimidia> emprestimo_item_multimidia) {
		      this.emprestimo_item_multimidia = emprestimo_item_multimidia;
	   }
	   
	   public ArrayList<Reserva_item_multimidia> getReserva_item_multimidia() {
		      return this.reserva_item_multimidia;
	   }

	   public void setReserva_item_multimidia(ArrayList<Reserva_item_multimidia> reserva_item_multimidia) {
		      this.reserva_item_multimidia = reserva_item_multimidia;
	   }
	   
	}

