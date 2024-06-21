package kuboys.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import kuboys.enums.EnumStatusPedido;

import java.util.List;

public class PedidoMoldes extends Pedido{

    @JsonProperty("produtos")
    private List<Molde> produtos;

    public PedidoMoldes() {
    }

    public PedidoMoldes(Data dataEntrega, Data dataPedido, EnumStatusPedido status, List<Molde> produtos) {
        super(dataEntrega, dataPedido,status);
        this.produtos = produtos;
    }

    public List<Molde> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Molde> produtos) {
        this.produtos = produtos;
    }

}
