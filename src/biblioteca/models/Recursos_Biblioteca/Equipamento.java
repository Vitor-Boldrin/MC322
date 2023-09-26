package biblioteca.models.Recursos_Biblioteca;

import biblioteca.models.Item.Item;
import biblioteca.models.ItemMultimidia.StatusItem;

public class Equipamento extends Item {
	private Categoria_equipamento categoria_equipamento;
	
	public Equipamento(
			int id,
			StatusItem status,
			Categoria_equipamento categoria_equipamento) {
		super(id,status);
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
	public abstract class Equipamento_emprestimo {
		private String tipo;
		private String configuracao;
		
		public Equipamento_emprestimo(String tipo, String configuracao) {
			this.tipo = tipo;
			this.configuracao = configuracao;
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
		
	}
	
	// Os 3 tipos são semelhantes, portanto, será utilizado uma classe abstrata para os 3 tipos
	
	//INFORMATICA
	public class Informatica extends Equipamento_emprestimo {
		
		public Informatica(String tipo, String configuracao) {
			super(tipo,configuracao);
		}
		
	}
	
	//INFORMATICA
	public class Audiovisual extends Equipamento_emprestimo {
		
		public Audiovisual(String tipo, String configuracao) {
			super(tipo,configuracao);
		}
		
	}
		
	//INFORMATICA
	public class Impressao extends Equipamento_emprestimo {
		
		public Impressao(String tipo, String configuracao) {
			super(tipo,configuracao);
		}
		
	}
	
}
