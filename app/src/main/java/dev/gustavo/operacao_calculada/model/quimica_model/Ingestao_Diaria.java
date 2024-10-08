package dev.gustavo.operacao_calculada.model.quimica_model;

public class Ingestao_Diaria {

    private static final double ML_JOVEM = 40.0;
    private static final double ML_ADULTO = 35.0;
    private static final double ML_IDOSO = 30.0;
    private static final double ML_MAIS_DE_66_ANOS = 25.0;
    private double resultadoML = 0.0;
    private double resultadoTotalMl = 0.0;

    public void calcularTotalMl(double peso, int idade) {

        if (idade <= 17) {

            resultadoML = peso * ML_JOVEM;
            resultadoTotalMl = resultadoML;

        } else if (idade <= 55) {

            resultadoML = peso * ML_ADULTO;
            resultadoTotalMl = resultadoML;

        } else if (idade <= 65) {

            resultadoML = peso * ML_IDOSO;
            resultadoTotalMl = resultadoML;

        } else {

            resultadoML = peso * ML_MAIS_DE_66_ANOS;
            resultadoTotalMl = resultadoML;

        }
    }
    public double getResultadoMl() {

        return resultadoTotalMl;

    }
}
