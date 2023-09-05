package br.com.poo.banco.pessoas;

public class Presidente {
	//Atributos
	private String nome;
	private String cpf;
	private String email;
	private double salario;
	private int numUnidades;
	
	
	//Construtor
	public Presidente() {
		
	}
	
	public Presidente(String nome, String cpf, String email, double salario, int numUnidades) {
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.salario = salario;
		this.numUnidades = numUnidades;
	}
	
	//getters
	public String getNome() {
		return nome;
	}
	
	//setters
	public void setEmail (String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Presidente [nome=" + nome + ", cpf=" + cpf + ", email=" + email + ", salario=" + salario
				+ ", numUnidades=" + numUnidades + "]";
	}
}
