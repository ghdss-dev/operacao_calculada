package dev.gustavo.operacao_calculada.apoio.matematica_apoio;

import java.text.DecimalFormat;

public class Util_Bitcoin {

    public static String formatarValor(double valor) {

        DecimalFormat decimalFormat = new DecimalFormat("0.00000");
        return decimalFormat.format(valor);
    }

    public static boolean isValorValido(String valor) {

        try {

            Double.parseDouble(valor.replace("," , "."));
            return true;

        } catch (NumberFormatException e) {

            return false;
        }
    }
}
