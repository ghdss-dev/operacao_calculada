package dev.gustavo.operacao_calculada.model.matematica_model;

public class Moedas_model {
    private double dolar;
    private double euro;

    public Moedas_model(double dolar, double euro) {
        this.dolar = dolar;
        this.euro = euro;
    }

    public double getDolar() {
        return dolar;
    }

    public double getEuro() {
        return euro;
    }
}
