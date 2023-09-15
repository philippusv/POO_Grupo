package br.com.poo.banco.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import br.com.poo.banco.contas.Conta;
import br.com.poo.banco.contas.ContaCorrente;
import br.com.poo.banco.contas.ContaPoupanca;
import br.com.poo.banco.enums.ContaEnum;
import br.com.poo.banco.enums.PessoaEnum;
import br.com.poo.banco.pessoas.Cliente;
import br.com.poo.banco.pessoas.Diretor;
import br.com.poo.banco.pessoas.Gerente;
import br.com.poo.banco.pessoas.Pessoas;
import br.com.poo.banco.pessoas.Presidente;

public class LeituraEscrita {
	// constantes
	static final String PATH_BASICO = "./temp/";
	static final String EXTENSAO = ".txt";
	static int contador = 0;
	
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
				contador++;
				// sepadação da informação por ; e digo que as linhas são string
				String[] dados = linha.split(";");

				// equalsIgnoreCase é a mesma coisa que o == "1"--> usamos em comparação de
				// string
				if (dados[0].equalsIgnoreCase(ContaEnum.POUPANCA.name())) {

					// cria objeto
					ContaPoupanca cp = new ContaPoupanca(dados[0], dados[1], 
							dados[2], Double.parseDouble(dados[3]),dados[4]);
					
					// insere a conta poupanca nos mapas
					Conta.mapaContas.computeIfAbsent(dados[2], k -> new ArrayList<>()).add(cp);
					Conta.mapaNumContas.put(dados[1], cp);

				} else if (dados[0].equalsIgnoreCase(ContaEnum.CORRENTE.name())) {
					ContaCorrente cc = new ContaCorrente(dados[0], dados[1], 
							dados[2], Double.parseDouble(dados[3]),dados[4],
							Double.parseDouble(dados[5]));
					
					// insere a conta corrente no mapa
					Conta.mapaContas.computeIfAbsent(dados[2], k -> new ArrayList<>()).add(cc);
					Conta.mapaNumContas.put(dados[1], cc);
					
				// map Pessoas //Cliente(String tipo, String nome, String cpf, Integer senha, String numConta)
				} else if (dados[0].equalsIgnoreCase(PessoaEnum.CLIENTE.getTipoPessoa())) {
					Cliente cl = new Cliente(dados[0], dados[1],dados[2],Integer.parseInt(dados[3]),dados[4]);
					Pessoas.mapaPessoas.put(dados[2],cl);
				
				//String tipo, String nome, String cpf, Integer senha, Double salario ,Integer numFuncionarios, String agencia			
				} else if (dados[0].equalsIgnoreCase(PessoaEnum.GERENTE.getTipoPessoa())) {
					Gerente gr = new Gerente(dados[0], dados[1],dados[2],Integer.parseInt(dados[3]),
					Double.parseDouble(dados[4]), Integer.parseInt(dados[5]), dados[6]);
					Pessoas.mapaPessoas.put(dados[2], gr);
								
				//String tipo, String nome, String cpf, Integer senha, Double salario						
				} else if (dados[0].equalsIgnoreCase(PessoaEnum.DIRETOR.getTipoPessoa())) {
					Diretor dr = new Diretor(dados[0], dados[1],dados[2],Integer.parseInt(dados[3]),Double.parseDouble(dados[4]));
					Pessoas.mapaPessoas.put(dados[2], dr);
					
				//String tipo, String nome, String cpf, Integer senha, Double salario, Integer numUnidades	
				} else if (dados[0].equalsIgnoreCase(PessoaEnum.PRESIDENTE.getTipoPessoa())) {
					Presidente pr = new Presidente(dados[0], dados[1], dados[2],Integer.parseInt(dados[3]),Double.parseDouble(dados[4]), Integer.parseInt(dados[5]));
					Pessoas.mapaPessoas.put(dados[2], pr);
				}

			} else {
				break;
			}
		}
		
		// fechar o buff
		buffRead.close();
	}
public static void escritor(String path, String cliente, String conta) throws IOException {

		try (BufferedReader buffRead = new BufferedReader(new FileReader(PATH_BASICO+path+EXTENSAO))) {
			String dado = "";
			
			for(int i = 0; i < contador+1; i++) {
				dado = buffRead.readLine();
				if(dado == null) {
					try (BufferedWriter buffWriter = 
							new BufferedWriter(new FileWriter(PATH_BASICO+path+EXTENSAO,true))) {
						buffWriter.append(cliente);
						buffWriter.append(conta);
					}
				}
			}
		}
	}
}