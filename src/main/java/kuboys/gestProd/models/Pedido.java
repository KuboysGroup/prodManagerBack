package kuboys.gestProd.models;

import kuboys.gestProd.enums.EnumStatusPedido;
import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import static kuboys.gestProd.models.pedidoService.getProximoPedidoId;

@Entity
public class Pedido implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    List<ProdutoPedido> produtos;
    Data dataEntrega;
    Data dataPedido;
    EnumStatusPedido status;

    public Pedido() {
        this.setId(0);
        this.setProdutos(new ArrayList<>());
        this.setDataEntrega(Data.ZERO);
        this.setDataPedido(Data.ZERO);
        this.setStatus(EnumStatusPedido.EM_ABERTO);
    }

    public Pedido(List<ProdutoPedido> produtos, Data dataEntrega, Data dataPedido, EnumStatusPedido status) {
        this.id = getProximoPedidoId();
        this.produtos = produtos;
        this.dataEntrega = dataEntrega;
        this.dataPedido = dataPedido;
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

    public Data getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(Data dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public Data getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(Data dataPedido) {
        this.dataPedido = dataPedido;
    }

    public EnumStatusPedido getStatus() {
        return status;
    }

    public void setStatus(EnumStatusPedido status) {
        this.status = status;
    }
}
