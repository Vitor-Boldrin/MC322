package Controle_livros;
import java.util.Date;

import Pessoa.*;
import Item_multimidia.*;

public class Reserva_item_multimidia {

	private Date data_reserva;
	private Pessoa pessoa;
	private Item_multimidia item_multimidia;
	
	// Construtor
	public Reserva_item_multimidia(Date data_reserva, Pessoa pessoa, Item_multimidia item_multimidia) {
		this.data_reserva = data_reserva;
		this.pessoa = pessoa;
		this.item_multimidia = item_multimidia;
	}
	
	
	// Geter e Seters
	public Date getData_reserva() {
	      return this.data_reserva;
	}
	
	public void setData_reserva(Date data_reserva) {
	    this.data_reserva = data_reserva;
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
