package br.com.poo.banco.util;

public class SeguroVida {
    private double valorSegurado;
    private double tributo;

    public SeguroVida(double valorSegurado) {
        this.valorSegurado = valorSegurado;
        calcularTributo();
    }

    public double getValorSegurado() {
        return valorSegurado;
    }

    public double getTributo() {
        return tributo;
    }

    private void calcularTributo() {
        // Calcula 20% do valor segurado
        this.tributo = valorSegurado * 0.2;
    }
}
