package br.com.poo.banco.contas;

public interface IConta {
	
	public void sacar(double valor);
	public void transferir(double valor, Conta destino);
	
	
}
