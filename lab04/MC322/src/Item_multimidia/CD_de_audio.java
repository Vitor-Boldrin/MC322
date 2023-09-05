package Item_multimidia;

public class CD_de_audio extends Item_multimidia {

	private String lista_de_faixas;
	private String duracao;
	private String estado_conservacao;
	
	public CD_de_audio(
			String titulo,
			String autor,
			String editora,
			String ano,
			String genero,
			String sinopse,
			String capa,
			short numero_total,
			String lista_de_faixas,
			String duracao,
			String estado_conservacao
			) {
	
		super(
				titulo,
				autor,
				editora,
				ano,
				genero,
				sinopse,
				capa,
				numero_total
				);
		this.lista_de_faixas = lista_de_faixas;
		this.duracao = duracao;
		this.estado_conservacao = estado_conservacao;
	}
	
	public short numero_disponivel(){
		return 2;
	}
	
	//geters e seters
	public String getLista_de_faixas() {
	      return this.lista_de_faixas;
	}
	
	public void setIsbn(String lista_de_faixas) {
	    this.lista_de_faixas = lista_de_faixas;
	}
	
	public String getDuracao() {
	      return this.duracao;
	}
	
	public void setDuracao(String duracao) {
	    this.duracao = duracao;
	}
	
	public String getEstado_conservacao() {
	      return this.estado_conservacao;
	}
	
	public void setEstado_conservacao(String estado_conservacao) {
	    this.estado_conservacao = estado_conservacao;
	}
	
}
