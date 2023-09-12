package br.com.poo.banco.contas;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;
import br.com.poo.banco.util.Util;

public abstract class Conta {
	
	//Atributos
	private String tipoConta;
	private String numero;
	protected String cpfTitular;
	protected Double saldo;
	protected String agencia;
	
	//criar map
		public static Map<String, Conta> mapaContas = new HashMap<>();

	// instancia o logger
	Logger logger = Util.setupLogger();
	
	// construtores
	protected Conta() {
	}
	
	public Conta(String tipoConta, String numero,String cpfTitular, Double saldo, 
			String agencia) {
		this.tipoConta = tipoConta;
		this.numero = numero;
		this.cpfTitular = cpfTitular;
		this.saldo = saldo;
		this.agencia = agencia;
		
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
	
	public String getTipoConta() {
		return tipoConta;
	}

	public String getNumero() {
		return numero;
	}

	// set
	public void setCpfTitular(String cpfTitular) {
		this.cpfTitular = cpfTitular;
	}
	


	// sobrescreve metodo padrao toString
	@Override
	public String toString() {
		return "Tipo de conta: "+ tipoConta+"Número da conta: " + numero + "\nCPF Titular: " + cpfTitular + "\nSaldo: " + saldo + "\nAgencia: "+agencia;
	}
	

	//Método depositar
	public void depositar(double valor) {
		this.saldo += valor;		
	}

	

}
