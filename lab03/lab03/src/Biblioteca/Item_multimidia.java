package Biblioteca;

public class Item_multimidia {

	// Atributos
	private String id;
	private String autor;
	private String titulo;
	private String edicao;
	private short ano;
	private String tipo; //livro, revista, dvd, etc...
	private byte status;/*
						1 = disponivel
						2 = disponivel porém reservado
						3 = emprestado
						4 = emprestado e reservado
						5 = indisponível
	 					*/
	
	// Construtor
	public Item_multimidia(String id, 
			String autor, 
			String titulo, 
			String edicao,
			short ano, 
			String tipo, 
			byte status) {
		this.id = id;
		this.autor = autor;
		this.titulo = titulo;
		this.edicao = edicao;
		this.ano = ano;
		this.tipo = tipo;
		this.status = status;
	}
	
	protected String getName_status_item() {
		if(this.getStatus() == 1) {
			return "disponivel";
		} else if (this.getStatus() == 2) {
			return "disponivel porém reservado";
		} else if (this.getStatus() == 3) {
			return "emprestado";
		} else if (this.getStatus() == 4) {
			return "emprestado e reservado";
		} else if (this.getStatus() == 5) {
			return "indisponível";
		} else {
			return "-";
		}
		
	}
	
	//geters e seters
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
	
	public String getEdicao() {
		return this.edicao;
	}
	
	public void setEdicao(String edicao) {
		this.edicao = edicao;
	}
	
	public short getAno() {
		return this.ano;
	}
	
	public void setAno(short ano) {
		this.ano = ano;
	}
	
	public String getTipo() {
		return this.tipo;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public byte getStatus() {
		return this.status;
	}
	
	public void setStatus(byte status) {
		this.status = status;
	}
}
