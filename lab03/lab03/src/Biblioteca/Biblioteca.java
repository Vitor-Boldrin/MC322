package Biblioteca;

import java.util.ArrayList;

import Pessoa.Membro;
import Pessoa.Funcionario;

public class Biblioteca {

	//Atributos
	private String nome;
	private ArrayList<Item_multimidia> item_multimidia;
	private ArrayList<Membro> membro;
	private ArrayList<Funcionario> funcionario;
	
	//Construtor
	public Biblioteca(
			String nome
			) {
	this.nome = nome;
	this.item_multimidia = new ArrayList<Item_multimidia>();
	this.membro = new ArrayList<Membro>();
	this.funcionario = new ArrayList<Funcionario>();
	}
	
	//geters and seters
	
	//Geters e seters
	public String getNome() {
		return this.nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	
	public ArrayList<Item_multimidia> getItem_multimidia() {
		return this.item_multimidia;
	}
	
	public void setItem_multimidia(ArrayList<Item_multimidia> item_multimidia) {
		this.item_multimidia = item_multimidia;
	}
	
	public ArrayList<Membro> getMembro() {
		return this.membro;
	}
	
	public void setMembro(ArrayList<Membro> membro) {
		this.membro = membro;
	}
	
	public ArrayList<Funcionario> getFuncionario() {
		return this.funcionario;
	}
	
	public void setFuncionario(ArrayList<Funcionario> funcionario) {
		this.funcionario = funcionario;
	}
}
