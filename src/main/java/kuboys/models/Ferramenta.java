package kuboys.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import kuboys.enums.EnumTipoFerramenta;

public class Ferramenta extends Produto{
    private static final long serialVersionUID = 3989054360555057931L;
    @JsonProperty("tipoFerramenta")
    private EnumTipoFerramenta tipoFerramenta;
    @JsonProperty("composicao")
    private Material composicao;
    @JsonProperty("revestimento")
    private Material revestimento;
    @JsonProperty("finalidade")
    private String finalidade;

    public Ferramenta() {
        super();
        this.tipoFerramenta = null;
        this.composicao = new Material();
        this.revestimento = new Material();
        this.finalidade = "";
    }

    public Ferramenta(String nome, Dimensoes dimensoes, boolean tratamentoTermico, EnumTipoFerramenta tipoFerramenta, Material composicao, Material revestimento, String finalidade) {
        super(nome, dimensoes, tratamentoTermico);
        this.tipoFerramenta = tipoFerramenta;
        this.composicao = composicao;
        this.revestimento = revestimento;
        this.finalidade = finalidade;
    }

    public EnumTipoFerramenta getTipoFerramenta() {
        return tipoFerramenta;
    }

    public void setTipoFerramenta(EnumTipoFerramenta tipoFerramenta) {
        this.tipoFerramenta = tipoFerramenta;
    }

    public Material getComposicao() {
        return composicao;
    }

    public void setComposicao(Material composicao) {
        this.composicao = composicao;
    }

    public Material getRevestimento() {
        return revestimento;
    }

    public void setRevestimento(Material revestimento) {
        this.revestimento = revestimento;
    }

    public String getFinalidade() {
        return finalidade;
    }

    public void setFinalidade(String finalidade) {
        this.finalidade = finalidade;
    }
}
