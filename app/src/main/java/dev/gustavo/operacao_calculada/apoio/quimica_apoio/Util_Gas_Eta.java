package dev.gustavo.operacao_calculada.apoio.quimica_apoio;

public class Util_Gas_Eta {

    public void metodoEstatico() {}

    public static void metodoNaoEstatico() {}

    public static String mensagem() {

        return "Qualquer mensagem ...";
    }

    public static double preco() {

        return 9.99;
    }

    public static String calcularMelhorOpcao(double gasolina, double etanol) {

        // preço da gasolina: R$ 5,12
        // preço do etanol: 3,99

        // preço ideal = gasolina * 0,70 = R$ 3,548

        double precoIdeal = gasolina * 0.70;
        String mensagemDeRetorno;

        if (etanol <= precoIdeal) {

            mensagemDeRetorno = "Abastecer com Etanol";

        } else {

            mensagemDeRetorno = "Abastacer com Gasolina";
        }

        /* se o preço do etanol for igual ou menor que o preço ideal,
         melhor abastecer com etanol, caso contrário, a gasolina é mais vantagem.
        */

        return mensagemDeRetorno;
    }
}
