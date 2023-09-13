package br.com.poo.banco.enums;

public enum ContaEnum {
	// associo entre() o que eu posso chamar ele
	CORRENTE("Corrente", 1), POUPANCA("Poupança", 2);

	private String tipoConta;
	private int id;

	// Contrutor
	ContaEnum(String tipoConta, int id) {
		this.tipoConta = tipoConta;
		this.id = id;
	}

	// Aqui nos enums só se usa get (ele é uma contante não tem set)
	public String getTipoConta() {
		return tipoConta;
	}

	public int getId() {
		return id;
	}

}
