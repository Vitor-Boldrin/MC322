package biblioteca.models.BibliotecaStatic;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

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
}
