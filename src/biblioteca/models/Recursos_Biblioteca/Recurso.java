package biblioteca.models.Recursos_Biblioteca;

import biblioteca.models.Item.Item;
import biblioteca.models.ItemMultimidia.StatusItem;

public class Recurso extends Item {
	
	private Formato_multimidia formato_multimidia;
	
	public Recurso(
			int id,
			StatusItem status,
			Formato_multimidia formato_multimidia) {
		super(id,status);
		this.formato_multimidia = formato_multimidia;
	}
	
	//geters e seters
	public Formato_multimidia getFormato_multimidia() {
	      return this.formato_multimidia;
	}
	
	public void setFormato_multimidia(Formato_multimidia formato_multimidia) {
	    this.formato_multimidia = formato_multimidia;
	}
	
	//ABSTRACT CLASS para as inner class que são semelhantes
	public abstract class Recurso_multimidia {
		private String titulo;
		private String detalhes;
		
		public Recurso_multimidia(String titulo, String detalhes) {
			this.titulo = titulo;
			this.detalhes = detalhes;
		}
		
		//metodos
		public Formato_multimidia getFormato_multimidia() {
			return formato_multimidia;
		}
		
		//geters e seters
		public String getTitulo() {
		      return this.titulo;
		}
		
		public void setTitulo(String titulo) {
		    this.titulo = titulo;
		}
		
		public String getDetalhes() {
		      return this.detalhes;
		}
		
		public void setDetalhes(String detalhes) {
		    this.detalhes = detalhes;
		}
		
		
	}
	
	//INNER CLASSES
	public class Audio extends Recurso_multimidia {
		
		public Audio(String titulo, String detalhes) {
			super(titulo, detalhes);
		}	
		
	}
	
	public class Video extends Recurso_multimidia {
		
		public Video(String titulo, String detalhes) {
			super(titulo, detalhes);
		}	
		
	}
	
	public class Software extends Recurso_multimidia {
		
		public Software(String titulo, String detalhes) {
			super(titulo, detalhes);
		}	
		
	}
}
