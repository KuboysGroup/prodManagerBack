package kuboys.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;

public class Componente {
    @JsonProperty("nome")
    private String nome;
    @JsonProperty("composicao")
    private List<Material> composicao;
    @JsonProperty("quantEstoque")
    private int quantEstoque;

    public Componente() {
    }

    public Componente(String nome, List<Material> composicao, int quantEstoque) {
        this.nome = nome;
        this.composicao = composicao;
        this.quantEstoque = quantEstoque;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Material> getComposicao() {
        return composicao;
    }

    public void setComposicao(List<Material> composicao) {
        this.composicao = composicao;
    }

    public int getQuantEstoque() {
        return quantEstoque;
    }

    public void setQuantEstoque(int quantEstoque) {
        this.quantEstoque = quantEstoque;
    }
}
