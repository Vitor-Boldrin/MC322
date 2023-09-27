package biblioteca.models.Recursos_Biblioteca.SalaBiblioteca;

public class SalaGrupo extends Sala {
	private boolean tem_recurso;
	private int capacidade_maxima;
	
	public SalaGrupo(
			int id,
			String nomeSala,
			boolean tem_recurso, 
			int capacidade_maxima
			) {
		
		super(id,nomeSala);
		
		this.tem_recurso = tem_recurso;
		this.capacidade_maxima = capacidade_maxima;
	}
	
	//métodos
	@Override
	public String toString() {
		return "SalaGrupo Id: " + String.valueOf( this.getId() );
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
