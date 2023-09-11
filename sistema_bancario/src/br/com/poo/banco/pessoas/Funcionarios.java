package br.com.poo.banco.pessoas;

public class Funcionarios {
	
	// atributos
	private String nome;
	private String cpf;
	private double salario;
	protected String senha;
	protected String cargo;
	
	// construtores
	public Funcionarios() {
		
	}
	
	public Funcionarios(String nome, String cpf, double salario) {
		this.nome = nome;
		this.cpf = cpf;
		this.salario = salario;
	}
	
	
	// getters
	public String getNome() {
		return nome;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public double getSalario() {
		return salario;
	}
		
	public String getSenha() {
		return senha;
	}

	public String getCargo() {
		return cargo;
	}

	//setters
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public void setSalario(double salario) {
		this.salario = salario;
	}
	
	
}
