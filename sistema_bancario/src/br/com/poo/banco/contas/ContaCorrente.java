package br.com.poo.banco.contas;

import java.io.IOException;
import java.util.logging.Level;

import br.com.poo.banco.io.LeituraEscrita;

public class ContaCorrente extends Conta implements IConta{

	private double chequeEspecial;

	// Construtor
	public ContaCorrente() {
		super();
	}

	public ContaCorrente(String tipoConta, String numero,String cpfTitular, Double saldo, 
			String agencia,Double chequeEspecial) {
		super(tipoConta, numero, cpfTitular, saldo, 
				agencia);
		this.chequeEspecial = chequeEspecial;
	}

	// getter para o chequeEspecial
	public Double getChequeEspecial() {
		return chequeEspecial;
	}

	// setter para o chequeEspecial
	public void setChequeEspecial(Double chequeEspecial) {
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
	public void sacar(double valor) throws IOException {
		if (valor > 0 && valor <= saldo) {
			saldo -= valor;
			logger.log(Level.INFO, () -> "Saque de R$" + valor + " realizado com sucesso.");
			LeituraEscrita.comprovanteSaque(this, valor);
		} else if (valor > 0 && valor <= (saldo + chequeEspecial)) {
			saqueChequeEspecial(valor);
		} else {
			logger.warning("Saldo insuficiente ou valor de saque inválido.");
		}

	}
	//Metodo saque especial
	private void saqueChequeEspecial(double valor) throws IOException {
		this.saldo -= valor;
		logger.log(Level.WARNING, () -> "Saque em cheque especial!\nSaldo disponível: " + saldo);
		LeituraEscrita.comprovanteSaque(this, valor);
	}
	
	//Método transferir
	@Override
	public void transferir(double valor, Conta destino) throws IOException {
		this.sacar(valor);
		destino.depositar(valor);
}

}