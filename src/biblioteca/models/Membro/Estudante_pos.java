package biblioteca.models.Membro;
import java.util.Date;

public class Estudante_pos extends Membro {

	public Estudante_pos(
		   String nome, 
		   String id_faculdade, 
		   String endereco, 
		   String contato,
		   Date data_registro,
		   boolean bloqueado) {
			
			super(nome, 
			id_faculdade, 
			endereco, 
			contato,
			data_registro,
			bloqueado
			);
			this.setLimite_emprestimo((short)5);
			this.setPrazo_emprestimo((short)20);
			this.setMulta_por_atraso((float)1);
		
	}

}
