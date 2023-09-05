package br.com.poo.banco.pessoas;

public class Cliente {

	// atributos
	String nome;
	String cpf;
	int numConta;

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
	
	// setters
	public void setNome(String nome) {
		this.nome = nome;
	}

}
