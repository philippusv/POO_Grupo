package br.com.poo.banco.pessoas;

public class Gerente {
	
	//atributos
	String nome;
	String cpf;
	double salario;
	String senha;
	int numFuncionarios;

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
	
	public int getNumFuncionarios() {
		return numFuncionarios;
	}
	
	//setters
	
	public String setSenha() {
		return senha;
	}
	
	
}
