package br.com.poo.banco;

import java.util.logging.Level;
import java.util.logging.Logger;

import br.com.poo.banco.pessoas.Cliente;

public class SistemaInterno {

	public static void main(String[] args) {
		
		// instancia o logger
		Logger logger = Logger.getLogger(SistemaInterno.class.getName());
		
		// Instancia cliente 1
		Cliente cl1 = new Cliente("Cliente 1", "12345678910", 123);
		logger.log(Level.INFO, cl1.getNome());
		cl1.setNome("Icaro");
		logger.log(Level.INFO, cl1.getNome());
		
	}
	
	
}
