package br.com.poo.banco.pessoas;

public class Presidente extends Funcionarios{
	//Atributos
	
	private Integer numUnidades;
	private String email;
	
	
	//Construtor
	public Presidente() {
		super();
	}
	
	public Presidente(String cargo, String nome, String cpf, Double salario, Integer senha, Integer numUnidades, String email) {
		super(cargo, nome, cpf, salario, senha);
		this.numUnidades = numUnidades;
		this.email = email;
	}
	
	//getters
	public Integer getNumUnidades() {
		return numUnidades;
	}
	
	public String getEmail() {
		return email;
	}
	
	//setters
	public void setEmail (String email) {
		this.email = email;
	}

}
