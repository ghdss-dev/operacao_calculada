package dev.gustavo.operacao_calculada.model.matematica_model;

import dev.gustavo.operacao_calculada.apoio.matematica_apoio.Util_Juros_Compostos;
public class Juros_Compostos_model {

    private double valor_inicial;
    private double taxas_juros;

    private double tempo_rendimento;

    public Juros_Compostos_model(double valor_inicial, double taxas_juros, double tempo_rendimento) {

        this.valor_inicial = valor_inicial;
        this.taxas_juros = taxas_juros;
        this.tempo_rendimento = tempo_rendimento;
    }

    public double getCalculoGeralJurosCompostos() {

        return Util_Juros_Compostos.CalculoTotal(valor_inicial, taxas_juros, tempo_rendimento);
    }

}
