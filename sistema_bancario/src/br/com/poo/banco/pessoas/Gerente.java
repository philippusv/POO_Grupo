package br.com.poo.banco.pessoas;

public class Gerente {
	
	//atributos
	private String nome;
	private String cpf;
	private double salario;
	private String senha;
	private int numFuncionarios;

	//construtores
	public Gerente() {
	
		}
	
	public Gerente(String nome, String cpf, double salario, String senha, int numFuncionarios) {
		this.nome = nome;
		this.cpf = cpf;
		this.salario = salario;
		this.senha = senha;
		this.numFuncionarios = numFuncionarios;
	}
	
	//getters	
	
	public String getNome() {
		return nome;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public double getSalario() {
		return salario;
	}
	
	public int getNumFuncionarios() {
		return numFuncionarios;
	}
	
	//setters
	
	public String setSenha() {
		return senha;
	}
	
	
}
