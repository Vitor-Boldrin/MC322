package biblioteca.models.Controle_livros;
import java.util.Date;

import biblioteca.models.Item.Item;
import biblioteca.models.Membro.Membro;

public class Emprestimo {

	private Date data_emprestimo;
	private Date data_final;
	private Membro membro;
	private Item item;
	
	// Construtor
	public Emprestimo(Date data_emprestimo,Date data_final,
			Membro membro,Item itemMultimidia) {
		this.data_emprestimo = data_emprestimo;
		this.data_final = data_final;
		this.membro = membro;
		this.item = itemMultimidia;
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
	
	public Membro getPessoa() {
	      return this.membro;
	}
	
	public void setPessoa(Membro membro) {
	    this.membro = membro;
	}
	
	public Item getItem() {
	      return this.item;
	}
	
	public void setItem(Item item) {
	    this.item = item;
	}
	
}
