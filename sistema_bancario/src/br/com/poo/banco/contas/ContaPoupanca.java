package br.com.poo.banco.contas;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;

public class ContaPoupanca extends Conta implements IConta {
	
	private double tx = 0.5 / 100;

	// Construtores
	public ContaPoupanca() {
		super();
	}

	public ContaPoupanca(String tipoConta, String numero, String cpfTitular, Double saldo, String agencia) {
		super(tipoConta, numero, cpfTitular, saldo, agencia);
	}

	// getter
	public double getTx() {
		return tx;
	}

	// metodos

	// Método de simulação de rendimento
	public String calcularRendimento(double valorInvestido, int dias) {
		Double calculo = valorInvestido * (tx / 30) * dias;
		logger.log(Level.INFO, () -> "O seu rendimento vai ser de " + calculo + " reais");
		String resultado = Double.toString(calculo);

		return resultado;
	}

	// Método sacar

	@Override
	public void sacar(double valor) {
		if (valor > 0 && valor <= saldo) {
			saldo -= valor;
			logger.log(Level.INFO, () -> "Saque de R$" + valor + " realizado com sucesso.");
		} else {
			logger.warning("Saldo insuficiente ou valor de saque inválido.");
		}

	}

	// Método depositar
	@Override
	public void depositar(double valor) {
		if (valor > 0) {
			saldo += valor;
			logger.log(Level.INFO, () -> "Depósito na poupança  de R$" + valor + " realizado com sucesso.");
		} else {
			logger.warning("O valor do depósito na poupança deve ser maior que zero.");
		}
	}

	// Método trasferir
	@Override
	public void transferir(double valor, Conta destino) {
		this.sacar(valor);
		destino.depositar(valor);
	}

}