package biblioteca.views;

import java.util.List;

import biblioteca.controllers.MembroController;
import biblioteca.models.Membro.Membro;

public class MembroViewImpl implements MembroView {
    private MembroController membroController;

    public MembroViewImpl(MembroController controller) {
        membroController = controller;
    }

    @Override
    public void mostrarListaMembros(List<Membro> membros) {
    	for( Membro membro : membros) {
    		System.out.println("Nome membro: " + membro.getNome() + ", ID: " + membro.getId_faculdade());
    		}
    }

    @Override
    public void mostrarDetalhesMembro(Membro membro) {
        // Implementação da exibição dos detalhes de um membro
    }
}