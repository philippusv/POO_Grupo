package br.com.poo.banco.io;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import br.com.poo.banco.contas.Conta;
import br.com.poo.banco.pessoas.Pessoas;
import br.com.poo.banco.pessoas.Gerente;

public class RelatorioGerente {
	
	// Constantes
	static final String PATH_BASICO = "./temp/";
	static final String EXTENSAO = ".txt";

	// Relatório do total de contas na agência:
	public static void relatorioTotal(Gerente gerente, String[] numContas) throws IOException {
		String path = "TotalContas_Agencia" + gerente.getAgencia();
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(PATH_BASICO + path + EXTENSAO, true));
		
		buffWrite.append("********** TOTAL DE CONTAS **********" + "\n");
		buffWrite.append("Agência " + gerente.getAgencia() + ": " + numContas.length + " contas\n");
		for (String num : numContas) {
			buffWrite.append(num + "\n");
		}
		LocalDateTime dataHora = LocalDateTime.now();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		buffWrite.append("Data de impressão: " + dtf.format(dataHora) + "\n");
		buffWrite.append("************* FIM TOTAL *************" + "\n");
		buffWrite.close();
	}
	
	// Relatório das contas selecionadas e suas informações relevantes:
		public static void relatorioContas(Gerente gerente, String[] keys) throws IOException {
			String path = "RelatorioContas_Agencia" + gerente.getAgencia();
			BufferedWriter buffWrite = new BufferedWriter(new FileWriter(PATH_BASICO + path + EXTENSAO, true));

			buffWrite.append("****** RELATÓRIO DE CONTAS ******" + "\n");
			for (String key : keys) {
				for (Conta conta : Conta.mapaContas.get(key)) {
					buffWrite.append("Número da Conta: " + conta.getNumero() + "\n");
					buffWrite.append("Tipo de Conta: " + conta.getTipoConta() + "\n");
					buffWrite.append("Nome do Títular: " + Pessoas.mapaPessoas.get(key).getNome() + "\n");
					buffWrite.append("CPF do Títular: " + key + "\n");
					buffWrite.append("Saldo da Conta: " + conta.getSaldo() + "\n");
				}
				buffWrite.append("--------------------------------" + "\n");
			}
			LocalDateTime dataHora = LocalDateTime.now();
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
			buffWrite.append("Data de impressão: " + dtf.format(dataHora) + "\n");
			buffWrite.append("********* FIM RELATÓRIO *********" + "\n");
			buffWrite.close();
		}
}
