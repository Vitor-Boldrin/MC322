package biblioteca.models.Recursos_Biblioteca;

import biblioteca.models.Item.Item;
import biblioteca.models.ItemMultimidia.StatusItem;

public class Equipamento extends Item {
	private Categoria_equipamento categoria_equipamento;
	
	public Equipamento(
			int id,
			Categoria_equipamento categoria_equipamento) {
		super(id);
		this.categoria_equipamento = categoria_equipamento;
		this.setStatusItem(StatusItem.DISPONIVEL);
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
		
		public StatusItem getStatusItem() {
			return Equipamento.this.getStatusItem();
		}
		
		public void setStatusItem(StatusItem status) {
			Equipamento.this.setStatusItem(status);
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
		
		@Override
		public String toString() {
			return "EquipamentoInformática Id: " + String.valueOf( Equipamento.this.getId() );
		}
		
	}
	
	//INFORMATICA
	public class Audiovisual extends Equipamento_emprestimo {
		
		public Audiovisual(String tipo, String configuracao) {
			super(tipo,configuracao);
		}
		
		@Override
		public String toString() {
			return "EquipamentoAudivisual Id: " + String.valueOf( Equipamento.this.getId() );
		}
		
	}
		
	//INFORMATICA
	public class Impressao extends Equipamento_emprestimo {
		
		public Impressao(String tipo, String configuracao) {
			super(tipo,configuracao);
		}
		
		@Override
		public String toString() {
			return "EquipamentoImpressão Id: " + String.valueOf( Equipamento.this.getId() );
		}
		
	}
	
}
