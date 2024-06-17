package kuboys.gestProd.models;

import jakarta.persistence.*;
import kuboys.gestProd.enums.EnumStatusPedido;
import kuboys.gestProd.services.PedidoService;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Pedido implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    List<ProdutoPedido> produtos;
    String dataEntrega;
    String dataPedido;
    EnumStatusPedido status;

    public Pedido() {
        this.setId(0);
        this.setProdutos(new ArrayList<>());
        this.setDataEntrega("");
        this.setDataPedido("");
        this.setStatus(EnumStatusPedido.EM_ABERTO);
    }

    public Pedido(List<ProdutoPedido> produtos, Data dataEntrega, Data dataPedido, EnumStatusPedido status) {
        this.id = PedidoService.getProximoPedidoId();
        this.produtos = produtos;
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

    public List<ProdutoPedido> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<ProdutoPedido> produtos) {
        this.produtos = produtos;
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
