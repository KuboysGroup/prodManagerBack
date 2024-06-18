package kuboys.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
public class ProdutoPedido implements Serializable {
    private static final long serialVersionUID = 6297965575116979234L;
    @JsonProperty("produto")
    private Produto produto;

    @JsonProperty("quantidade")
    private Integer quantidade;

    public ProdutoPedido(Produto produto, Integer quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
}
