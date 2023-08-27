package Pessoa;

import java.util.Iterator;

import Biblioteca.Item_multimidia;
import Controle_Itens.Reserva;
import Controle_Itens.Emprestimo;

public class Funcionario extends Pessoa {
	
	//Atributos
	private String matricula;
	private String nivel;
	private float salario;
	
	//Construtor
	public Funcionario(
			String nome, 
			String celular, 
			String email, 
			String cpf,
			String matricula,
			String nivel,
			float salario
			) {
	super(nome,celular,email,cpf);
	this.matricula = matricula;
	this.nivel = nivel;
	this.salario = salario;
	}

	//metodos
	public void empresta_item_multimidia(Emprestimo emprestimo) {
		if ( pode_emprestar(emprestimo.getItem_multimidia(), emprestimo.getMembro()) ) { // Testa se o livro pode ser emprestado
			
			if (emprestimo.getMembro().getEmprestimos().size()
					< emprestimo.getMembro().getMax_emprestimos()) { // Checa se o estudante pode emprestar livros
				
				emprestimo.getMembro().getEmprestimos().add(emprestimo); // Adiciona o emprestimo
				
				short num_emprestimo = emprestimo.getMembro().getNum_emprestimos(); //
				num_emprestimo ++; 												    // Aumenta contador de números emprestados
				emprestimo.getMembro().setNum_emprestimos(num_emprestimo);			//	
				
				
				if(emprestimo.getItem_multimidia().getStatus() == 2) {
					// Se ele estava reservado, então devemos desfazer a reserva do membro
					desfaz_reserva(emprestimo.getItem_multimidia(), emprestimo.getMembro());
				}
				
				emprestimo.getItem_multimidia().setStatus((byte)3); //Muda status do livro
				
				System.out.println("Livro emprestado.");
				
				
			} else {
				System.out.println("O estudante não pode emprestar mais livros.");
			}
			
		} else {
			System.out.println("Livro não pode ser emprestado");
		}
	}
	

	private void desfaz_reserva(Item_multimidia item, Membro membro) {
		//for (final Reserva reserva : membro.getReservas()) {
		//	if(reserva.getItem_multimidia() == item) { //busca a reserva do item em questão
		//		System.out.println("Entrei para tirar reserva");
		//		membro.getReservas().remove(reserva);
		//	}
		//}
		Iterator<Reserva> itr = membro.getReservas().iterator();
		while (itr.hasNext()) {
			Reserva reserva = itr.next();
			if (reserva.getItem_multimidia() == item) {
				itr.remove();
			}
		}
		
	}
	
	private boolean pode_emprestar(Item_multimidia item, Membro membro) {
		//List<Integer> status_permitidos = Arrays.asList(1,3);
		
		if((int)item.getStatus() == 2) { // Checa se o item está reservado
			// Nesse caso, checar se a reserva é do membro em questão
			// Olhar todas as reservas do membro e checar se ele quem reservou
			int aux = 0;
			for (final Reserva reserva : membro.getReservas()) {
				if(reserva.getItem_multimidia() == item) { // Se o membro tem esse livro reservado ele pode emprestar
					aux++;
				}
			}
			if (aux > 0) {
				return true;
			} else {
				return false;
			}
			
		} else if ((int)item.getStatus() == 1) { //Disponível 
			return true;
			
		} else {
			return false; //Não está disponível
		}
	}
	
	//Geters e seters
		public String getMatricula() {
			return this.matricula;
		}
		
		public void setRa(String matricula) {
			this.matricula = matricula;
		}
		
		public float getSalario() {
			return this.salario;
		}
		
		public void setCurso(float salario) {
			this.salario = salario;
		}
		
		public String getNivel() {
			return this.nivel;
		}
		
		public void setNivel(String nivel) {
			this.nivel = nivel;
		}
}
