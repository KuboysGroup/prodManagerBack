package kuboys.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Componente  implements Serializable {

    private String nome;
    private List<Material> composicao;
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
