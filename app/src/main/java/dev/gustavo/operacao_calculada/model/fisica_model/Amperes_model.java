package dev.gustavo.operacao_calculada.model.fisica_model;

public class Amperes_model {

    private double voltagem;
    private double resistencia;
    private double amperagem;

    public Amperes_model(double voltagem, double resistencia) {

        this.voltagem = voltagem;
        this.resistencia = resistencia;
        this.amperagem = calcularAmperagem();
    }

    public double getAmperagem() {
        return amperagem;
    }

    public void setAmperagem(double amperagem) {
        this.amperagem = amperagem;
    }

    public double getResistencia() {
        return resistencia;
    }

    public void setResistencia(double resistencia) {
        this.resistencia = resistencia;
        this.amperagem = calcularAmperagem();
    }

    public double getVoltagem() {
        return voltagem;
    }

    public void setVoltagem(double voltagem) {
        this.voltagem = voltagem;
        this.amperagem = calcularAmperagem();
    }

    private double calcularAmperagem() {

        if (resistencia != 0) {

            return voltagem / resistencia;

        } else {

            return 0;
        }
    }
}
