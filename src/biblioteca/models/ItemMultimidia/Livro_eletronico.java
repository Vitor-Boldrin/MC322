package biblioteca.models.ItemMultimidia;
import java.util.Date;

public class Livro_eletronico extends ItemMultimidia {

	private String formato;
	private String fomato_arquivo;
	private String url_acesso;
	private String requisitos_leitura;
	private Date data_disponibilidade;
	
	public Livro_eletronico(
			int id,
			String titulo,
			String autor,
			String editora,
			String ano,
			String genero,
			String sinopse,
			String capa,
			Status_item_multimidia status,
			String formato,
			String fomato_arquivo,
			String url_acesso,
			String requisitos_leitura,
			Date data_disponibilidade
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
		this.formato = formato;
		this.fomato_arquivo = fomato_arquivo;
		this.url_acesso = url_acesso;
		this.requisitos_leitura = requisitos_leitura;
		this.data_disponibilidade = data_disponibilidade;
		
	}
	
	public short numero_disponivel(){
		return 2;
	}
	
	public short numero_total() {
		return 2;
	}
	
	//geters e seters
	public String getFormato() {
	      return this.formato;
	}
	
	public void setFormato(String formato) {
	    this.formato = formato;
	}
	
	public String getFomato_arquivo() {
	      return this.fomato_arquivo;
	}
	
	public void setFomato_arquivo(String fomato_arquivo) {
	    this.fomato_arquivo = fomato_arquivo;
	}
	
	public String getUrl_acesso() {
	      return this.url_acesso;
	}
	
	public void setUrl_acesso(String url_acesso) {
	    this.url_acesso = url_acesso;
	}
	
	public String getRequisitos_leitura() {
	      return this.requisitos_leitura;
	}
	
	public void setRequisitos_leitura(String requisitos_leitura) {
	    this.requisitos_leitura = requisitos_leitura;
	}
	
	public Date getData_disponibilidade() {
	      return this.data_disponibilidade;
	}
	
	public void setData_disponibilidade(Date data_disponibilidade) {
	    this.data_disponibilidade = data_disponibilidade;
	}
}
