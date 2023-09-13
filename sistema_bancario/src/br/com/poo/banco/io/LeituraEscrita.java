package br.com.poo.banco.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
import br.com.poo.banco.pessoas.Pessoas;
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
					
				// map Pessoas //Cliente(String tipo, String nome, String cpf, Integer senha, String numConta)
				} else if (dados[0].equalsIgnoreCase(PessoaEnum.CLIENTE.getTipoPessoa())) {
					
					Cliente cl = new Cliente(dados[0], dados[1],dados[2],Integer.parseInt(dados[3]),dados[4]);
					Cliente.mapaPessoas.put(dados[2],cl);
				
				//String tipo, String nome, String cpf, Integer senha, Double salario ,Integer numFuncionarios, String agencia			
				} else if (dados[0].equalsIgnoreCase(PessoaEnum.GERENTE.getTipoPessoa())) {
						Gerente gr = new Gerente(dados[0], dados[1],dados[2],Integer.parseInt(dados[3]),
							Double.parseDouble(dados[4]), Integer.parseInt(dados[5]), dados[6]);
								Funcionarios.mapaPessoas.put(dados[2], gr);
								
				//String tipo, String nome, String cpf, Integer senha, Double salario						
				} else if (dados[0].equalsIgnoreCase(PessoaEnum.DIRETOR.getTipoPessoa())) {
					Diretor dr = new Diretor(dados[0], dados[1],dados[2],Integer.parseInt(dados[3]),Double.parseDouble(dados[4]));
					Funcionarios.mapaPessoas.put(dados[2], dr);
					
				//String tipo, String nome, String cpf, Integer senha, Double salario, Integer numUnidades	
				} else if (dados[0].equalsIgnoreCase(PessoaEnum.PRESIDENTE.getTipoPessoa())) {
					Presidente pr = new Presidente(dados[0], dados[1], dados[2],Integer.parseInt(dados[3]),Double.parseDouble(dados[4]), Integer.parseInt(dados[5]));
					Funcionarios.mapaPessoas.put(dados[2], pr);
				}

			} else {
				break;
			}
		}
//		System.out.println(Conta.mapaContas);
//		System.out.println(Pessoas.mapaPessoas);
		
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
	
}