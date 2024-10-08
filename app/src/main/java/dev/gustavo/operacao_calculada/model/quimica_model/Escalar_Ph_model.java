package dev.gustavo.operacao_calculada.model.quimica_model;

public class Escalar_Ph_model {

    private String descricao;
    private int imgTuboResource;
    private int imgSResource;

    public Escalar_Ph_model(String descricao, int imgTuboResource, int imgSResource) {

        this.descricao = descricao;
        this.imgTuboResource = imgTuboResource;
        this.imgSResource = imgSResource;
    }

    public String getDescricao() {

        return descricao;
    }

    public int getImgTuboResource() {

        return imgTuboResource;
    }

    public int getImgSResource() {

        return imgSResource;
    }
}
