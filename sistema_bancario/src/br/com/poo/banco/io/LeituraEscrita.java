package br.com.poo.banco.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import br.com.poo.banco.contas.Conta;
import br.com.poo.banco.contas.ContaCorrente;
import br.com.poo.banco.contas.ContaPoupanca;
import br.com.poo.banco.enums.ContaEnum;
import br.com.poo.banco.enums.PessoaEnum;
import br.com.poo.banco.pessoas.Cliente;
import br.com.poo.banco.pessoas.Diretor;
import br.com.poo.banco.pessoas.Funcionarios;
import br.com.poo.banco.pessoas.Gerente;
import br.com.poo.banco.pessoas.Presidente;

public class LeituraEscrita {
	// constantes
	static final String PATH_BASICO = "./temp/";
	static final String EXTENSAO = ".txt";

	// método estático
	public static void leitor(String path) throws IOException {

		// permissão da leitura do arquivo
		BufferedReader buffRead = new BufferedReader(new FileReader(PATH_BASICO + path + EXTENSAO));

		// definir uma variavel string
		String linha = "";

		// faço um enquanto para ler
		while (true) {
			linha = buffRead.readLine();
			if (linha != null) {
				// sepadação da informação por ; e digo que as linhas são string
				String[] dados = linha.split(";");

				// equalsIgnoreCase é a mesma coisa que o == "1"--> usamos em comparação de
				// string
				if (dados[0].equalsIgnoreCase(ContaEnum.POUPANCA.getTipoConta())) {

					// cria objeto
					ContaPoupanca cp = new ContaPoupanca(dados[0], dados[1], 
							dados[2], Double.parseDouble(dados[3]),dados[4]);

					// coloca o objeto no map
					// dentro do array eu coloco a posição onde tem o identificador unico
					Conta.mapaContas.put(dados[2], cp);

				} else if (dados[0].equalsIgnoreCase(ContaEnum.CORRENTE.getTipoConta())) {
					ContaCorrente cc = new ContaCorrente(dados[0], dados[1], 
							dados[2], Double.parseDouble(dados[3]),dados[4],
							Double.parseDouble(dados[5]));
					Conta.mapaContas.put(dados[2], cc);
					//String tipo, String nome, String cpf, String numConta, Interger senha
				} else if (dados[0].equalsIgnoreCase(PessoaEnum.CLIENTE.getTipoPessoa())) {
					
					// map Cliente
					Cliente cl = new Cliente(dados[0], dados[1],dados[2],dados[3],Integer.parseInt(dados[4]));
					Cliente.mapaCliente.put(dados[2],cl);
					
				} else if (dados[0].equalsIgnoreCase(PessoaEnum.GERENTE.getTipoPessoa())) {
						Gerente gr = new Gerente(dados[0], dados[1],dados[2],Double.parseDouble(dados[3]),
							Integer.parseInt(dados[4]), Integer.parseInt(dados[5]), dados[6]);
								Funcionarios.mapaFuncionarios.put(dados[2], gr);
				} else if (dados[0].equalsIgnoreCase(PessoaEnum.DIRETOR.getTipoPessoa())) {
					
					// map Diretor
					Diretor dr = new Diretor(dados[0], dados[1],dados[2],Double.parseDouble(dados[3]),Integer.parseInt(dados[4]));
					Funcionarios.mapaFuncionarios.put(dados[2], dr);
				} else if (dados[0].equalsIgnoreCase(PessoaEnum.PRESIDENTE.getTipoPessoa())) {
					
					// map Presidente
					Presidente pr = new Presidente(dados[0], dados[1], dados[2],Double.parseDouble(dados[3]),Integer.parseInt(dados[4]), Integer.parseInt(dados[5]), dados[6]);
					Funcionarios.mapaFuncionarios.put(dados[2], pr);
				}

			} else {
				break;
			}
		}
		System.out.println(Conta.mapaContas);
		System.out.println(Cliente.mapaCliente);
		System.out.println(Funcionarios.mapaFuncionarios);
		
		// fechar o buff
		buffRead.close();
	}

	public static void escritor(String path) throws IOException {
		// defino o tipo que vai ser escrito
		String input;
		Scanner sc = new Scanner(System.in);

		// abre a permissão de escrita
		BufferedWriter buffWriter = new BufferedWriter(new FileWriter(PATH_BASICO + path + EXTENSAO, true));

		// recebo os dados do usuário
		System.out.println("Insira a informação desejada: ");
		input = sc.nextLine();

		// coloco o que eu recebi no arquivo
		buffWriter.append(input + "\n");

		// fechar o scan e a permissao
		sc.close();
		buffWriter.close();
	}
	
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