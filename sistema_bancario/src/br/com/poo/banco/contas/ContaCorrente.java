package br.com.poo.banco.contas;

import java.io.IOException;
import java.util.logging.Level;
import br.com.poo.banco.io.RelatorioCliente;

public class ContaCorrente extends Conta {
	
	private double chequeEspecial = 100;
	
	// Construtor
	public ContaCorrente() {
		super();
	}

	public ContaCorrente(String tipoConta, String numero, String cpfTitular, Double saldo, String agencia,
			Double chequeEspecial) {
		super(tipoConta, numero, cpfTitular, saldo, agencia);
		this.chequeEspecial = chequeEspecial;
	}

	// getter 
	public Double getChequeEspecial() {
		return chequeEspecial;
	}
	

	public double getTAXA() {
		return TAXA;
	}

	public double getTAXATRANS() {
		return TAXATRANS;
	}

	// setter para o chequeEspecial
	public void setChequeEspecial(Double chequeEspecial) {
		this.chequeEspecial = chequeEspecial;
	}

	// Método para saque em dinheiro na conta
	@Override
	public void sacar(double valor) throws IOException {
		if (valor > 0 && valor <= saldo) {
			saldo -= valor;
			logger.log(Level.INFO, () -> "Saque de R$" + valor + " realizado com sucesso.");
		} else if (valor > 0 && valor <= (saldo + chequeEspecial)) {
			saqueChequeEspecial(valor);
		} else {
			logger.warning("Saldo insuficiente ou valor de saque inválido.");
		}
	}

	// Metodo cheque especial
	private void saqueChequeEspecial(double valor) throws IOException {
		this.saldo -= valor;
		logger.log(Level.WARNING, () -> "Saque em cheque especial!\nSaldo disponível: " + saldo);
	}

}