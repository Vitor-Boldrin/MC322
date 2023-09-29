package biblioteca.models.ItemMultimidia;

public class DVD_de_video extends ItemMultimidia {

	private String elenco;
	private int duracao;
	private boolean legendas_e_audio;
	private EstadoItemMultimidia estado_conservacao;
	
	public DVD_de_video(
			int id,
			String titulo,
			String autor,
			String editora,
			String ano,
			String genero,
			String sinopse,
			String capa,
			String elenco,
			int duracao,
			boolean legendas_e_audio,
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
	
	public int getDuracao() {
	      return this.duracao;
	}
	
	public void setDuracao(int duracao) {
	    this.duracao = duracao;
	}
	
	public boolean getLegendas_e_audio() {
	      return this.legendas_e_audio;
	}
	
	public void setLegendas_e_audio(boolean legendas_e_audio) {
	    this.legendas_e_audio = legendas_e_audio;
	}
	
	public EstadoItemMultimidia getEstado_conservacao() {
	      return this.estado_conservacao;
	}
	
	public void setEstado_conservacao(EstadoItemMultimidia estado_conservacao) {
	    this.estado_conservacao = estado_conservacao;
	}
}
