package br.com.poo.banco.contas;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.poo.banco.io.RelatorioCliente;
import br.com.poo.banco.pessoas.Cliente;
import br.com.poo.banco.pessoas.Pessoas;
import br.com.poo.banco.util.Util;

public abstract class Conta {

	// Atributos
	private String tipoConta;
	private String numero;
	protected String cpfTitular;
	protected Double saldo;
	protected String agencia;
	protected Double totalTrib = 0.0;
	protected static final double TAXA = 0.10;
	protected static final double TAXATRANS = 0.20;

	// criar maps
	public static Map<String, List<Conta>> mapaContas = new HashMap<>();
	public static Map<String, Conta> mapaNumContas = new HashMap<>();

	// construtores
	protected Conta() {
	}

	protected Conta(String tipoConta, String numero, String cpfTitular, Double saldo, String agencia) {
		this.tipoConta = tipoConta;
		this.numero = numero;
		this.cpfTitular = cpfTitular;
		this.saldo = saldo;
		this.agencia = agencia;
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
		return "Tipo de conta: " + tipoConta + " Número da conta: " + numero + "\nCPF Titular: " + cpfTitular
				+ "Saldo: " + saldo + "\nAgencia: " + agencia;
	}

	public void sacar(double valor) {
		if (valor > 0 && valor <= saldo) {
			saldo -= valor;
		}
	}

	public void depositar(double valor) {
		if (valor > 0) {
			saldo += valor;
		}
	}

	public void transferir(double valor, Conta destino) {
		this.sacar(valor);
		destino.depositar(valor);
	}

	// metodo operacoes
	public void operacoes(double valor, Conta destino, int tipoOperacao) throws IOException {
		switch (tipoOperacao) {
		case 1:
			this.sacar(valor);
			saldo -= TAXA;
			RelatorioCliente.comprovanteSaque(this, valor);
			this.tributacao(0.1);
			break;

		case 2:
			this.depositar(valor);
			saldo -= TAXA;
			RelatorioCliente.comprovanteDeposito(this, valor);
			this.tributacao(0.1);
			break;

		case 3:
			this.transferir(valor, destino);
			saldo -= TAXATRANS;
			RelatorioCliente.comprovanteTransferencia(this, valor, destino);
			this.tributacao(0.20); 
			break;
		case 4:
			this.sacar(valor);
			RelatorioCliente.tributacaoSeguro((Cliente)Pessoas.mapaPessoas.get(this.getCpfTitular()), this);
			break;
		default:
			break;
		}
	}

	// Metodo Tributacao
	public void tributacao(Double tx) throws IOException  {
	}

}
