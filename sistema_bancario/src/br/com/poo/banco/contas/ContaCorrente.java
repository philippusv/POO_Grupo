package br.com.poo.banco.contas;

import java.util.logging.Level;

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

	@Override
	public void saque(double valor) {
		if (valor > 0 && valor <= saldo) {
			saldo -= valor;
			logger.log(Level.INFO, () -> "Saque de R$" + valor + " realizado com sucesso.");
		} else if (valor > 0 && valor <= (saldo + chequeEspecial)) {
			saqueChequeEspecial(valor);
		} else {
			logger.warning("Saldo insuficiente ou valor de saque inválido.");
		}

	}

	private void saqueChequeEspecial(double valor) {
		this.saldo -= valor;
		logger.log(Level.WARNING, () -> "Saque em cheque especial!\nSaldo disponível: " + saldo);
	}

}