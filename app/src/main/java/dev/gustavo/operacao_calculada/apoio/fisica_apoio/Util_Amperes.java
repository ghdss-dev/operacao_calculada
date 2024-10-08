package dev.gustavo.operacao_calculada.apoio.fisica_apoio;

public class Util_Amperes {

    public static boolean validarValores(double voltagem, double resistencia) {

        return voltagem > 0 && resistencia > 0;
    }

    public static String formatarResultado(double amperagem) {

        return String.format("%.2f A", amperagem);
    }
}
