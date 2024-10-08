package dev.gustavo.operacao_calculada.model.matematica_model;

import dev.gustavo.operacao_calculada.apoio.matematica_apoio.Util_Imc;

public class Imc_model {

    private int peso;
    private double altura;
    private double imc;
    public Imc_model(int peso, double altura) {

        this.peso = peso;
        this.altura = altura;
        calcularImc();
    }

    private void calcularImc() {

        this.imc = Util_Imc.calcularImc(peso, altura);
    }

    public double getImc() {

        return imc;
    }

    public String getMensagem() {

        return Util_Imc.verificarFaixaDePeso(imc);
    }
}
