package br.com.poo.banco.contas;

public class Conta {

	private int numero;
	private String titular;
	private double saldo;

	// construtores
	public Conta() {
	}

	public Conta(int numero, String titular, double saldo) {
		this.numero = numero;
		this.titular = titular;
		this.saldo = saldo;
	}

	// getter
	public double getSaldo() {
		return saldo;
	}

	// sobrescreve metodo padrao toString
	@Override
	public String toString() {
		return "Número da conta: " + numero + "\nTitular: " + titular + "\nSaldo: " + saldo + "\n";
	}

}
