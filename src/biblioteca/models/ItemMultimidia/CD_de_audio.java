package biblioteca.models.ItemMultimidia;

public class CD_de_audio extends ItemMultimidia {

	private String lista_de_faixas;
	private int duracao;
	private EstadoItemMultimidia estado_conservacao;
	
	public CD_de_audio(
			int id,
			String titulo,
			String autor,
			String editora,
			String ano,
			String genero,
			String sinopse,
			String capa,
			String lista_de_faixas,
			int duracao,
			EstadoItemMultimidia estado_conservacao,
			StatusItem status
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
		this.lista_de_faixas = lista_de_faixas;
		this.duracao = duracao;
		this.estado_conservacao = estado_conservacao;
	}
	
	public short numero_disponivel(){
		return 2;
	}
	
	public short numero_total() {
		return 2;
	}
	
	//geters e seters
	public String getLista_de_faixas() {
	      return this.lista_de_faixas;
	}
	
	public void setIsbn(String lista_de_faixas) {
	    this.lista_de_faixas = lista_de_faixas;
	}
	
	public int getDuracao() {
	      return this.duracao;
	}
	
	public void setDuracao(int duracao) {
	    this.duracao = duracao;
	}
	
	public EstadoItemMultimidia getEstado_conservacao() {
	      return this.estado_conservacao;
	}
	
	public void setEstado_conservacao(EstadoItemMultimidia estado_conservacao) {
	    this.estado_conservacao = estado_conservacao;
	}
	
}
