package br.com.poo.banco.pessoas;

public class Gerente extends Funcionarios implements IFuncionarios{

	// atributos
	private Integer numFuncionarios;
	private String agencia;

	// construtores
	public Gerente() {
		super();
	}

	public Gerente(String cargo, String nome, String cpf, Double salario, Integer senha, Integer numFuncionarios, String agencia) {
		super(cargo, nome, cpf, salario, senha);
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
	
	public double getBonificacao() {
		return this.getSalario() * 0.10;
	}
	
	// setters

	public void setSenha(Integer senha) {
		this.senha = senha;
	}

}
