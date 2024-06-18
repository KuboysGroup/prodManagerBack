package kuboys.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Componente  implements Serializable {
    private static final long serialVersionUID = -8152177080706572554L;
    @JsonProperty("nome")
    private String nome;
    @JsonProperty("composicao")
    private List<Material> composicao;
    @JsonProperty("quantEstoque")
    private int quantEstoque;

    public Componente() {
        this.nome = "";
        this.composicao = new ArrayList<>();
        this.quantEstoque = 0;
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
