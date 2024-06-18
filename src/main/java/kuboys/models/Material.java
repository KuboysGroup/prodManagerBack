package kuboys.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class Material implements Serializable {
    private static final long serialVersionUID = -2271915122007278156L;
    @JsonProperty("nome")
    private String nome;
    @JsonProperty("quantEstoque")
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
