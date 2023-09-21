package biblioteca.models.ItemMultimidia;

import java.util.LinkedList;

public abstract class ItemMultimidia {

	private int id;
	private String titulo;
	private String autor;
	private String editora;
	private String ano;
	private String genero;
	private String sinopse;
	private String capa;
	private StatusItem status;
	private LinkedList<Comentario> comentarios = new LinkedList<>();
	
	public ItemMultimidia(
			int id,
			String titulo,
			String autor,
			String editora,
			String ano,
			String genero,
			String sinopse,
			String capa,
			StatusItem status
			) {
		this.id = id;
		this.titulo = titulo;
		this.autor = autor;
		this.editora = editora;
		this.ano = ano;
		this.genero = genero;
		this.sinopse = sinopse;
		this.capa = capa;
		this.status = status;
	}
	
	public abstract short numero_disponivel();
	
	public abstract short numero_total();
	
	public int getId() {
	      return this.id;
	}
	
	public void setId(int id) {
	    this.id = id;
	}
	
	public String getTitulo() {
	      return this.titulo;
	}
	
	public void setTitulo(String titulo) {
	    this.titulo = titulo;
	}
	
	public String getAutor() {
	      return this.autor;
	}
	
	public void setAutor(String autor) {
	    this.autor = autor;
	}
	
	public String getEditora() {
	      return this.editora;
	}
	
	public void setEditora(String editora) {
	    this.editora = editora;
	}
	
	public String getAno() {
	      return this.ano;
	}
	
	public void setAno(String ano) {
	    this.ano = ano;
	}
	
	public String getGenero() {
	      return this.genero;
	}
	
	public void setGenero(String genero) {
	    this.genero = genero;
	}
	
	public String getSinopse() {
	      return this.sinopse;
	}
	
	public void setSinopse(String sinopse) {
	    this.sinopse = sinopse;
	}
	
	public String getCapa() {
	      return this.capa;
	}
	
	public void setCapa(String capa) {
	    this.capa = capa;
	}
	
	public StatusItem getStatus() {
	      return this.status;
	}
	
	public void setStatus(StatusItem status) {
	    this.status = status;
	}
	
	public LinkedList<Comentario> getComentarios() {
	      return this.comentarios;
	}
	
	public void setComentarios(LinkedList<Comentario> comentarios) {
	    this.comentarios = comentarios;
	}
	
}
