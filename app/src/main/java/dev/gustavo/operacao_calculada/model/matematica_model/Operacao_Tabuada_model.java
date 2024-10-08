package dev.gustavo.operacao_calculada.model.matematica_model;

public class Operacao_Tabuada_model {

    public static String calcularTabuada(int numero) {

        StringBuilder resultado = new StringBuilder();

        for (int i = 1; i <= 100; i++) {

            resultado.append(numero).append(" * ").append(i).append(" = ").append(numero * i).append("\n");
        }

        return  resultado.toString();
    }

}
