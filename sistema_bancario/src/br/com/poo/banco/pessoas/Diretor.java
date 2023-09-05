package br.com.poo.banco.pessoas;

public class Diretor {
	
	// atributos
	private String nome;
	private String cpf;
	private double salario;
	private String senha;
	
	// construtores
	public Diretor() {}
	
	public Diretor(String nome, String cpf, double salario, String senha) {
		this.nome = nome;
		this.setCpf(cpf);
		this.salario = salario;
		this.setSenha(senha);
	}

	// getters
	public String getNome() { return nome; }
	public String getCpf()  { return cpf;  }
	
	// setters
	public void setCpf(String cpf)		{ this.cpf = cpf; }
	public void setSenha(String senha)  { this.senha = senha; }
}
