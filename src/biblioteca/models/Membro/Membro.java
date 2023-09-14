package biblioteca.models.Membro;
import java.util.Date;

public abstract class Membro {
   private static int id;
   private String nome;
   private String id_faculdade;
   private String endereco;
   private String contato;
   private Date data_registro;
   private short limite_emprestimo;
   private short prazo_emprestimo;
   private float multa_por_atraso;

   public Membro(String nome, 
		   String id_faculdade, 
		   String endereco, 
		   String contato,
		   Date data_registro
		   ) {
      this.nome = nome;
      this.id_faculdade = id_faculdade;
      this.endereco = endereco;
      this.contato = contato;
      this.data_registro = data_registro;
   }
   
   public String getNome() {
	      return this.nome;
   }

   public void setNome(String nome) {
      this.nome = nome;
   }
   
   public String getId_faculdade() {
	      return this.id_faculdade;
   }

   public void setId_faculdade(String id_faculdade) {
	   this.id_faculdade = id_faculdade;
   }
   
   public String getContato() {
	      return this.contato;
	}
	
	public void setContato(String contato) {
		   this.contato = contato;
	}
	
	public String getEndereco() {
	      return this.endereco;
	}
	
	public void setEndereco(String endereco) {
		   this.endereco = endereco;
	}
	
	public Date getData_registro() {
	      return this.data_registro;
	}
	
	public void setData_registro(Date data_registro) {
		   this.data_registro = data_registro;
	}
	
	public short getLimite_emprestimo() {
	      return this.limite_emprestimo;
	}
	
	public void setLimite_emprestimo(short limite_emprestimo) {
		   this.limite_emprestimo = limite_emprestimo;
	}
	
	public short getPrazo_emprestimo() {
	      return this.prazo_emprestimo;
	}
	
	public void setPrazo_emprestimo(short prazo_emprestimo) {
		   this.prazo_emprestimo = prazo_emprestimo;
	}
	
	public float getMulta_por_atraso() {
	      return this.multa_por_atraso;
	}
	
	public void setMulta_por_atraso(float multa_por_atraso) {
		   this.multa_por_atraso = multa_por_atraso;
	}

}
