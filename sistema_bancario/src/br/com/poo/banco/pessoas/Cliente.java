package br.com.poo.banco.pessoas;

import java.util.HashMap;
import java.util.Map;

public class Cliente {

	// atributos
	private String tipo;
	private String nome;
	private String cpf;
	private String numConta;
	protected Integer senha;
	
	//criar map
	public static Map<String, Cliente> mapaCliente = new HashMap<>();
	
	// construtores
	public Cliente() {

	}

	public Cliente(String tipo, String nome, String cpf, String numConta, Integer senha) {
		this.tipo = tipo;
		this.nome = nome;
		this.cpf = cpf;
		this.numConta = numConta;
		this.senha = senha;
	}
	
	// getters
	public String getNome() {
		return nome;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public String getNumConta() {
		return numConta;
	}
		
	public Integer getSenha() {
		return senha;
	}

	public String getTipo() {
		return tipo;
	}

	// setters
	public void setNome(String nome) {
		this.nome = nome;
	}

}
