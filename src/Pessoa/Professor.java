package Pessoa;

import java.util.Date;

public class Professor extends Pessoa {

	public Professor(
		   String nome, 
		   String id_faculdade, 
		   String endereco, 
		   String contato,
		   Date data_registro) {
			
			super(nome, 
			id_faculdade, 
			endereco, 
			contato,
			data_registro
			);
			this.setLimite_emprestimo((short)7);
			this.setPrazo_emprestimo((short)30);
			this.setMulta_por_atraso((float)0.50);
		
	}

}
