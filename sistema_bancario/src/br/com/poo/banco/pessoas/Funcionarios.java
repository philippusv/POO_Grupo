package br.com.poo.banco.pessoas;

public class Funcionarios extends Pessoas {

	// atributos
	private Double salario;
	
	
	// construtores
	
	public Funcionarios() {
		super();
	}
	
	public Funcionarios(String tipo, String nome, String cpf, Integer senha, Double salario) {
		super(tipo, nome, cpf, senha);
		this.salario = salario;
	}

	// getters e setters
	public Double getSalario() {
		return salario;
	}
	
	public void setSalario(Double salario) {
		this.salario = salario;
	}
	

}
