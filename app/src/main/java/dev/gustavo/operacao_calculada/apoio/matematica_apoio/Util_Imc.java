package dev.gustavo.operacao_calculada.apoio.matematica_apoio;
public class Util_Imc {
    public static double calcularImc(int peso, double altura) {

        return peso / (altura * altura);
    }
    public static String verificarFaixaDePeso(double imc) {

        if (imc < 18.4) {

            return "Abaixo do Peso";

        } else if ((imc >= 18.5) && (imc <= 24.9)) {

            return "Peso Ideal (Parabéns !!!)";
        } else if ((imc >= 25.0) && (imc <= 29.9)) {

            return "Levemente Acima do Peso";
        } else if ((imc >= 30.0) && (imc <= 34.9)) {

            return "Obesidade Grau I";

        } else if ((imc >= 35.0) && (imc <= 39.9)) {

            return "Obesidade Grau II (Severa)";

        } else if (imc >= 40.0) {

            return "Obesidade Grau III (Mórbida)";

        } else {

            return "Faixa de peso não identificada";
        }
    }
}