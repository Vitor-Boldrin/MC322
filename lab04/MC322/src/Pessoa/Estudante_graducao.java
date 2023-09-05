package Pessoa;

import java.util.Date;

public class Estudante_graducao extends Pessoa {

	public Estudante_graducao(
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
			this.setLimite_emprestimo((short)3);
			this.setPrazo_emprestimo((short)15);
			this.setMulta_por_atraso((float)1);
		
	}

}
