package Item_multimidia;

public class DVD_de_video extends Item_multimidia {

	private String elenco;
	private String duracao;
	private boolean legendas_e_audio;
	private String estado_conservacao;
	
	public DVD_de_video(
			String titulo,
			String autor,
			String editora,
			String ano,
			String genero,
			String sinopse,
			String capa,
			String elenco,
			String duracao,
			boolean legendas_e_audio,
			String estado_conservacao,
			Status_item_multimidia status
			) {
	
		super(
				titulo,
				autor,
				editora,
				ano,
				genero,
				sinopse,
				capa,
				status
				);
		this.elenco = elenco;
		this.duracao = duracao;
		this.legendas_e_audio = legendas_e_audio;
		this.estado_conservacao = estado_conservacao;
	}
	
	public short numero_disponivel(){
		return 2;
	}
	
	public short numero_total() {
		return 2;
	}
	
	//geters e seters
	public String getElenco() {
	      return this.elenco;
	}
	
	public void setElenco(String elenco) {
	    this.elenco = elenco;
	}
	
	public String getDuracao() {
	      return this.duracao;
	}
	
	public void setDuracao(String duracao) {
	    this.duracao = duracao;
	}
	
	public boolean getLegendas_e_audio() {
	      return this.legendas_e_audio;
	}
	
	public void setLegendas_e_audio(boolean legendas_e_audio) {
	    this.legendas_e_audio = legendas_e_audio;
	}
	
	public String getEstado_conservacao() {
	      return this.estado_conservacao;
	}
	
	public void setEstado_conservacao(String estado_conservacao) {
	    this.estado_conservacao = estado_conservacao;
	}
}
