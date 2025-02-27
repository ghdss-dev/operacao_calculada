package dev.gustavo.operacao_calculada.model.fisica_model.carga_maxima;

public class Meio_Transporte_model extends Terrestre_model{

    private int id;
    private int ano;
    private String modelo;
    private double cargaMaxima;

    public Meio_Transporte_model(int id, int ano, String modelo, double cargaMaxima) {
        this.id = id;
        this.ano = ano;
        this.modelo = modelo;
        this.cargaMaxima = cargaMaxima;
    }

    public double calcularConsumo() {

        return (this.potencia * this.cargaMaxima) / 100;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public double getCargaMaxima() {
        return cargaMaxima;
    }

    public void setCargaMaxima(double cargaMaxima) {
        this.cargaMaxima = cargaMaxima;
    }
}
