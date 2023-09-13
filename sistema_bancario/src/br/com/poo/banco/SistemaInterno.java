package br.com.poo.banco;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.com.poo.banco.pessoas.Cliente;
import br.com.poo.banco.pessoas.Diretor;
import br.com.poo.banco.pessoas.Funcionarios;
import br.com.poo.banco.pessoas.Gerente;
import br.com.poo.banco.pessoas.Presidente;
import br.com.poo.banco.util.Util;
import br.com.poo.banco.io.LeituraEscrita;
import br.com.poo.banco.contas.ContaCorrente;
import br.com.poo.banco.contas.ContaPoupanca;

public class SistemaInterno {

	public static void main(String[] args) throws IOException {
//		//instanciar o metodo de leitura 
//		LeituraEscrita.leitor("BancoDados");
//				
//		//instanciar o metodo de escrita
//		LeituraEscrita.escritor("BancoDados");
//		
		// instancia o logger
		Logger logger = Util.setupLogger();
//		
//		// CONTAS
//		
		// Instancia conta 1
		ContaCorrente conta1 = new ContaCorrente("Corrente","123456-2", "123.456.789-12", 1500.00,"001", 500.0 );
		logger.log(Level.INFO, () -> "" + conta1.getSaldo());
//		conta1.setChequeEspecial(1000.0);
//		logger.log(Level.INFO, () -> "Conta 1: " + conta1.getSaldo());
//		conta1.sacar(100.0);
//		logger.log(Level.INFO, () -> "Conta 1: " + conta1.getSaldo());
		
		// Instancia conta corrente 1
		ContaCorrente cc1 = new ContaCorrente("Corrente","660800-2", "111.654.524-66", 500.00,"005", 700.0 );
		logger.log(Level.INFO, () -> "" + cc1.getSaldo());
//		cc1.sacar(1400);
//		cc1.sacar(200);
//		cc1.sacar(200);
//		cc1.depositar(500);
//		logger.log(Level.INFO, () -> "Conta Corrente 1: " + cc1.getSaldo());
//		cc1.sacar(1000);
//		cc1.sacar(400);
		cc1.Operacoes(100, null, 1);
		logger.log(Level.INFO, () -> "" + cc1.getSaldo());
		logger.log(Level.INFO, () -> "" + conta1.getSaldo()); //1600
//		
//		// Instancia conta poupanca 1
//		ContaPoupanca cp1 = new ContaPoupanca("Poupança", "123456-1", "123.456.789-11",30000.00,"001");
//		logger.log(Level.INFO, () -> "Conta Poucança 1: " + cp1.getSaldo());
//		cp1.calcularRendimento(1000.0,30);
//		
//		
//		// CLIENTES E FUNCIONARIOS
//		
//		// Instancia cliente 1 
//		Cliente cl1 = new Cliente("Cliente","Mariana Coutinho", "123.456.789-10", "101099-2",123);
//		logger.log(Level.INFO, cl1.getNome());
//		cl1.setNome("Icaro");
//		logger.log(Level.INFO, () -> "Cliente 1: " + cl1.getNome());
//		
//		// Instancia funcionario 1
//		//String cargo, String nome, String cpf, Double salario, Integer senha
//		Funcionarios funcionario1 = new Funcionarios("Gerente", "Mahyara", "123.456.789-11", 15000.00, 56693);
//		logger.log(Level.INFO, funcionario1.getNome());
//		funcionario1.setNome("Luciana");
//		logger.log(Level.INFO, () -> "Funcionario 1: " + funcionario1.getNome());
//		
//		// Instancia diretor 1
//		//String cargo, String nome, String cpf, Double salario, Integer senha
//		Diretor diretor1 = new Diretor("Diretor", "Icaro", "321.625.987-33", 30000.00, 11223);
//		logger.log(Level.INFO, () -> "Diretor 1: " + diretor1.getNome());
//				
//		// Instancia gerente 1
//		//String cargo, String nome, String cpf, Double salario, Integer senha, Integer numFuncionarios, String agencia
//		Gerente gerente1 = new Gerente("Gerente","Felps", "899.223.449-66",15000.00,12355, 10, "001");
//		logger.log(Level.INFO, () -> "Gerente 1: " + gerente1.getNome());
//		
//		// Instancia presidente 1
//		//String cargo, String nome, String cpf, Double salario, Integer senha, Integer numUnidades, String email
//		Presidente presidente1 = new Presidente("Presidente","Lu", "332.554.889-96", 250000.00, 93578, 15,"luBrand@banco.com");
//		logger.log(Level.INFO, () -> "Presidente 1: " + presidente1.getNome());
//		presidente1.setEmail("paloma2@banco.com");
//		
		
		
	}
		
}
