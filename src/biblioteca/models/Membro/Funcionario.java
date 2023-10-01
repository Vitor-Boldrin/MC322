package biblioteca.models.Membro;

import java.util.Date;

public class Funcionario extends Membro {
	
	private Nivel_acesso nivel_acesso;
	private String senha;
	private String usuario;

	public Funcionario(
		   String nome, 
		   String id_faculdade, 
		   String endereco, 
		   String contato,
		   Date data_registro,
		   Nivel_acesso nivel_acesso,
		   boolean bloqueado,
		   String usuario,
		   String senha) {
			
			super(nome, 
			id_faculdade, 
			endereco, 
			contato,
			data_registro,
			bloqueado
			);
			this.setLimite_emprestimo((short)4);
			this.setPrazo_emprestimo((short)20);
			this.setMulta_por_atraso((float)0.75);
			this.nivel_acesso = nivel_acesso;
			this.usuario = usuario;
			this.senha = senha;
		
	}
	
	//métodos
	public boolean login(String usuario, String senha) {
		if(this.usuario.equals(usuario) && this.senha.equals(senha)) {
			return true;
		} else {
			return false;
		}
	}
	
	//geters e seters
	public Nivel_acesso getNivel_acesso() {
	      return this.nivel_acesso;
	 }
	
	 public void setNivel_acesso(Nivel_acesso nivel_acesso) {
	    this.nivel_acesso = nivel_acesso;
	 }

}
