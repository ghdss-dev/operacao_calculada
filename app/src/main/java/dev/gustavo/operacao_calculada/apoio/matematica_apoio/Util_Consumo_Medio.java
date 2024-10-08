package dev.gustavo.operacao_calculada.apoio.matematica_apoio;

import java.util.ArrayList;

public class Util_Consumo_Medio {

    private ArrayList<Double> consumos = new ArrayList<>();

    // Adiciona o consumo á lista
    public void addConsumo(double consumo) {

        consumos.add(consumo);
    }

    // Retorna a média dos consumos
    public double calcularMedia() {

        double total = 0;

        for (double consumo : consumos) {

            total += consumo;
        }

        return consumos.size() > 0 ? total / consumos.size() : 0;
    }

    // Retorna o número de registros
    public int getNumeroDeRegistros() {

        return consumos.size();
    }

    public ArrayList<Double> getConsumos() {

        return consumos;
    }
}
