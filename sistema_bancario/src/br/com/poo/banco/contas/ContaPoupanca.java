package br.com.poo.banco.contas;

public class ContaPoupanca extends Conta {

	private double rendimento;
	
	// Construtores
	public ContaPoupanca() {
		super();
	}

	public ContaPoupanca(int numero, String titular, double saldo, double rendimento) {
		super(numero, titular, saldo);
		this.rendimento = rendimento;
	}
	
	// getter
	public double getRendimento() {
		return rendimento;
	}

}