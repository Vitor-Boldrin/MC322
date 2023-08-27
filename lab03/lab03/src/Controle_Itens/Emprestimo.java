package Controle_Itens;

import Biblioteca.Item_multimidia;
import Pessoa.Membro;

public class Emprestimo extends Controle_itens {

	//Construtor
	public Emprestimo(
			Item_multimidia item_multimidia, 
			Membro membro
			) {
	super(item_multimidia,membro);
	}
}
