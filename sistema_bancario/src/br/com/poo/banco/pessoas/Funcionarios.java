package br.com.poo.banco.pessoas;

import java.util.HashMap;
import java.util.Map;

public class Funcionarios {

	// atributos
	protected String cargo;
	private String nome;
	private String cpf;
	private Double salario;
	protected Integer senha;

	// criar map
	public static Map<String, Funcionarios> mapaFuncionarios = new HashMap<>();

	// construtores
	public Funcionarios() {

	}

	public Funcionarios(String cargo, String nome, String cpf, Double salario, Integer senha) {
		this.nome = nome;
		this.cpf = cpf;
		this.salario = salario;
		this.cargo = cargo;
		this.senha = senha;
	}

	// getters
	public String getNome() {
		return nome;
	}

	public String getCpf() {
		return cpf;
	}

	public double getSalario() {
		return salario;
	}

	public Integer getSenha() {
		return senha;
	}

	public String getCargo() {
		return cargo;
	}

	// setters
	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	@Override
	public String toString() {
		return "Funcionarios [cargo=" + cargo + ",\nnome=" + nome + ", \ncpf=" + cpf + ",\nsalario=" + salario
				+ ",\nsenha=" + senha + "]";
	}

}
