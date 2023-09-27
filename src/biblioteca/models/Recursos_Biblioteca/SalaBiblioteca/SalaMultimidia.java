package biblioteca.models.Recursos_Biblioteca.SalaBiblioteca;

public class SalaMultimidia extends Sala {
	private String equipamentos;
	
	public SalaMultimidia(
			int id,
			String nomeSala,
			String equipamentos) {
		super(id,nomeSala);
		this.equipamentos = equipamentos;
	}
	
	//métodos
	@Override
	public String toString() {
		return "SalaMultimidia Id: " + String.valueOf( this.getId() );
	}
	
	public String getEquipamentos() {
	      return this.equipamentos;
	}
	
	public void setEquipamentos(String equipamentos) {
	    this.equipamentos = equipamentos;
	}
	
}
