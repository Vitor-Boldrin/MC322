package biblioteca.models.BibliotecaStatic;

import java.util.HashSet;
import java.util.Set;

public class ListaReservas<T> {
	private Set<T> itensReservados;
	
	//Construtor
	public ListaReservas() {
		this.itensReservados = new HashSet<>();
	}
	
	//Geters e Seters
	public Set<T> getItensReservados() {
	      return this.itensReservados;
	}
	
	public void setitensReservados(Set<T> itensReservados) {
	    this.itensReservados = itensReservados;
	}
	
	//Métodos
	public <T> void imprimirReservas(Set<T> itens) {
		for (T item : itens) {
			System.out.println(item.toString());
		}
	}

}
