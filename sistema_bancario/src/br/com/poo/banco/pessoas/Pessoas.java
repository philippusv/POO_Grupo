package br.com.poo.banco.pessoas;

import java.util.HashMap;
import java.util.Map;

public abstract class Pessoas {
	
	// atributos
		private String tipo;
		private String nome;
		private String cpf;
		protected Integer senha;
		

	//criar map
	public static Map<String, Pessoas> mapaPessoas = new HashMap<>();
	
	//contrutor
	public Pessoas() {
	}

	public Pessoas(String tipo, String nome, String cpf, Integer senha) {
		this.tipo = tipo;
		this.nome = nome;
		this.cpf = cpf;
		this.senha = senha;
	}
	//Get e Set

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Integer getSenha() {
		return senha;
	}

	public void setSenha(Integer senha) {
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Pessoas [tipo=" + tipo + ",\n nome=" + nome + ",\n cpf=" + cpf + ",\n senha=" + senha + "]";
	}
	
	
		
}
