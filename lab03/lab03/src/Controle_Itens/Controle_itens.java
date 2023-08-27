package Controle_Itens;

import Biblioteca.Item_multimidia;
import Pessoa.Membro;

abstract class Controle_itens {

	// Atributos
	private Item_multimidia item_multimidia;
	private Membro membro;
	
	// Construtor
	public Controle_itens(Item_multimidia item_multimidia, Membro membro) {
		this.item_multimidia = item_multimidia;
		this.membro = membro;
	}
	
	//Sets e gets
	public Membro getMembro() {
		return this.membro;
	}
	
	public void setMembro(Membro membro) {
		this.membro = membro;
	}
	
	public Item_multimidia getItem_multimidia() {
		return this.item_multimidia;
	}
	
	public void seItem_multimidia(Item_multimidia item_multimidia) {
		this.item_multimidia = item_multimidia;
	}
	
}
