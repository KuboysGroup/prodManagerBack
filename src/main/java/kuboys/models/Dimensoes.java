package kuboys.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class Dimensoes implements Serializable {
    private static final long serialVersionUID = 6345548402362546150L;
    @JsonProperty("altura")
    private double altura;
    @JsonProperty("largura")
    private double largura;
    @JsonProperty("profundidade")
    private double profundidade;

    public Dimensoes() {
        this.altura = 0.0;
        this.largura = 0.0;
        this.profundidade = 0.0;
    }

    public Dimensoes(double altura, double largura, double profundidade) {
        this.altura = altura;
        this.largura = largura;
        this.profundidade = profundidade;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getLargura() {
        return largura;
    }

    public void setLargura(double largura) {
        this.largura = largura;
    }

    public double getProfundidade() {
        return profundidade;
    }

    public void setProfundidade(double profundidade) {
        this.profundidade = profundidade;
    }
}
