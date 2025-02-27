package dev.gustavo.operacao_calculada.model.matematica_model;

public class Bitcoin_model {

    private double cotacaoAtual;
    private double valorEmReais;

    public Bitcoin_model(double cotacaoAtual, double valorEmReais) {

        this.cotacaoAtual = cotacaoAtual;
        this.valorEmReais = valorEmReais;

    }

    public double calcularBitcoin() {

        if (cotacaoAtual > 0) {

            return valorEmReais / cotacaoAtual;
        }

        return 0.0;
    }

    public double getCotacaoAtual() {

        return cotacaoAtual;
    }

    public void setCotacaoAtual(double cotacaoAtual) {

        this.cotacaoAtual = cotacaoAtual;
    }

    public double getValorEmReais() {

        return valorEmReais;
    }

    public void setValorEmReais(double valorEmReais) {

        this.valorEmReais = valorEmReais;
    }
}
