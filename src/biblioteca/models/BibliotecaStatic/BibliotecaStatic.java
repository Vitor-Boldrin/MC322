package biblioteca.models.BibliotecaStatic;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

import biblioteca.models.Controle_livros.Emprestimo;
import biblioteca.models.Controle_livros.Reserva;
import biblioteca.models.ItemMultimidia.ItemMultimidia;
import biblioteca.models.Membro.Membro;

public class BibliotecaStatic {
	
	//ATRIBUTOS
	//Administração Membros
	static private LinkedList<Membro> membros = new LinkedList<>();
	static private Set<String> membros_id = new HashSet<>();
	
	//Administração Itens
	static private LinkedList<ItemMultimidia> itens = new LinkedList<>();
	static private Set<Integer> itens_id = new HashSet<>();
	
	//Controle itens
	static private Set<Emprestimo> emprestimos = new HashSet<>();
	static private LinkedList<Reserva> reservas = new LinkedList<>();
	
	//Categorias
	static private Set<String> categorias = new HashSet<>();
	
	static public LinkedList<Membro> getMembros() {
		return membros;
	}
	
	static public void setMembros(LinkedList<Membro> membros_novo) {
		membros = membros_novo;
	}
	
	static public Set<String> getMembros_id() {
		return membros_id;
	}
	
	static public void setMembros_id(Set<String> membros_id_novo) {
		membros_id = membros_id_novo;
	}
	
	static public LinkedList<ItemMultimidia> getItens() {
		return itens;
	}
	
	static public void setItens(LinkedList<ItemMultimidia> itens_novo) {
		itens = itens_novo;
	}
	
	static public Set<Integer> getItens_id() {
		return itens_id;
	}
	
	static public void setItens_id(Set<Integer> itens_id_novo) {
		itens_id = itens_id_novo;
	}
	
	static public LinkedList<Reserva> getReservas() {
		return reservas;
	}
	
	static public void setReserva(LinkedList<Reserva> reservas_novo) {
		reservas = reservas_novo;
	}
	
	static public Set<Emprestimo> getEmprestimos() {
		return emprestimos;
	}
	
	static public void setEmprestimos(Set<Emprestimo> emprestimos_novo) {
		emprestimos = emprestimos_novo;
	}
	
	static public Set<String> getCategorias() {
		return categorias;
	}
	
	static public void setCategorias(Set<String> categorias_novo) {
		categorias = categorias_novo;
	}
}
