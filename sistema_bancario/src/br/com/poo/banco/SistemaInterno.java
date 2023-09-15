package br.com.poo.banco;

import java.awt.List;
import java.io.IOException;
import java.util.logging.Logger;

import br.com.poo.banco.contas.Conta;
import br.com.poo.banco.contas.ContaCorrente;
import br.com.poo.banco.contas.ContaPoupanca;
import br.com.poo.banco.io.LeituraEscrita;
import br.com.poo.banco.io.RelatorioCliente;
import br.com.poo.banco.pessoas.Pessoas;
import br.com.poo.banco.util.Util;
import br.com.poo.banco.views.JCadastroConta;
import br.com.poo.banco.views.JLogin;

public class SistemaInterno {

	public static void main(String[] args) throws IOException {

		// instanciar o metodo de leitura
		LeituraEscrita.leitor("BancoDados");
		System.out.println(Conta.mapaContas.get("555.444.333-22"));
		// List<Conta> contas = Conta.mapaContas.get("555.444.333-22");

		
		/*
		  Como acessar contas com o mesmo cpf??
		  Como o mapa recebe um List<Conta>, podemos iterar sobre 
		  a lista de contas associadas a um cpf e verificar o tipo de cada conta.
		  Assim podemos escolher qual conta queremos acessar.
		*/
		
		for (Conta conta : Conta.mapaContas.get("555.444.333-22")) {
			if (conta.getTipoConta().equalsIgnoreCase("CORRENTE")) {
				System.out.println("CORRENTE --> " + conta);
			}else {
				System.out.println("POUPANÇA--> " + conta);
			}
		}
		
		// System.out.println(Pessoas.mapaPessoas.get("174.129.881-12"));

//		// Chamada do login
//		JLogin jl = new JLogin();
//		jl.setLocationRelativeTo(jl);
//		jl.setVisible(true);
//		
		// Chamada do cadastro de cliente
		JCadastroConta cc = new JCadastroConta();
		cc.setLocationRelativeTo(cc);
		cc.setVisible(true);

		// instancia o logger
		Logger logger = Util.setupLogger();
//
//		// CONTAS
//
//		// Instancia conta 1
		ContaCorrente conta1 = new ContaCorrente("Corrente", "123456-2", "123.456.789-12", 1500.00, "001", 500.0);
//		logger.log(Level.INFO, () -> "" + conta1.getSaldo());
//		conta1.setChequeEspecial(1000.0);
//		logger.log(Level.INFO, () -> "Conta 1: " + conta1.getSaldo());
//		conta1.sacar(100.0);
//		logger.log(Level.INFO, () -> "Conta 1: " + conta1.getSaldo());

		// Instancia conta corrente 1
//		ContaCorrente cc1 = new ContaCorrente("Corrente", "660800-2", "111.654.524-66", 1000.00, "005", 700.0);
//		// TESTE RELATÓRIOS CLIENTE
//		RelatorioCliente.comprovanteSaque(cc1, 100.00);
//		RelatorioCliente.comprovanteTransferencia(cc1, 200.00, conta1);
//		RelatorioCliente.tributacaoCC(cc1, 1, 1, 2);
//		RelatorioCliente.comprovanteDeposito(cc1, 200.00);

//		logger.log(Level.INFO, () -> "" + cc1.getSaldo());
//		logger.log(Level.INFO, () -> "Conta Corrente 1: " + cc1.getSaldo());
//		cc1.Operacoes(100, null, 1);
//		logger.log(Level.INFO, () -> "" + cc1.getSaldo());
//		logger.log(Level.INFO, () -> "" + conta1.getSaldo());
//
//		// Instancia conta poupanca 1
//		ContaPoupanca cp1 = new ContaPoupanca("Poupança", "123456-1", "123.456.789-11", 30000.00, "001");
//		// TESTE RELATÓRIOS CLIENTE
//		RelatorioCliente.comprovanteSaque(cp1, 100.00);
//		RelatorioCliente.rendimentoCP(cp1, 1000.00, 30);
//		RelatorioCliente.saldo(cp1);
//		cp1.sacar(20000.00);
//		RelatorioCliente.saldo(cp1);
//		logger.log(Level.INFO, () -> "Conta Poucança 1: " + cp1.getSaldo());
//		cp1.calcularRendimento(1000.0, 30);
//
//		// CLIENTES E FUNCIONARIOS
//
//		// Instancia cliente 1
//		// String tipo, String nome, String cpf, Integer senha, String numConta
//		Cliente cl1 = new Cliente("Cliente", "Mariana Coutinho", "123.456.789-10", 12389, "101099-2");
//		logger.log(Level.INFO, cl1.getNome());
//		cl1.setNome("Icaro");
//		logger.log(Level.INFO, () -> "Cliente 1: " + cl1.getNome());
//
//		// Instancia funcionario 1
//		// String tipo, String nome, String cpf, Integer senha, Double salario
//		Funcionarios funcionario1 = new Funcionarios("Gerente", "Mahyara", "123.456.789-11", 56693, 15000.00);
//		logger.log(Level.INFO, funcionario1.getNome());
//		funcionario1.setNome("Luciana");
//		logger.log(Level.INFO, () -> "Funcionario 1: " + funcionario1.getNome());
//
//		// Instancia diretor 1
//		// String tipo, String nome, String cpf, Integer senha, Double salario
//		Diretor diretor1 = new Diretor("Diretor", "Icaro", "321.625.987-33", 11223, 30000.00);
//		logger.log(Level.INFO, () -> "Diretor 1: " + diretor1.getNome());
//
//		// Instancia gerente 1
//		// String tipo, String nome, String cpf, Integer senha, Double salario
//		// ,Integer numFuncionarios, String agencia
//		Gerente gerente1 = new Gerente("Gerente", "Felps", "899.223.449-66", 11223, 40000.00, 10, "003");
//		logger.log(Level.INFO, () -> "Gerente 1: " + gerente1.getNome());
//
//		// Instancia presidente 1
//
//		Presidente presidente1 = new Presidente("Presidente", "Lu", "332.554.889-96", 93578, 250000.00, 15);
//		logger.log(Level.INFO, () -> "Presidente 1: " + presidente1.getNome());

	}

}
