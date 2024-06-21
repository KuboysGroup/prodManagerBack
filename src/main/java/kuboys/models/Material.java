package kuboys.models;

import com.fasterxml.jackson.annotation.JsonProperty;
public class Material {
    @JsonProperty("nome")
    private String nome;
    @JsonProperty("quantEstoque")
    private int quantEstoque;

    public Material() {
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
