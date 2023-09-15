package br.com.poo.banco.io;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

import br.com.poo.banco.contas.Conta;
import br.com.poo.banco.pessoas.Diretor;
import br.com.poo.banco.pessoas.Pessoas;

public class RelatorioDiretor {

	static final String PATH_BASICO = "./temp/";
	static final String EXTENSAO = ".txt";

	// diretor
	public static void comprovanterelatorio(Pessoas pessoa) throws IOException {
		Diretor diretor = ((Diretor) Pessoas.mapaPessoas.get(pessoa.getCpf()));
		String[] agencias = { diretor.getagencia1(), diretor.getagencia2(), diretor.getagencia3() };

		String path = "ClientesAgências_" + diretor.getCpf();
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(PATH_BASICO + path + EXTENSAO, true));

		buffWrite.append("************* DADOS DO CLIENTE *************" + "\n");

		for (Map.Entry<String, List<Conta>> entry : Conta.mapaContas.entrySet()) {
			List<Conta> contas = entry.getValue();

			for (Conta conta : contas) {
				int i;
				for (i = 0; i < 3; i++) {

					if (conta.getAgencia().equals(agencias[i])) {
						buffWrite.append("CPF:" + conta.getCpfTitular() + "\n");
						buffWrite.append("NOME:" + Pessoas.mapaPessoas.get(conta.getCpfTitular()).getNome() + "\n");
						buffWrite.append("AGÊNCIA:" + conta.getAgencia() + "\n");

					}

				}

			}
		}
		LocalDateTime dataHora = LocalDateTime.now();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		buffWrite.append("Data da operação: " + dtf.format(dataHora) + "\n");

		buffWrite.append("*********** FIM DO RELATÓRIO ***********\n");

		buffWrite.close();
	}
}