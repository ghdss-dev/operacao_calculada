package dev.gustavo.operacao_calculada.apoio.fisica_apoio;

public class Util_Carga_Maxima_Consumo {

    public static double calcularConsumo(double potencia, double cargaMaxima) {

        return (potencia * cargaMaxima) / 100;
    }
}
