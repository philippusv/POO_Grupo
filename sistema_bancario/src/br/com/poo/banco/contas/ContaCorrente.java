package br.com.poo.banco.contas;

import java.util.logging.Level;

public class ContaCorrente extends Conta implements IConta{

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
	//metodos

	// Método para deposito em dinheiro na conta
	
	@Override
	public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
          logger.log(Level.INFO,()->"Depósito na Conta  de R$" + valor + " realizado com sucesso.");
        } else {
          logger.warning("O valor do depósito na Conta deve ser maior que zero.");
        }
	}

	// Método para saque em dinheiro na conta

	@Override
	public void sacar(double valor) {
		if (valor > 0 && valor <= saldo) {
			saldo -= valor;
			logger.log(Level.INFO, () -> "Saque de R$" + valor + " realizado com sucesso.");
		} else if (valor > 0 && valor <= (saldo + chequeEspecial)) {
			saqueChequeEspecial(valor);
		} else {
			logger.warning("Saldo insuficiente ou valor de saque inválido.");
		}

	}
	//Metodo saque especial
	private void saqueChequeEspecial(double valor) {
		this.saldo -= valor;
		logger.log(Level.WARNING, () -> "Saque em cheque especial!\nSaldo disponível: " + saldo);
	}
	
	//Método transferir
	@Override
	public void transferir(double valor, Conta destino) {
		this.sacar(valor);
		destino.depositar(valor);
}

}