package br.com.poo.banco.pessoas;

public class Gerente extends Funcionarios implements IFuncionarios{

	// atributos
	private Integer numFuncionarios;
	private String agencia;

	// construtores
	public Gerente() {
		super();
	}
	
	public Gerente(String tipo, String nome, String cpf, Integer senha, Double salario
			,Integer numFuncionarios, String agencia) {
		super(tipo, nome, cpf, senha, salario);
		this.numFuncionarios = numFuncionarios;
		this.agencia = agencia;
	}
	

	// getters
	public int getNumFuncionarios() {
		return numFuncionarios;
	}
	
	public String getAgencia() {
		return agencia;
	}
	// setters
	
	public void setSenha(Integer senha) {
		this.senha = senha;
	}
	
	//Método bonificação
	public double getBonificacao() {
		return this.getSalario() * 0.10;
	}
	

}
