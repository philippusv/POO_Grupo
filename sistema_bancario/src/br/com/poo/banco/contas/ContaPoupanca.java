package br.com.poo.banco.contas;

import java.util.logging.Level;

public class ContaPoupanca extends Conta {

	private double rendimento;
	private double tx = 0.5 / 100;

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

	//Método de simulação de rendimento
	public void calcularRendimento(double valorInvestido) {
		double calculo = valorInvestido * tx;
		logger.log(Level.INFO, () -> "O seu rendimento vai ser de " + calculo + " reais");
		double novoSaldo = (getSaldo() + valorInvestido)*tx;
		logger.log(Level.INFO, () -> "Agora seu saldo seria de " + novoSaldo + " reais");
	}

}