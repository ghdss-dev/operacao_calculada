package dev.gustavo.operacao_calculada.model.matematica_model;

import java.util.ArrayList;
import java.util.List;

public class Consumo_Medio_model {
    private List<Double> consumos;

    public Consumo_Medio_model() {
        consumos = new ArrayList<>();
    }

    // Método para adicionar um consumo
    public void addConsumo(double consumo) {
        consumos.add(consumo);
    }

    // Método para calcular a média de consumo
    public String getConsumoMedio() {
        if (consumos.size() == 0) {
            return "0.00";
        }
        double total = 0;
        for (double consumo : consumos) {
            total += consumo;
        }
        double media = total / consumos.size();

        // Formatar o valor da média com duas casas decimais
        return String.format("%.2f", media);
    }

    // Método para obter a lista de consumos
    public List<Double> getConsumos() {
        return consumos;
    }
}
