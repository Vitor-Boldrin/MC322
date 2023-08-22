package pessoa;

import java.util.ArrayList;
import Controle_Livros.Emprestimo;
import Livros.Livro;

public class Estudante {

	// Atributos da classe
	private String ra;
	private String curso;
	private short num_emprestimos;
	private short max_emprestimos;
	private ArrayList<Emprestimo> emprestimos;
	
	// Construtor da Classe
	public Estudante(String ra, String curso) {
		this.ra = ra;
		this.curso = curso;
		this.num_emprestimos = 0;
		this.max_emprestimos = 5; //Máximo de 5 empréstimos (padrão por agora)
		this.emprestimos = new ArrayList<Emprestimo>();
	}
	
	// Métodos
	public void devolve_emprestimo(Emprestimo emprestimo) {
		int pos_emprestimo = encontra_pos_emprestimo(this.getEmprestimos(), emprestimo);
		if (pos_emprestimo == -1) {
			
			System.out.println("O estudante não tem esse livro emprestado.");
			return;
			
		} else {
			
			this.getEmprestimos().remove(pos_emprestimo);  // Remove emprestimo do estudante
			emprestimo.getLivro().setStatus("disponivel"); // Seta livro como disponível
			System.out.println("Livro devolvido");
			
			
		}
	}
	
	private short encontra_pos_emprestimo(ArrayList<Emprestimo> emprestimos, Emprestimo emprestimo) { //Função encontra o emprestimo dado dentro de uma lista de emprestimos
		short pos_emprestimo =  (short)emprestimos.indexOf(emprestimo);
		return pos_emprestimo;
	}

	
	// Gatters e Setters
	public String getRa() {
		return this.ra;
	}
	
	public void setRa(String ra) {
		this.ra = ra;
	}
	
	public String getCurso() {
		return this.curso;
	}
	
	public void setCurso(String curso) {
		this.curso = curso;
	}
	
	public void setNum_emprestimos(short num_emprestimos) {
		this.num_emprestimos = num_emprestimos;
	}
	
	public short getNum_emprestimos() {
		return this.num_emprestimos;
	}
	
	public void setMax_emprestimos(short max_emprestimos) {
		this.max_emprestimos = max_emprestimos;
	}
	
	public short getMax_Emprestimos() {
		return this.max_emprestimos;
	}
	
	public ArrayList<Emprestimo> getEmprestimos() {
		return this.emprestimos;
	}
	
}
