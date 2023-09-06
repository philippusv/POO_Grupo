package br.com.poo.banco.contas;

public class ContaCorrente extends Conta {

	private double chequeEspecial;

	// Construtor
	public ContaCorrente() {
		super();
	}
	
	public ContaCorrente(int numero, String titular, double saldo, double chequeEspecial) {
		super(numero, titular, saldo);
		this.chequeEspecial = chequeEspecial;
	}

	// getter para o chequeEspecial
	public double getChequeEspecial() {
		return chequeEspecial;
	}
	
	// setter para o chequeEspecial
	public void setChequeEspecial(double chequeEspecial) {
		this.chequeEspecial = chequeEspecial;
	}
	
	

}