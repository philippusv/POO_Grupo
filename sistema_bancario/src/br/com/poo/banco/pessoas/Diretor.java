
package br.com.poo.banco.pessoas;

public class Diretor extends Funcionarios implements IFuncionarios{
		
	// construtores
	public Diretor(String cargo, String nome, String cpf, Double salario, Integer senha) {
		super();
	}
	
	
	public double getBonificacao() {
		return this.getSalario() * 0.10 + 1000;
	}

	// setters
	public void setSenha(Integer senha) {
		this.senha = senha;
	}
	
	
}