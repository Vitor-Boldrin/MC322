package biblioteca.models.Controle_livros;
import java.util.Date;

import biblioteca.models.ItemMultimidia.ItemMultimidia;
import biblioteca.models.Membro.Membro;

public class Reserva_item_multimidia {

	private Date data_reserva;
	private Membro membro;
	private ItemMultimidia itemMultimidia;
	
	// Construtor
	public Reserva_item_multimidia(Date data_reserva, Membro membro, ItemMultimidia itemMultimidia) {
		this.data_reserva = data_reserva;
		this.membro = membro;
		this.itemMultimidia = itemMultimidia;
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
	
	public ItemMultimidia getItem_multimidia() {
	      return this.itemMultimidia;
	}
	
	public void setPessoa(ItemMultimidia itemMultimidia) {
	    this.itemMultimidia = itemMultimidia;
	}
	
}
