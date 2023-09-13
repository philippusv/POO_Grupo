package br.com.poo.banco.io;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import br.com.poo.banco.contas.Conta;

public class RelatorioCliente {
	
	//Constantes
	// constantes
		static final String PATH_BASICO = "./temp/";
		static final String EXTENSAO = ".txt";

		// comprovante de saque
		public static void comprovanteSaque(Conta conta, Double valor) throws IOException {
			String path = conta.getTipoConta() + "_" + conta.getCpfTitular();
			BufferedWriter buffWrite = new BufferedWriter(new FileWriter(PATH_BASICO + path + EXTENSAO, true));
			
			buffWrite.append("************* SAQUE *************" + "\n");
			buffWrite.append("CPF: " + conta.getCpfTitular() + "\n");
			buffWrite.append("Conta: " + conta.getNumero() + "\n");
			buffWrite.append("Valor: " + valor + "\n");
			
			LocalDateTime dataHora = LocalDateTime.now();
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
			buffWrite.append("Data da operação: " + dtf.format(dataHora) + "\n");
			
			buffWrite.append("*********** FIM SAQUE ***********\n");
			
			buffWrite.close();
		}
}
