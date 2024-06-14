package kuboys.gestProd.models;

import java.io.Serializable;

public class Material implements Serializable {

    private String nome;
    private int quantEstoque;

    public Material() {
        this.nome = "";
        this.quantEstoque = 0;
    }

    public Material(String nome, int quantEstoque) {
        this.nome = nome;
        this.quantEstoque = quantEstoque;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantEstoque() {
        return quantEstoque;
    }

    public void setQuantEstoque(int quantEstoque) {
        this.quantEstoque = quantEstoque;
    }
}
