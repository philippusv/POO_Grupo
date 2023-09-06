package br.com.poo.banco;

import java.util.logging.Level;
import java.util.logging.Logger;

import br.com.poo.banco.pessoas.Cliente;
import br.com.poo.banco.pessoas.Diretor;
import br.com.poo.banco.pessoas.Funcionarios;
import br.com.poo.banco.pessoas.Gerente;
import br.com.poo.banco.pessoas.Presidente;
import br.com.poo.banco.util.Util;
import br.com.poo.banco.contas.Conta;
import br.com.poo.banco.contas.ContaCorrente;
import br.com.poo.banco.contas.ContaPoupanca;

public class SistemaInterno {

	public static void main(String[] args) {
		
		// instancia o logger
		Logger logger = Util.setupLogger();
		
		// CONTAS
		
		// Instancia conta 1
		Conta conta1 = new Conta(123, "Icaro 1", 1500.00);
		logger.log(Level.INFO, () -> "" + conta1.getSaldo());
		conta1.setTitular("Cliente ");
		logger.log(Level.INFO, () -> "Conta 1: " + conta1.getSaldo());
		
		// Instancia conta corrente 1
		ContaCorrente cc1 = new ContaCorrente(123, "Icaro 2", 1500.00, 100.0);
		logger.log(Level.INFO, () -> "" + cc1.getSaldo());
		cc1.setTitular("CC 1");
		logger.log(Level.INFO, () -> "Conta Corrente 1: " + cc1.getSaldo());
		
		// Instancia conta poupanca 1
		ContaPoupanca cp1 = new ContaPoupanca(123, "Icaro", 1500.00, 2.0);
		logger.log(Level.INFO, () -> "Conta Poucança 1: " + cp1.getSaldo());
		
		
		// CLIENTES E FUNCIONARIOS
		
		// Instancia cliente 1
		Cliente cl1 = new Cliente("Cliente 1", "12345678910", 123);
		logger.log(Level.INFO, cl1.getNome());
		cl1.setNome("Icaro");
		logger.log(Level.INFO, () -> "Cliente 1: " + cl1.getNome());
		
		// Instancia funcionario 1
		Funcionarios funcionario1 = new Funcionarios("Mahyara", "12345678911", 1500.00);
		logger.log(Level.INFO, funcionario1.getNome());
		funcionario1.setNome("Luciana");
		logger.log(Level.INFO, () -> "Funcionario 1: " + funcionario1.getNome());
		
		// Instancia diretor 1
		Diretor diretor1 = new Diretor("Mahyara", "12345678911", 1500.00, "123");
		logger.log(Level.INFO, () -> "Diretor 1: " + diretor1.getNome());
		diretor1.setSenha("1234");
		
		// Instancia gerente 1
		Gerente gerente1 = new Gerente("Felps", "12345678922", 1500.00, "123", 5);
		logger.log(Level.INFO, () -> "Gerente 1: " + gerente1.getNome());
		gerente1.setSenha("1234");
		
		// Instancia presidente 1
		Presidente presidente1 = new Presidente("Paloma", "12345678933", "paloma@banco.com", 1500.00, 3);
		logger.log(Level.INFO, () -> "Presidente 1: " + presidente1.getNome());
		presidente1.setEmail("paloma2@banco.com");
	}
	
	
}
