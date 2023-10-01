package biblioteca.models.Excecao;

public class ExcecaoIdJaCadastrado extends Exception {
	public ExcecaoIdJaCadastrado(String errorMessage) {
        super(errorMessage);
}
}