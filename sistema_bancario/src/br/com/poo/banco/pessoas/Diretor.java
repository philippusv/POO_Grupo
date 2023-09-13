
package br.com.poo.banco.pessoas;

public class Diretor extends Funcionarios implements IFuncionarios{
		
	// construtores
	public Diretor() {
		super();
	}
	
	public Diretor(String tipo, String nome, String cpf, Integer senha, Double salario) {
		super(tipo, nome, cpf, senha, salario);
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