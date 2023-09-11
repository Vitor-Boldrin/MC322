package Controle_livros;
import java.util.Date;

import Pessoa.*;
import Item_multimidia.*;

public class Emprestimo_item_multimidia {

	private Date data_emprestimo;
	
	// Construtor
	public Emprestimo_item_multimidia(Date data_emprestimo) {
		this.data_emprestimo = data_emprestimo;
	}
	
	
	// Geter e Seters
	public Date getData_emprestimo() {
	      return this.data_emprestimo;
	}
	
	public void setData_emprestimo(Date data_emprestimo) {
	    this.data_emprestimo = data_emprestimo;
	}
	
	// A Emprestimo irá conter um único membro e um único item multimidia
	// para isso, será utilizado inner classes
	
	// INNER CLASSES MEMBROS
	
	public class Emprestimo_estudante_graducao {
		private Estudante_graduacao estudante_graduacao;
		
		public Emprestimo_estudante_graducao(Estudante_graduacao estudante_graduacao) {
			this.estudante_graduacao = estudante_graduacao;
		}
		
		public Estudante_graduacao getEstudante_graduacao() {
		      return this.estudante_graduacao;
		}
		
		public void setEstudante_graduacao(Estudante_graduacao estudante_graduacao) {
		    this.estudante_graduacao = estudante_graduacao;
		}
		
		
	}
	
	public class Emprestimo_estudante_pos {
		private Estudante_pos estudante_pos;
		
		public Emprestimo_estudante_pos(Estudante_pos estudante_pos) {
			this.estudante_pos = estudante_pos;
		}
		
		public Estudante_pos getEstudante_pos() {
		      return this.estudante_pos;
		}
		
		public void setEstudante_pos(Estudante_pos estudante_pos) {
		    this.estudante_pos = estudante_pos;
		}
		
	}
	
	public class Emprestimo_funcionario {
		private Funcionario funcionario;
		
		public Emprestimo_funcionario(Funcionario funcionario) {
			this.funcionario = funcionario;
		}
		
		public Funcionario getFuncionario() {
		      return this.funcionario;
		}
		
		public void setFuncionario(Funcionario funcionario) {
		    this.funcionario = funcionario;
		}
		
	}
	
	public class Emprestimo_professor {
		private Professor professor;
		
		public Emprestimo_professor(Professor professor) {
			this.professor = professor;
		}
		
		public Professor getProfessor() {
		      return this.professor;
		}
		
		public void setProfessor(Professor professor) {
		    this.professor = professor;
		}
		
	}
	
	// INNER CLASSES PARA ITENS MULTIMIDIA
	
	public class Emprestimo_CD_de_audio {
		private CD_de_audio cd_de_audio;
		
		public Emprestimo_CD_de_audio(CD_de_audio cd_de_audio) {
			this.cd_de_audio = cd_de_audio;
		}
		
		public CD_de_audio getCD_de_audio() {
		      return this.cd_de_audio;
		}
		
		public void setCD_de_audio(CD_de_audio cd_de_audio) {
		    this.cd_de_audio = cd_de_audio;
		}
		
	}
	
	public class Emprestimo_DVD_de_video {
		private DVD_de_video dvd_de_video;
		
		public Emprestimo_DVD_de_video(DVD_de_video dvd_de_video) {
			this.dvd_de_video = dvd_de_video;
		}
		
		public DVD_de_video getDVD_de_video() {
		      return this.dvd_de_video;
		}
		
		public void setDVD_de_video(DVD_de_video dvd_de_audio) {
		    this.dvd_de_video = dvd_de_audio;
		}
		
	}
	
	public class Emprestimo_livro_eletronico {
		private Livro_eletronico livro_eletronico;
		
		public Emprestimo_livro_eletronico(Livro_eletronico livro_eletronico) {
			this.livro_eletronico = livro_eletronico;
		}
		
		public Livro_eletronico getLivro_eletronico() {
		      return this.livro_eletronico;
		}
		
		public void setLivro_eletronico(Livro_eletronico livro_eletronico) {
		    this.livro_eletronico = livro_eletronico;
		}
		
	}
	
	public class Emprestimo_livro_fisico {
		private Livro_fisico livro_fisico;
		
		public Emprestimo_livro_fisico(Livro_fisico livro_fisico) {
			this.livro_fisico = livro_fisico;
		}
		
		public Livro_fisico getLivro_fisico() {
		      return this.livro_fisico;
		}
		
		public void setLivro_fisico(Livro_fisico livro_fisico) {
		    this.livro_fisico = livro_fisico;
		}
		
	}
	
	public class Emprestimo_outros_itens_multimidia {
		private Outros_itens_multimidia outros_itens_multimidia;
		
		public Emprestimo_outros_itens_multimidia(Outros_itens_multimidia outros_itens_multimidia) {
			this.outros_itens_multimidia = outros_itens_multimidia;
		}
		
		public Outros_itens_multimidia getOutros_itens_multimidia() {
		      return this.outros_itens_multimidia;
		}
		
		public void setOutros_itens_multimidia(Outros_itens_multimidia outros_itens_multimidia) {
		    this.outros_itens_multimidia = outros_itens_multimidia;
		}
		
	}
}
