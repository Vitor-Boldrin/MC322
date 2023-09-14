package biblioteca.models.BibliotecaStatic;
import java.util.LinkedList;
import biblioteca.models.Membro.Membro;

public class BibliotecaStatic {

	static private LinkedList<Membro> membros = new LinkedList<>();
	
	static public LinkedList<Membro> getMembros() {
		return membros;
	}
	
	static public void setMembros(LinkedList<Membro> membros_novo) {
		membros = membros_novo;
	}
}
