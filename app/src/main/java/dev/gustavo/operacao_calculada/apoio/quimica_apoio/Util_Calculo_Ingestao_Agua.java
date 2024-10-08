package dev.gustavo.operacao_calculada.apoio.quimica_apoio;

public class Util_Calculo_Ingestao_Agua {

    public static double arredondar(double valor, int casasDecimais) {

        // Método para arredondar um número para uma quantidade específica de casas decimais
        double arredondado = Math.round(valor * Math.pow(10, casasDecimais)) / Math.pow(10, casasDecimais);
        return arredondado;
    }

    // Método para converter o peso de quilogramas para gramas
    public static double kgParaGramas(double pesoEmKg) {

        return pesoEmKg * 1000;
    }

    // Método para converter o peso de gramas para quilogramas
    public static double gramasParaKg(double pesoEmGramas) {

        return pesoEmGramas / 1000;
    }

}
