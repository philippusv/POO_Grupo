package br.com.poo.banco;
import java.io.IOException;
import br.com.poo.banco.io.LeituraEscrita;
import br.com.poo.banco.views.JLogin;

public class SistemaInterno {

	public static void main(String[] args) throws IOException {

		// instanciar o metodo de leitura
		LeituraEscrita.leitor("BancoDados");
		
		/*
		  Como acessar contas com o mesmo cpf??
		  Como o mapa recebe um List<Conta>, podemos iterar sobre 
		  a lista de contas associadas a um cpf e verificar o tipo de cada conta.
		  Assim podemos escolher qual conta queremos acessar.
		*/

		// Chamada do login
		JLogin jl = new JLogin();
		jl.setLocationRelativeTo(jl);
		jl.setVisible(true);

	}

}
