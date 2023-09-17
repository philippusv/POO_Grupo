package br.com.poo.banco.contas;

import java.io.IOException;
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
	public void sacar(double valor) {
		if (valor > 0 && valor <= saldo) {
			saldo -= valor;
		} else if (valor > 0 && valor <= (saldo + chequeEspecial)) {
			saqueChequeEspecial(valor);
		}
	}

	// Metodo cheque especial
	private void saqueChequeEspecial(double valor) {
		this.saldo -= valor;
	}
	
	//Metodo Tributacao
	@Override
	public void tributacao(Double tx) throws IOException {
		this.totalTrib += tx;
		RelatorioCliente.tributacaoCC(this,this.totalTrib);
	} 

}