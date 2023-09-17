
package br.com.poo.banco.pessoas;

public class Diretor extends Funcionarios implements IFuncionarios{
	
	private String agencia1;
	private String agencia2;
	private String agencia3;
			
	// construtores
	public Diretor() {
		super();
	}
	
	public Diretor(String tipo, String nome, String cpf, Integer senha, Double salario, String agencia1,
			String agencia2, String agencia3) {
		super(tipo, nome, cpf, senha, salario);
		this.agencia1 = agencia1;
		this.agencia2 = agencia2;
		this.agencia3 = agencia3;
	}

	public String getagencia1() {
		return agencia1;
	}

	public String getagencia2() {
		return agencia2;
	}

	public String getagencia3() {
		return agencia3;
    		
    }
        		
	
	// setters
	public void setSenha(Integer senha) {
		this.senha = senha;
	}
	
	//Método bonificação
	public double getBonificacao() {
		return this.getSalario() * 0.10 + 1000;
	}
	
}