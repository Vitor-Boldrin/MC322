package biblioteca.models.ItemMultimidia;

public class Comentario {
	private String membroId;
	private int itemId;
	private String texto;
	
	public Comentario(String membroId, int itemId, String texto) {
		this.membroId = membroId;
		this.itemId = itemId;
		this.texto = texto;
	}
	
	//geters e seters
	public String getMembroId() {
	      return this.membroId;
	}
	
	public void setMembroId(String MembroId) {
	    this.membroId = MembroId;
	}
	
	public int getItemId() {
	      return this.itemId;
	}
	
	public void setItemId(int itemId) {
	    this.itemId = itemId;
	}
	
	public String getTexto() {
	      return this.texto;
	}
	
	public void setTexto(String texto) {
	    this.texto = texto;
	}
	
}
