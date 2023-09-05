package br.com.poo.banco.contas;

public class ContaPoupanca{

     private int numeroCP;
     private String nomeTitularCP;
     private double saldoCP;


     public ContaPoupanca() {
        }

     public ContaPoupanca(int numeroCP, String nomeTitularCP, double saldoCP) {
            this.numeroCP = numeroCP;
            this.nomeTitularCP = nomeTitularCP;
            this.saldoCP = saldoCP;
        }


    public double getSaldo() {
            return saldoCP;
        }


    @Override
        public String toString() {
            return "Conta Poupança: " + numeroCP + "\nNome do titular da Conta Poupança: " + nomeTitularCP + "\nSaldo da Conta Poupança: " + saldoCP;
        }

}