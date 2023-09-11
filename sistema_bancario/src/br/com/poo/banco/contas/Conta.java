package br.com.poo.banco.contas;

import java.util.logging.Logger;

import br.com.poo.banco.util.Util;

public abstract class Conta {

	// instancia o logger
	Logger logger = Util.setupLogger();

	private int numero;
	private String titular;
	protected double saldo;
	protected String cpfTitular;
	protected String agencia;

	// construtores
	protected Conta() {
	}

	protected Conta(int numero, String titular, double saldo) {
		this.numero = numero;
		this.titular = titular;
		this.saldo = saldo;
		
		Util.customizer();
	}

	// getter
	public double getSaldo() {
		return saldo;
	}
	public String getCpfTitular() {
		return cpfTitular;
	}

	public String getAgencia() {
		return agencia;
	}

	// set
	public void setTitular(String titular) {
		this.titular = titular;
	}


	// sobrescreve metodo padrao toString
	@Override
	public String toString() {
		return "Número da conta: " + numero + "\nTitular: " + titular + "\nSaldo: " + saldo + "\n";
	}
	
	//Método depositar
	public void depositar(double valor) {
		this.saldo += valor;		
	}

	

}
