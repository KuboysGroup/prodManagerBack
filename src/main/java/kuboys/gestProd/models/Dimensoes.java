package kuboys.gestProd.models;

import java.io.Serializable;

public class Dimensoes implements Serializable {

    private double altura;
    private double largura;
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
