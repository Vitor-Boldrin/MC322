package Pessoa;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import Biblioteca.Item_multimidia;
import Controle_Itens.Emprestimo;
import Controle_Itens.Reserva;

public class Membro extends Pessoa {

	//Atributos
	private String ra;
	private String curso;
	private String nivel; // Graduação, doutorado, etc...
	private short max_emprestimos;
	private short num_emprestimos;
	private ArrayList<Emprestimo> emprestimos;
	private short max_reservas;
	private short num_reservas;
	private ArrayList<Reserva> reservas;
	
	//Construtor
	public Membro(
			String nome, 
			String celular, 
			String email, 
			String cpf,
			String ra,
			String curso,
			String nivel
			// Emprestimos e Reservas não são inicializados
			) {
	super(nome,celular,email,cpf);
	this.ra = ra;
	this.curso = curso;
	this.nivel = nivel;
	this.max_reservas = 5;
	this.max_emprestimos = 5;
	this.num_emprestimos = 0;
	this.emprestimos = new ArrayList<Emprestimo>();
	this.num_reservas = 0;
	this.reservas = new ArrayList<Reserva>();
	}
	
	//Métodos
	public void reserva_item_multimidia(Reserva reserva) {
		
		if ( pode_reservar(reserva.getItem_multimidia(), reserva.getMembro()) ) { // checa se pode reservar
			
			reserva.getMembro().getReservas().add(reserva); // Adiciona reserva
			
			short num_reserva = reserva.getMembro().getNum_reservas(); //
			num_reserva ++; 										   // Aumenta contador de números emprestados
			reserva.getMembro().setNum_emprestimos(num_reserva);	   //	
			
			//Muda status do livro
			if(reserva.getItem_multimidia().getStatus() == 1) { //disponível para reservado e disponível
				reserva.getItem_multimidia().setStatus((byte)2);
			} else {
				reserva.getItem_multimidia().setStatus((byte)4); //emprestado para emprestado e reservado 
			}
			
			System.out.println("Item reservado");
			
		} else {
			System.out.println("Livro não pode ser emprestado");
		}
	}
	
	private boolean pode_reservar(Item_multimidia item, Membro membro) {
		// O item só pode ser reservado se ele ainda não estiver reservado, além dele não estiver indisponível
		List<Integer> status_permitidos = Arrays.asList(1,3);
		
		if( status_permitidos.contains((int)item.getStatus()) ) {
			return true;
		} else {
			return false;
		}
	}
	
	public void devolve_item_multimidia(Item_multimidia item) {
		//item só pode ser devolvido se ele está emprestado pelo estudante		
		if(pode_devolver_item_multimidia(item, this)) {
			
			// Retira emprestimo de estudante
			Iterator<Emprestimo> itr = this.getEmprestimos().iterator();
			while (itr.hasNext()) {
				Emprestimo emprestimo = itr.next();
				if (emprestimo.getItem_multimidia() == item) {
					itr.remove();
				}
			}
			
			// seta status
			if(item.getStatus() == 3) { // emprestado vai para disponível
				item.setStatus((byte)1);
			} else if(item.getStatus() == 4) { // emprestado e reservado vai para disponível e reservado
				item.setStatus((byte)2);
			} else {
				System.out.println("Livro não pode ser devolvido por algum motivo");
				return;
			}
			
			System.out.println("Item devolvido");
			
			
		} else {
			System.out.println("Item não pertence ao estudante para ser devolvido.");
		}
	}
	
	private boolean pode_devolver_item_multimidia(Item_multimidia item, Membro membro) {
		// A ideia é checar se o membro possui o item para poder devolvelo
		
		int aux = 0;
		for (final Emprestimo emprestimo : membro.getEmprestimos()) {
			if(emprestimo.getItem_multimidia() == item) { // Se o membro tem esse item emprestado ele pode devolver
				aux++;
			}
		}
		if (aux > 0) {
			return true;
		} else {
			return false;
		}
		
	}
	
	public void desfaz_reserva(Item_multimidia item) {
		int aux = 0;
		//for (final Reserva reserva : membro.getReservas()) {
		//	if(reserva.getItem_multimidia() == item) { //busca a reserva do item em questão
		//		membro.getReservas().remove(reserva);
		//		aux ++;
		//	}
		//}
		Iterator<Reserva> itr = this.getReservas().iterator();
		while (itr.hasNext()) {
			Reserva reserva = itr.next();
			if (reserva.getItem_multimidia() == item) {
				itr.remove();
				aux ++;
			}
		}
		
		if(aux>0) {
			System.out.println("Reserva desfeita");
		} else {
			System.out.println("Não havia tal reserva para se desfazer");
		}
	}
	
	//Geters e seters
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
	
	public String getNivel() {
		return this.nivel;
	}
	
	public void setNivel(String nivel) {
		this.nivel = nivel;
	}
	
	public short getMax_emprestimos() {
		return this.max_emprestimos;
	}
	
	public void setMax_emprestimos(short max_emprestimos) {
		this.max_emprestimos = max_emprestimos;
	}
	
	public short getNum_emprestimos() {
		return this.num_emprestimos;
	}
	
	public void setNum_emprestimos(short num_emprestimos) {
		this.num_emprestimos = num_emprestimos;
	}
	
	public ArrayList<Emprestimo> getEmprestimos() {
		return this.emprestimos;
	}
	
	public short getMax_reservas() {
		return this.max_reservas;
	}
	
	public void setMax_reservas(short max_reservas) {
		this.max_reservas = max_reservas;
	}
	
	public short getNum_reservas() {
		return this.num_reservas;
	}
	
	public void setNum_reservas(short num_reservas) {
		this.num_reservas = num_reservas;
	}
	
	public ArrayList<Reserva> getReservas() {
		return this.reservas;
	}
}
