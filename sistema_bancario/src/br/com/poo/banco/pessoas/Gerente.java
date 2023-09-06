package br.com.poo.banco.pessoas;

public class Gerente extends Funcionarios {

	// atributos
	private String senha;
	private int numFuncionarios;

	// construtores
	public Gerente() {
		super();
	}

	public Gerente(String nome, String cpf, double salario, String senha, int numFuncionarios) {
		super(nome, cpf, salario);
		this.numFuncionarios = numFuncionarios;
		this.senha = senha;
	}

	// getters
	
	public int getNumFuncionarios() {
		return numFuncionarios;
	}
	
	public String getSenha() {
		return senha;
	}

	
	// setters

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
