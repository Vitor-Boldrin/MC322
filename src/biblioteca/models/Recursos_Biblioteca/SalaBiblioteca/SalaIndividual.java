package biblioteca.models.Recursos_Biblioteca.SalaBiblioteca;

public class SalaIndividual extends Sala {
	private boolean tem_computador;
	private int numero_sala;
	
	public SalaIndividual(
			int id,
			String nomeSala,
			boolean tem_computador, 
			int numero_sala) {
		
		super(id,nomeSala);
		
		this.tem_computador = tem_computador;
		this.numero_sala = numero_sala;
	}
	
	//métodos
	@Override
	public String toString() {
		return "SalaIndividual Id: " + String.valueOf( this.getId() );
	}
	
	//geters e seters
	public boolean getTem_computador() {
	      return this.tem_computador;
	}
	
	public void setTem_computador(boolean tem_computador) {
	    this.tem_computador = tem_computador;
	}
	
	public int getnumero_sala() {
	      return this.numero_sala;
	}
	
	public void setNumero_sala(int numero_sala) {
	    this.numero_sala = numero_sala;
	}
	
}
