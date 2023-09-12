package Controle_livros;
import java.util.Date;

import Pessoa.*;
import Item_multimidia.*;

public class Emprestimo_item_multimidia {

	private Date data_emprestimo;
	private Date data_final;
	private Pessoa pessoa;
	private Item_multimidia item_multimidia;
	
	// Construtor
	public Emprestimo_item_multimidia(Date data_emprestimo,Date data_final,
			Pessoa pessoa,Item_multimidia item_multimidia) {
		this.data_emprestimo = data_emprestimo;
		this.data_final = data_final;
		this.pessoa = pessoa;
		this.item_multimidia = item_multimidia;
	}
	
	
	// Geter e Seters
	public Date getData_emprestimo() {
	      return this.data_emprestimo;
	}
	
	public void setData_emprestimo(Date data_emprestimo) {
	    this.data_emprestimo = data_emprestimo;
	}
	
	public Date getData_final() {
	      return this.data_final;
	}
	
	public void setData_final(Date data_final) {
	    this.data_final = data_final;
	}
	
	public Pessoa getPessoa() {
	      return this.pessoa;
	}
	
	public void setPessoa(Pessoa pessoa) {
	    this.pessoa = pessoa;
	}
	
	public Item_multimidia getItem_multimidia() {
	      return this.item_multimidia;
	}
	
	public void setPessoa(Item_multimidia item_multimidia) {
	    this.item_multimidia = item_multimidia;
	}
	
}
