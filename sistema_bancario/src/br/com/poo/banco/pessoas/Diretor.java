package br.com.poo.banco.pessoas;

public class Diretor extends Funcionarios {

	// atributos

	private String senha;

	// construtores
	public Diretor() {
		super();
	}

	public Diretor(String nome, String cpf, double salario, String senha) {
		super(nome, cpf, salario);
		this.senha = senha;
	}

	// getters
	public String getSenha() {
		return senha;
	}

	// setters
	public void setSenha(String senha) {
		this.senha = senha;
	}
}
