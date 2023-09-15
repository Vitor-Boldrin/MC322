package biblioteca.models.BibliotecaStatic;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

import biblioteca.models.Membro.Membro;

public class BibliotecaStatic {

	static private LinkedList<Membro> membros = new LinkedList<>();
	static private Set<String> membros_id = new HashSet<>();
	
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
}
