package biblioteca.models.Recursos_Biblioteca.SalaBiblioteca;

public class SalaSilenciosa extends Sala {
	private boolean tem_cabine_individual;
	private int numero_assentos;
	
	public SalaSilenciosa(
			int id,
			String nomeSala,
			boolean tem_cabine_individual, 
			int numero_assentos) {
		super(id,nomeSala);
		this.tem_cabine_individual = tem_cabine_individual;
		this.numero_assentos = numero_assentos;
	}
	
	//métodos
	@Override
	public String toString() {
		return "SalaSilenciosa Id: " + String.valueOf( this.getId() );
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
