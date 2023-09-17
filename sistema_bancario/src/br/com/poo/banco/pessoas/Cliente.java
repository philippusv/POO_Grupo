package br.com.poo.banco.pessoas;

import java.io.IOException;

import br.com.poo.banco.contas.Conta;
import br.com.poo.banco.util.SeguroVida;

public class Cliente extends Pessoas{

	// atributos
	private String numConta;
	private SeguroVida seguroVida;
	
		
	// construtores
	
	public Cliente() {
		super();
	}
	
	public Cliente(String tipo, String nome, String cpf, Integer senha, String numConta) {
		super(tipo, nome, cpf, senha);
		this.numConta = numConta;
		
	}
	
	// getters
	public String getNumConta() {
		return numConta;
	}
	
	public SeguroVida getSeguroVida() {
		return seguroVida;
	}
	
	//DESAFIO - Seguro de vida
	public void contratarSeguroVida(double valorSegurado) throws IOException {
        for(Conta conta : Conta.mapaContas.get(this.getCpf())){
        	if(conta.getTipoConta().equalsIgnoreCase("Corrente")) {
        		this.seguroVida = new SeguroVida(valorSegurado);
        		conta.operacoes(this.calcularTributo(), null, 4);
        	}
        }
    }
	
	public double calcularTributo() {
        return seguroVida != null ? seguroVida.getTributo() : 0.0; 
    }
	
}
