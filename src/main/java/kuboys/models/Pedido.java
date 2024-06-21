package kuboys.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import kuboys.enums.EnumStatusPedido;
import kuboys.services.PedidoService;

public abstract class Pedido {
    @JsonProperty("id")
    private Integer id;

    @JsonProperty("dataEntrega")
    private String dataEntrega;

    @JsonProperty("dataPedido")
    private String dataPedido;

    @JsonProperty("status")
    private EnumStatusPedido status;

    public Pedido() {
    }

    public Pedido(Data dataEntrega, Data dataPedido, EnumStatusPedido status) {
        this.id = PedidoService.getProximoPedidoId();
        this.dataEntrega = dataEntrega.toString();
        this.dataPedido = dataPedido.toString();
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(String dataEntrega) {
        this.dataEntrega = dataEntrega.toString();
    }

    public String getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(String dataPedido) {
        this.dataPedido = dataPedido.toString();
    }

    public EnumStatusPedido getStatus() {
        return status;
    }

    public void setStatus(EnumStatusPedido status) {
        this.status = status;
    }
}
