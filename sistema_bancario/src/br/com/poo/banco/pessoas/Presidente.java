package br.com.poo.banco.pessoas;

public class Presidente extends Funcionarios{
	//Atributos
	
	private String email;
	private int numUnidades;
	
	
	//Construtor
	public Presidente() {
		super();
	}
	
	public Presidente(String nome, String cpf, String email, double salario, int numUnidades) {
		super(nome, cpf, salario);
		this.email = email;
		this.numUnidades = numUnidades;
	}
	
	//getters
	public int getnumUnidades() {
		return numUnidades;
	}
	public String getnEmail() {
		return email;
	}
	
	//setters
	public void setEmail (String email) {
		this.email = email;
	}

}
