package br.com.poo.banco.contas;

import java.io.IOException;

public interface IConta {
	
	public void sacar(double valor) throws IOException;
	public void transferir(double valor, Conta destino) throws IOException;
	
}
