package br.com.poo.banco.contas;

import java.util.logging.Level;
import java.util.logging.Logger;

import br.com.poo.banco.util.Util;

public class Conta {

	// instancia o logger
	Logger logger = Util.setupLogger();

	private int numero;
	private String titular;
	protected double saldo;

	// construtores
	public Conta() {
	}

	public Conta(int numero, String titular, double saldo) {
		this.numero = numero;
		this.titular = titular;
		this.saldo = saldo;
		
		Util.customizer();
	}

	// getter
	public double getSaldo() {
		return saldo;
	}

	// set
	public void setTitular(String titular) {
		this.titular = titular;
	}

	// Método para deposito em dinheiro na conta
	public void deposito(double valor) {
        if (valor > 0) {
            saldo += valor;
          logger.log(Level.INFO,()->"Depósito na Conta  de R$" + valor + " realizado com sucesso.");
        } else {
          logger.warning("O valor do depósito na Conta deve ser maior que zero.");
        }
	}

	// Método para saque em dinheiro na conta
	public void saque(double valor) {
		if (valor > 0 && valor <= saldo) {
			saldo -= valor;
			logger.log(Level.INFO,()-> "Saque de R$" + valor + " realizado com sucesso.");
		} else {
			logger.warning("Saldo insuficiente ou valor de saque inválido.");
		}

	}

	// sobrescreve metodo padrao toString
	@Override
	public String toString() {
		return "Número da conta: " + numero + "\nTitular: " + titular + "\nSaldo: " + saldo + "\n";
	}

}
