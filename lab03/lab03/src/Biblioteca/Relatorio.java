package Biblioteca;

import Controle_Itens.Reserva;
import Controle_Itens.Emprestimo;
import Pessoa.Membro;

public class Relatorio {

	//Atributos
	private String apelido;
	private Biblioteca biblioteca;
	
	//Construtor
	public Relatorio(String apelido, Biblioteca biblioteca) {
		this.apelido = apelido;
		this.biblioteca = biblioteca;
	}
	
	//metodos
	public void relatorio_membros() {
		for (final Membro membro_ : this.biblioteca.getMembro()) {
				System.out.println("	O membro " + membro_.getNome() + " Possui as seguintes reservas:");
				for (final Reserva reserva_ : membro_.getReservas()) {
					System.out.println( "	" + reserva_.getItem_multimidia().getTitulo() );
				}
				System.out.println("	E possui os seguintes livros emprestados:");
				for (final Emprestimo emprestimo_ : membro_.getEmprestimos()) {
					System.out.println( "	" + emprestimo_.getItem_multimidia().getTitulo() );
				}
			}
	}
	
	public void relatorio_itens() {
		for (final Item_multimidia item : this.biblioteca.getItem_multimidia()) {
			System.out.println("    " + item.getTitulo());
			System.out.println("    status: " + item.getName_status_item());
		}
	}
	
	//geters and seters
	public String getApelido() {
		return this.apelido;
	}
	
	public void setApelido(String apelido) {
		this.apelido = apelido;
	}
	
	public Biblioteca getBiblioteca() {
		return this.biblioteca;
	}
	
	public void setBiblioteca(Biblioteca biblioteca) {
		this.biblioteca = biblioteca;
	}
}
