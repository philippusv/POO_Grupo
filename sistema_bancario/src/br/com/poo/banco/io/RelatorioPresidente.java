package br.com.poo.banco.io;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

import br.com.poo.banco.contas.Conta;
import br.com.poo.banco.pessoas.Pessoas;

public class RelatorioPresidente {

	static final String PATH_BASICO = "./temp/";
	static final String EXTENSAO = ".txt";

	public static double capitalArmazenado(Pessoas pessoa) throws IOException {
		
		String path = "SaldoContas" + pessoa.getCpf();
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(PATH_BASICO + path + EXTENSAO, true));
		buffWrite.append("******** TOTAL CAPITAL ARMAZENADO*********" + "\n");
		
		double i=0;
		for (Map.Entry<String, List<Conta>> entry : Conta.mapaContas.entrySet()) {
			List<Conta> contas = entry.getValue();

			for (Conta conta :contas) {
				i += conta.getSaldo();
			}
		}
		buffWrite.append("O saldo total é igual a R$ " + i + "\n");
		
		LocalDateTime dataHora = LocalDateTime.now();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		buffWrite.append("Data da operação: " + dtf.format(dataHora) + "\n");
		buffWrite.append("*********** FIM DO RELATÓRIO ***********\n");
		buffWrite.close();
		
		return i;
	}
	
	
	public static void relatorioDiretores(Pessoas pessoa, String[][] dados) throws IOException {
		
		String path = "RelatorioDiretoresAgencias_" + pessoa.getCpf();
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(PATH_BASICO + path + EXTENSAO, true));
		buffWrite.append("*** DADOS DOS DIRETORES E SUAS AGÊNCIAS ****" + "\n");
		
		// Imprimir dados dos diretores, suas agências e os gerentes das mesmas:
		for (String[] _dados : dados) {
			if (!_dados[0].equalsIgnoreCase("")) {
				buffWrite.append("============================\n"); 
			}
			for (int i = 0; i < 3; i++) {
				
				// Se diretor estiver vazio, apenas imprimir informações das próximas agências:
				if (i == 0 && !_dados[i].equalsIgnoreCase("")) {
					buffWrite.append("Diretor: " + _dados[i] + "\n");
				}
				
				// Imprimir agência:
				if (i == 1) { buffWrite.append("Agência: " + _dados[i] + "\n"); }
				
				// Imprimir nome do gerente:
				if (i == 2) { 
					if (!_dados[i].equalsIgnoreCase("")) {
						buffWrite.append("Gerente: " + _dados[i] + "\n"); 
					} else { buffWrite.append("Nenhum gerente cadastrado.\n"); }
					buffWrite.append("----------------------------\n");
				}
			}
		}
		LocalDateTime dataHora = LocalDateTime.now();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		buffWrite.append("Data da operação: " + dtf.format(dataHora) + "\n");
		buffWrite.append("************* FIM DO RELATÓRIO *************\n");
		buffWrite.close();
	}
}
