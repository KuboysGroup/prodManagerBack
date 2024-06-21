package kuboys.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import kuboys.enums.EnumStatusPedido;

import java.util.List;

public class PedidoFerramentas extends Pedido{
    @JsonProperty("produtos")
    private List<Ferramenta> produtos;

    public PedidoFerramentas() {
    }

    public PedidoFerramentas(Data dataEntrega, Data dataPedido, EnumStatusPedido status, List<Ferramenta> produtos) {
        super(dataEntrega, dataPedido,status);
        this.produtos = produtos;
    }

    public List<Ferramenta> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Ferramenta> produtos) {
        this.produtos = produtos;
    }

}
