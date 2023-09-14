package br.com.poo.banco.pessoas;

public class Cliente extends Pessoas{

	// atributos
	private String numConta;
	
		
	// construtores
	
	public Cliente() {
		super();
	}
	
	public Cliente(String tipo, String nome, String cpf, Integer senha, String numConta) {
		super(tipo, nome, cpf, senha);
		this.numConta = numConta;
		
	}
	
	// getters
	public String getNumConta() {
		return numConta;
	}
	
}
