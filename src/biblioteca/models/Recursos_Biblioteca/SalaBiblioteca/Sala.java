package biblioteca.models.Recursos_Biblioteca.SalaBiblioteca;

import biblioteca.models.Item.Item;
import biblioteca.models.ItemMultimidia.StatusItem;

public class Sala extends Item {

	private String nomeSala;
	
	public Sala(
			int id,
			String nomeSala
			) {
		super(id);
		this.nomeSala = nomeSala;
		this.setStatusItem(StatusItem.DISPONIVEL);
	}
	
	//geters e seters
	public String getNomeSala() {
	      return this.nomeSala;
	}
	
	public void setNomeSala(String nomeSala) {
	    this.nomeSala = nomeSala;
	}
	
	// Inner classes
	/*
	
	public class Sala_grupo extends Sala_biblioteca {
		private boolean tem_recurso;
		private int capacidade_maxima;
		
		public Sala_grupo(boolean tem_recurso, int capacidade_maxima) {
			this.tem_recurso = tem_recurso;
			this.capacidade_maxima = capacidade_maxima;
		}
		
		//métodos
		@Override
		public String toString() {
			return "SalaGrupo Id: " + String.valueOf( Sala.this.getId() );
		}
				
		//geters e seters
		public boolean getTem_recurso() {
		      return this.tem_recurso;
		}
		
		public void setTem_recurso(boolean tem_recurso) {
		    this.tem_recurso = tem_recurso;
		}
		
		public int getCapacidade_maxima() {
		      return this.capacidade_maxima;
		}
		
		public void setCapacidade_maxima(int capacidade_maxima) {
		    this.capacidade_maxima = capacidade_maxima;
		}
		
	}
	
	public class Sala_silenciosa extends Sala_biblioteca {
		private boolean tem_cabine_individual;
		private int numero_assentos;
		
		public Sala_silenciosa(boolean tem_cabine_individual, int numero_assentos) {
			this.tem_cabine_individual = tem_cabine_individual;
			this.numero_assentos = numero_assentos;
		}
		
		//métodos
		@Override
		public String toString() {
			return "SalaSilenciosa Id: " + String.valueOf( Sala.this.getId() );
		}
		
		public boolean getTem_cabine_individual() {
		      return this.tem_cabine_individual;
		}
		
		public void setTem_cabine_individual(boolean tem_cabine_individual) {
		    this.tem_cabine_individual = tem_cabine_individual;
		}
		
		public int getNumero_assentos() {
		      return this.numero_assentos;
		}
		
		public void setNumero_assentos(int numero_assentos) {
		    this.numero_assentos = numero_assentos;
		}
		
	}
	
	public class Sala_multimidia extends Sala_biblioteca {
		private String equipamentos;
		
		public Sala_multimidia(String equipamentos) {
			this.equipamentos = equipamentos;
		}
		
		//métodos
		@Override
		public String toString() {
			return "SalaMultimidia Id: " + String.valueOf( Sala.this.getId() );
		}
		
		public String getEquipamentos() {
		      return this.equipamentos;
		}
		
		public void setEquipamentos(String equipamentos) {
		    this.equipamentos = equipamentos;
		}
		
	} */
	
}
