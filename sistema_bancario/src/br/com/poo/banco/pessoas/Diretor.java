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
		this.setNome(nome);
		this.cpf = cpf;
		this.salario = salario;
		this.senha = senha;
	}

	// getters
	public String getNome()	   { return nome;	 }
	public String getCpf()	   { return cpf;	 }
	public double getSalario() { return salario; }
	public String getSenha()   { return senha;	 }
	
	// setters
	public void setNome(String nome)   { this.nome = nome;	 }
	public void setSenha(String senha) { this.senha = senha; }
}
