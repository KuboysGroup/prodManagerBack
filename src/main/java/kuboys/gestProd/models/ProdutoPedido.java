package kuboys.gestProd.models;

import jakarta.persistence.Entity;

import java.io.Serializable;
public class ProdutoPedido implements Serializable {
    Produto produto;
    Integer quantidade;

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
