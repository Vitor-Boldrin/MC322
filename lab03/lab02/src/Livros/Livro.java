package Livros;

public class Livro {

	// Atributos da classe
	private String id;
	private String autor;
	private String titulo;
	private short edicao;
	private short ano;
	private String editora;
	private String status;
	
	// Construtor da Classe
	public Livro(String id,
				 String autor,
				 String titulo,
				 short edicao,
				 short ano,
				 String editora
				 ) {
		this.id = id;
		this.autor = autor;
		this.titulo = titulo;
		this.edicao = edicao;
		this.ano = ano;
		this.editora = editora;
		this.status = "disponivel"; // Todo livro começa disponíveç
	}
	
	// Metodos
	public boolean pode_emprestar() {
		if (this.status == "disponivel") {
			return true;
		} else {
			return false;
		}
	}
	
	//Gatters e Setters
	public String getId() {
		return this.id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getAutor() {
		return this.autor;
	}
	
	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getTitulo() {
		return this.titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public short getEdicao() {
		return this.edicao;
	}
	
	public void setEdicao(short edicao) {
		this.edicao = edicao;
	}
	
	public short getAno() {
		return this.ano;
	}
	
	public void setAno(short ano) {
		this.ano = ano;
	}
	
	public String getEditora() {
		return this.editora;
	}
	
	public void setEditora(String editora) {
		this.editora = editora;
	}
	
	public String getStatus() {
		return this.status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
}
