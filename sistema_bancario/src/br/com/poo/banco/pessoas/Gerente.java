package br.com.poo.banco.pessoas;

public class Gerente extends Funcionarios {

	// atributos
	private int numFuncionarios;
	private String agencia;

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
	
	public String getAgencia() {
		return agencia;
	}
	
	// setters

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
