package Recursos_Biblioteca;

public class Equipamento {
	private Categoria_equipamento categoria_equipamento;
	
	public Equipamento(Categoria_equipamento categoria_equipamento) {
		this.categoria_equipamento = categoria_equipamento;
	}
	
	//geters e seters
	public Categoria_equipamento getCategoria_equipamento() {
	      return this.categoria_equipamento;
	}
	
	public void setCategoria_equipamento(Categoria_equipamento categoria_equipamento) {
	    this.categoria_equipamento = categoria_equipamento;
	}
	
	//INNER CLASS
	
	//INFORMATICA
	abstract class Equipamento_emprestimo {
		private String tipo;
		private String configuracao;
		private Status_equipamento status_equipamento;
		
		public Equipamento_emprestimo(String tipo, String configuracao, Status_equipamento status_equipamento) {
			this.tipo = tipo;
			this.configuracao = configuracao;
			this.status_equipamento = status_equipamento;
		}
		
		public Categoria_equipamento getCategoria_equipamento() {
			return categoria_equipamento;
		}
		
		//seters e geters
		public String getTipo() {
		      return this.tipo;
		}
		
		public void setTipo(String tipo) {
		    this.tipo = tipo;
		}
		
		public String getConfiguracao() {
		      return this.configuracao;
		}
		
		public void setConfiguracao(String configuracao) {
		    this.configuracao = configuracao;
		}
		
		public Status_equipamento getStatus_equipamento() {
		      return this.status_equipamento;
		}
		
		public void setStatus_equipamento(Status_equipamento status_equipamento) {
		    this.status_equipamento = status_equipamento;
		}
		
	}
	
	// Os 3 tipos são semelhantes, portanto, será utilizado uma classe abstrata para os 3 tipos
	
	//INFORMATICA
	public class Informatica extends Equipamento_emprestimo {
		
		public Informatica(String tipo, String configuracao, Status_equipamento status_equipamento) {
			super(tipo,configuracao,status_equipamento);
		}
		
	}
	
	//INFORMATICA
	public class Audiovisual extends Equipamento_emprestimo {
		
		public Audiovisual(String tipo, String configuracao, Status_equipamento status_equipamento) {
			super(tipo,configuracao,status_equipamento);
		}
		
	}
		
	//INFORMATICA
	public class Impressao extends Equipamento_emprestimo {
		
		public Impressao(String tipo, String configuracao, Status_equipamento status_equipamento) {
			super(tipo,configuracao,status_equipamento);
		}
		
	}
	
}
