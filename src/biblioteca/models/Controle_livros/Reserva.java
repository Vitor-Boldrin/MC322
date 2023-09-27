package biblioteca.models.Controle_livros;
import java.util.Date;

import biblioteca.models.Item.Item;
import biblioteca.models.Membro.Membro;

public class Reserva {

	private Date data_reserva;
	private Membro membro;
	private Item item;
	
	// Construtor
	public Reserva(Date data_reserva, Membro membro, Item itemMultimidia) {
		this.data_reserva = data_reserva;
		this.membro = membro;
		this.item = itemMultimidia;
	}
	
	
	// Geter e Seters
	public Date getData_reserva() {
	      return this.data_reserva;
	}
	
	public void setData_reserva(Date data_reserva) {
	    this.data_reserva = data_reserva;
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
