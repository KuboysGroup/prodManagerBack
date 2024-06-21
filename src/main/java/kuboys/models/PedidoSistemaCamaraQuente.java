package kuboys.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import kuboys.enums.EnumStatusPedido;

import java.util.List;

public class PedidoSistemaCamaraQuente extends Pedido{
    @JsonProperty("produtos")
    private List<SistemaCamaraQuente> produtos;

    public PedidoSistemaCamaraQuente() {
    }

    public PedidoSistemaCamaraQuente(Data dataEntrega, Data dataPedido, EnumStatusPedido status, List<SistemaCamaraQuente> produtos) {
        super(dataEntrega, dataPedido,status);
        this.produtos = produtos;
    }

    public List<SistemaCamaraQuente> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<SistemaCamaraQuente> produtos) {
        this.produtos = produtos;
    }
}
