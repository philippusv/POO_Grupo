package br.com.poo.banco.pessoas;

public class Presidente extends Funcionarios{
	
	//Atributos
	
	private Integer numUnidades;
	
	
	//Construtor
	
	public Presidente() {
		super();
	}
	
	
	public Presidente(String tipo, String nome, String cpf, Integer senha, Double salario, Integer numUnidades) {
		super(tipo, nome, cpf, senha, salario);
		this.numUnidades = numUnidades;
	}
		

	//getters
	public Integer getNumUnidades() {
		return numUnidades;
	}


	

}
