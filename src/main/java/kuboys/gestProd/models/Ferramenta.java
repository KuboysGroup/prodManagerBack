package kuboys.gestProd.models;

import kuboys.gestProd.enums.EnumTipoFerramenta;

public class Ferramenta extends Produto{

    private EnumTipoFerramenta tipoFerramenta;
    private Material composicao;
    private Material revestimento;
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
