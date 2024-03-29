package br.com.poo.banco.io;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import br.com.poo.banco.contas.Conta;
import br.com.poo.banco.contas.ContaCorrente;
import br.com.poo.banco.contas.ContaPoupanca;
import br.com.poo.banco.enums.ContaEnum;
import br.com.poo.banco.pessoas.Cliente;
import br.com.poo.banco.pessoas.Pessoas;
import br.com.poo.banco.util.Util;

public class RelatorioCliente {

	private RelatorioCliente() {
	}

	// Constantes
	// constantes
	static final String PATH_BASICO = "./temp/";
	static final String EXTENSAO = ".txt";

	// COMPROVANTE DE SAQUE
	public static void comprovanteSaque(Conta conta, Double valor) throws IOException {
		String path = conta.getTipoConta() + "_" + conta.getCpfTitular();
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(PATH_BASICO + path + EXTENSAO, true));

		if (conta.getTipoConta().equalsIgnoreCase(ContaEnum.CORRENTE.getTipoConta())) {
			buffWrite.append("************* SAQUE *************" + "\n");
			buffWrite.append("CPF: " + conta.getCpfTitular() + "\n");
			buffWrite.append("Conta: " + conta.getNumero() + "\n");
			buffWrite.append("Valor: " + valor + "\n");
			buffWrite.append("Valor da taxa para essa operação: R$ 0.10\n");
			LocalDateTime dataHora = LocalDateTime.now();
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
			buffWrite.append("Data da operação: " + dtf.format(dataHora) + "\n");

			buffWrite.append("*********** FIM SAQUE ***********\n");
		} else {
			buffWrite.append("************* SAQUE *************" + "\n");
			buffWrite.append("CPF: " + conta.getCpfTitular() + "\n");
			buffWrite.append("Conta: " + conta.getNumero() + "\n");
			buffWrite.append("Valor: " + valor + "\n");

			LocalDateTime dataHora = LocalDateTime.now();
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
			buffWrite.append("Data da operação: " + dtf.format(dataHora) + "\n");

			buffWrite.append("*********** FIM SAQUE ***********\n");
		}
		buffWrite.close();
	}

	// COMPROVANTE DEPOSITO
	public static void comprovanteDeposito(Conta conta, Double valor) throws IOException {
		String path = conta.getTipoConta() + "_" + conta.getCpfTitular();
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(PATH_BASICO + path + EXTENSAO, true));

		if (conta.getTipoConta().equalsIgnoreCase(ContaEnum.CORRENTE.getTipoConta())) {
			buffWrite.append("************* DEPÓSITO *************" + "\n");
			buffWrite.append("CPF: " + conta.getCpfTitular() + "\n");
			buffWrite.append("Conta: " + conta.getNumero() + "\n");
			buffWrite.append("Valor: " + valor + "\n");
			buffWrite.append("Valor da taxa para essa operação: R$ 0.10\n");

			LocalDateTime dataHora = LocalDateTime.now();
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
			buffWrite.append("Data da operação: " + dtf.format(dataHora) + "\n");

			buffWrite.append("*********** FIM DEPOSITO ***********\n");
		} else {
			buffWrite.append("************* DEPÓSITO *************" + "\n");
			buffWrite.append("CPF: " + conta.getCpfTitular() + "\n");
			buffWrite.append("Conta: " + conta.getNumero() + "\n");
			buffWrite.append("Valor: " + valor + "\n");

			LocalDateTime dataHora = LocalDateTime.now();
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
			buffWrite.append("Data da operação: " + dtf.format(dataHora) + "\n");

			buffWrite.append("*********** FIM DEPOSITO ***********\n");
		}
		buffWrite.close();
	}

	// COMPROVANTE DE TRANSFERENCIA
	public static void comprovanteTransferencia(Conta contaO, Double valor, Conta contaD) throws IOException {
		String path = contaO.getTipoConta() + "_" + contaO.getCpfTitular();
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(PATH_BASICO + path + EXTENSAO, true));

		if (contaO.getTipoConta().equalsIgnoreCase(ContaEnum.CORRENTE.getTipoConta())) {
			buffWrite.append("************* TRASFERÊNCIA *************" + "\n");
			buffWrite.append("CPF: " + contaO.getCpfTitular() + "\n");
			buffWrite.append("Conta de Origem: " + contaO.getNumero() + "\n");
			buffWrite.append("Valor: " + valor + "\n");
			buffWrite.append("Conta de Destino: " + contaD.getNumero() + "\n");
			buffWrite.append("CPF do destinatário: " + contaD.getCpfTitular() + "\n");
			buffWrite.append("Valor da taxa para essa operação: R$ 0.20\n");

			LocalDateTime dataHora = LocalDateTime.now();
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
			buffWrite.append("Data da operação: " + dtf.format(dataHora) + "\n");

			buffWrite.append("*********** FIM TRASFERÊNCIA ***********\n");
		} else {
			buffWrite.append("************* TRASFERÊNCIA *************" + "\n");
			buffWrite.append("CPF: " + contaO.getCpfTitular() + "\n");
			buffWrite.append("Conta de Origem: " + contaO.getNumero() + "\n");
			buffWrite.append("Valor: " + valor + "\n");
			buffWrite.append("Conta de Destino: " + contaD.getNumero() + "\n");
			buffWrite.append("CPF do destinatário: " + contaD.getCpfTitular() + "\n");

			LocalDateTime dataHora = LocalDateTime.now();
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
			buffWrite.append("Data da operação: " + dtf.format(dataHora) + "\n");

			buffWrite.append("*********** FIM TRANSFERENCIA ***********\n");
		}
		buffWrite.close();
	}

	//RELATORIO DE TRIBUTAÇÃO DA CC
	public static void tributacaoCC(ContaCorrente conta, Double totalTrib) throws IOException {

		String path = "TributacaoCC" + "_" + conta.getNumero() + "_" + conta.getCpfTitular();
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(PATH_BASICO + path + EXTENSAO));

		buffWrite.append("************* RELATORIO DE TRIBUTAÇÃO DA CC *************" + "\n");
		buffWrite.append("CPF do Titular: " + conta.getCpfTitular() + "\n");
		buffWrite.append("Conta: " + conta.getNumero() + "\n");
		buffWrite.append("Valor das taxas(R$): \n");
		buffWrite.append("-Depósitos e saques: R$" + Util.dfFormat(conta.getTAXA()) + "\n");
		buffWrite.append("-Tranferencias: R$" + Util.dfFormat(conta.getTAXATRANS()) + " a ser cobrada do remetente\n");
		buffWrite.append("Total arrecadado até o momento: R$" + totalTrib + "\n");

		LocalDateTime dataHora = LocalDateTime.now();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		buffWrite.append("Data da operação: " + dtf.format(dataHora) + "\n");

		buffWrite.append("*********** FIM RELATORIO DE TRIBUTAÇÃO DA CC ***********\n");

		buffWrite.close();
	}

	//RELATORIO DE RENDIMENTO DA POUPANÇA
	public static void rendimentoCP(ContaPoupanca conta, double valorInvestido, int dias) throws IOException {

		String path = "Rendimento Poupanca";
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(PATH_BASICO + path + EXTENSAO, true));

		String rendimento = conta.calcularRendimento(valorInvestido, dias);

		buffWrite.append("************* RELATORIO DE RENDIMENTO DA CP *************" + "\n");
		buffWrite.append("Investimento Inicial: R$" + Util.dfFormat(valorInvestido) + "\n");
		buffWrite.append("Quantidade de dias: " + dias + " dias\n");
		buffWrite.append("O seu rendimento vai ser de " + rendimento + " reais\n");

		LocalDateTime dataHora = LocalDateTime.now();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		buffWrite.append("Data da operação: " + dtf.format(dataHora) + "\n");
		buffWrite.append("************* FIM RELATORIO DE RENDIMENTO DA CP *************" + "\n");

		buffWrite.close();
	}

	//RELATORIO SALDO
	public static void saldo(Conta conta) throws IOException {
		String path = "Saldo_" + conta.getTipoConta() + "_" + conta.getCpfTitular();
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(PATH_BASICO + path + EXTENSAO, true));

		buffWrite.append("************* SALDO *************" + "\n");
		buffWrite.append("CPF: " + conta.getCpfTitular() + "\n");
		buffWrite.append("Conta: " + conta.getNumero() + "\n");
		buffWrite.append("Tipo de Conta: " + conta.getTipoConta() + "\n ");
		buffWrite.append("SALDO: R$" + Util.dfFormat(conta.getSaldo()) + "\n");

		LocalDateTime dataHora = LocalDateTime.now();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		buffWrite.append("Data da operação: " + dtf.format(dataHora) + "\n");

		buffWrite.append("*********** FIM SALDO ***********\n");
		buffWrite.close();
	}

	// SEGURO DE VIDA
	public static void tributacaoSeguro(Cliente cliente, Conta conta) throws IOException {

		String path = "SeguroVida" + "_" + conta.getCpfTitular();
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(PATH_BASICO + path + EXTENSAO));

		buffWrite.append("************* RELATORIO DE TRIBUTAÇÃO DO SEGURO DE VIDA *************" + "\n");
		buffWrite.append("Nome do titular: " + cliente.getNome() + "\n");
		buffWrite.append("CPF: " + conta.getCpfTitular() + "\n");
		buffWrite.append("Conta: " + conta.getNumero() + "\n");
		buffWrite.append("Valor Segurado: R$ "+Util.dfFormat(cliente.getSeguroVida().getValorSegurado())+"\n");
		buffWrite.append("Valor Tributado: R$ "+Util.dfFormat(cliente.calcularTributo())+"\n");

		LocalDateTime dataHora = LocalDateTime.now();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		buffWrite.append("Data da operação: " + dtf.format(dataHora) + "\n");

		buffWrite.append("*********** FIM RELATORIO DO SEGURO DE VIDA ***********\n");

		buffWrite.close();
	}
}
