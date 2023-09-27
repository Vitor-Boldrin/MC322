package biblioteca.models.ItemMultimidia;

public class Livro_fisico extends ItemMultimidia {

	private String isbn;
	private int edicao;
	private String localizacao;
	private EstadoItemMultimidia estado_conservacao;
	
	public Livro_fisico(
			int id,
			String titulo,
			String autor,
			String editora,
			String ano,
			String genero,
			String sinopse,
			String capa,
			StatusItem status,
			String isbn,
			int edicao,
			String localizacao,
			EstadoItemMultimidia estado_conservacao
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
		this.isbn = isbn;
		this.edicao = edicao;
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
	public String getIsbn() {
	      return this.isbn;
	}
	
	public void setIsbn(String isbn) {
	    this.isbn = isbn;
	}
	
	public int getEdicao() {
	      return this.edicao;
	}
	
	public void setEdicao(int edicao) {
	    this.edicao = edicao;
	}
	
	public String getLocalizacao() {
	      return this.localizacao;
	}
	
	public void setLocalizacao(String localizacao) {
	    this.localizacao = localizacao;
	}
	
	public EstadoItemMultimidia getEstado_conservacao() {
	      return this.estado_conservacao;
	}
	
	public void setEstado_conservacao(EstadoItemMultimidia estado_conservacao) {
	    this.estado_conservacao = estado_conservacao;
	}
	
}
