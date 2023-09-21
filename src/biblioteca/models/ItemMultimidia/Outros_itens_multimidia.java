package biblioteca.models.ItemMultimidia;

public class Outros_itens_multimidia extends ItemMultimidia {

	private String tipo_recurso;
	private String formato;
	private String localizacao;
	private String estado_conservacao;
	
	public Outros_itens_multimidia(
			int id,
			String titulo,
			String autor,
			String editora,
			String ano,
			String genero,
			String sinopse,
			String capa,
			StatusItem status,
			String tipo_recurso,
			String formato,
			String localizacao,
			String estado_conservacao
			) {
	
		super(
				id,
				titulo,
				autor,
				editora,
				ano,
				genero,
				sinopse,
				capa,
				status
				);
		this.tipo_recurso = tipo_recurso;
		this.formato = formato;
		this.localizacao = localizacao;
		this.estado_conservacao = estado_conservacao;
	}
	
	public short numero_disponivel(){
		return 2;
	}
	
	public short numero_total() {
		return 2;
	}
	
	//geters e seters
	public String getTipo_recurso() {
	      return this.tipo_recurso;
	}
	
	public void setTipo_recurso(String tipo_recurso) {
	    this.tipo_recurso = tipo_recurso;
	}
	
	public String getFormato() {
	      return this.formato;
	}
	
	public void setFormato(String formato) {
	    this.formato = formato;
	}
	
	public String getLocalizacao() {
	      return this.localizacao;
	}
	
	public void setLocalizacao(String localizacao) {
	    this.localizacao = localizacao;
	}
	
	public String getEstado_conservacao() {
	      return this.estado_conservacao;
	}
	
	public void setEstado_conservacao(String estado_conservacao) {
	    this.estado_conservacao = estado_conservacao;
	}
}
