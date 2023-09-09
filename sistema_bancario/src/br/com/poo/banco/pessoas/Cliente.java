package br.com.poo.banco.pessoas;

public class Cliente {

	// atributos
	private String nome;
	private String cpf;
	private int numConta;
	protected int senha;
	
	// construtores
	public Cliente() {

	}

	public Cliente(String nome, String cpf, int numConta) {
		this.nome = nome;
		this.cpf = cpf;
		this.numConta = numConta;
	}
	
	// getters
	public String getNome() {
		return nome;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public int getNumConta() {
		return numConta;
	}
		
	public int getSenha() {
		return senha;
	}

	// setters
	public void setNome(String nome) {
		this.nome = nome;
	}

}
