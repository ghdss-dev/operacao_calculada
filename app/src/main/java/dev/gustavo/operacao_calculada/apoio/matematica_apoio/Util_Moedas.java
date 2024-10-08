package dev.gustavo.operacao_calculada.apoio.matematica_apoio;

import dev.gustavo.operacao_calculada.model.matematica_model.Moedas_model;

public class Util_Moedas {

    private Moedas_model moedas;

    public Util_Moedas(Moedas_model moedas) {

        this.moedas = moedas;
    }

    public double converterRealParaDolar(double valorReal) {
        return valorReal / moedas.getDolar();
    }

    public double converterRealParaEuro(double valorReal) {

        return valorReal / moedas.getEuro();
    }
}
