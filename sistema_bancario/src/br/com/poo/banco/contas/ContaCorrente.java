package br.com.poo.banco.contas;

public class ContaCorrente {
    private int numeroConta;
    private double saldo;
    private String titular;
 // Construtor

    public ContaCorrente() {
    }
    public ContaCorrente(int numeroConta, double saldoContaCorrente, String titular) {
        this.numeroConta = numeroConta;
        this.saldo = saldoContaCorrente;
        this.titular = titular;
    }

    // getter para o número da conta
    public int getNumeroConta() {
        return numeroConta;


    }
    // getter para o titular
    public String getTitular() {
        return titular;

    }

    // getter para o saldo
    public double getSaldo() {
        return saldo;
    }

    // Método setter para o número da conta
    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    // Método setter para o saldo
    public void setSaldo(double saldo) {
        this.saldo = saldo; 

    }

}