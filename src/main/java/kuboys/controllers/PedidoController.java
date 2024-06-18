package kuboys.controllers;

import kuboys.models.Pedido;
import kuboys.models.Produto;
import kuboys.services.PedidoService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/pedidos")
public class PedidoController {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Pedido> getAllPedidos() {
        return PedidoService.obterListaPedidos();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Pedido getPedidoById(@PathParam("id") Integer id) {
        return PedidoService.getPedidoById(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Pedido createPedido(Pedido pedido) {
        pedido.setId(PedidoService.getProximoPedidoId());
        PedidoService.pedidosMap.put(pedido.getId(), pedido);
        PedidoService.salvarDados();
        return pedido;
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Pedido updatePedido(@PathParam("id") Integer id, Pedido pedidoDetails) {
        Pedido pedido = PedidoService.getPedidoById(id);

        pedido.setProdutos(pedidoDetails.getProdutos());
        pedido.setDataPedido(pedidoDetails.getDataPedido());
        pedido.setStatus(pedidoDetails.getStatus());

        PedidoService.pedidosMap.put(id, pedido);
        PedidoService.salvarDados();

        return pedido;
    }

    @DELETE
    @Path("/{id}")
    public void deletePedido(@PathParam("id") Integer id) {
        Pedido pedido = PedidoService.getPedidoById(id);
        PedidoService.pedidosMap.remove(id);
        PedidoService.salvarDados();
    }

    @POST
    @Path("/{pedidoId}/produtos")
    @Consumes(MediaType.APPLICATION_JSON)
    public void adicionarProdutoPedido(@PathParam("pedidoId") Integer pedidoId, Produto produto, @QueryParam("quantidade") int quantidade) {
        PedidoService.adicionarProdutoPedido(pedidoId, produto, quantidade);
        PedidoService.salvarDados();
    }

    @DELETE
    @Path("/{pedidoId}/produtos")
    public void removerProdutoPedido(@PathParam("pedidoId") Integer pedidoId, @QueryParam("nomeProduto") String nomeProduto) {
        PedidoService.removerProdutoPedido(pedidoId, nomeProduto);
        PedidoService.salvarDados();
    }
}
