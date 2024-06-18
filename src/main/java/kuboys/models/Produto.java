package kuboys.models;

import com.fasterxml.jackson.annotation.JsonProperty;
public abstract class Produto {
    @JsonProperty("nome")
    protected String nome;
    @JsonProperty("dimensoes")
    protected Dimensoes dimensoes;
    @JsonProperty("tratamentoTermico")
    protected boolean tratamentoTermico;

    public Produto() {
    }

    public Produto(String nome, Dimensoes dimensoes, boolean tratamentoTermico) {
        this.nome = nome;
        this.dimensoes = dimensoes;
        this.tratamentoTermico = tratamentoTermico;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Dimensoes getDimensoes() {
        return dimensoes;
    }

    public void setDimensoes(Dimensoes dimensoes) {
        this.dimensoes = dimensoes;
    }

    public boolean isTratamentoTermico() {
        return tratamentoTermico;
    }

    public void setTratamentoTermico(boolean tratamentoTermico) {
        this.tratamentoTermico = tratamentoTermico;
    }


}
