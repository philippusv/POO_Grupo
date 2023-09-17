package br.com.poo.banco.contas;

public class ContaPoupanca extends Conta{
	
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
		return Double.toString(calculo);
	}

	// Método sacar

	@Override
	public void sacar(double valor) {
		if (valor > 0 && valor <= saldo) {
			saldo -= valor;
		}
	}

	// Método depositar
	@Override
	public void depositar(double valor) {
		if (valor > 0) {
			saldo += valor;
		}
	}

}