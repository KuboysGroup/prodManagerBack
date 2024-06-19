package kuboys.controllers;

import kuboys.models.*;
import kuboys.services.PedidoService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/pedidos")
public class PedidoController {

    // Molde

    @GET
    @Path("/molde")
    @Produces(MediaType.APPLICATION_JSON)
    public List<PedidoMoldes> getPedidosMoldes() {
        return PedidoService.obterListaPedidosMolde();
    }

    @GET
    @Path("/molde/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public PedidoMoldes getPedidoMoldeById(@PathParam("id") Integer id) {
        return PedidoService.getPedidoMoldeById(id);
    }

    @PUT
    @Path("/molde/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public PedidoMoldes updatePedidoMolde(@PathParam("id") Integer id, PedidoMoldes pedidoDetails) {
        PedidoMoldes pedido = PedidoService.getPedidoMoldeById(id);
        pedido.setProdutos(pedidoDetails.getProdutos());
        pedido.setDataPedido(pedidoDetails.getDataPedido());
        pedido.setStatus(pedidoDetails.getStatus());

        PedidoService.pedidosMoldeMap.put(id, pedido);
        return pedido;
    }

    // Ferramenta

    @GET
    @Path("/ferramenta")
    @Produces(MediaType.APPLICATION_JSON)
    public List<PedidoFerramentas> getPedidosFerramentas() {
        return PedidoService.obterListaPedidosFerramentas();
    }

    @GET
    @Path("/ferramenta/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public PedidoFerramentas getPedidoFerramentaById(@PathParam("id") Integer id) {
        return PedidoService.getPedidoFerramentasById(id);
    }

    @PUT
    @Path("/ferramenta/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public PedidoFerramentas updatePedidoFerramenta(@PathParam("id") Integer id, PedidoFerramentas pedidoDetails) {
        PedidoFerramentas pedido = PedidoService.getPedidoFerramentasById(id);
        pedido.setProdutos(pedidoDetails.getProdutos());
        pedido.setDataPedido(pedidoDetails.getDataPedido());
        pedido.setStatus(pedidoDetails.getStatus());

        PedidoService.pedidosFerramentasMap.put(id, pedido);
        return pedido;
    }

    // Sistema Câmara Quente

    @GET
    @Path("/sistema")
    @Produces(MediaType.APPLICATION_JSON)
    public List<PedidoSistemaCamaraQuente> getPedidosSistemas() {
        return PedidoService.obterListaPedidosSistemaCamaraQuente();
    }

    @GET
    @Path("/sistema/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public PedidoSistemaCamaraQuente getPedidoSistemaById(@PathParam("id") Integer id) {
        return PedidoService.getPedidoSistemaCamaraQuenteById(id);
    }

    @PUT
    @Path("/sistema/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public PedidoSistemaCamaraQuente updatePedidoSistema(@PathParam("id") Integer id, PedidoSistemaCamaraQuente pedidoDetails) {
        PedidoSistemaCamaraQuente pedido = PedidoService.getPedidoSistemaCamaraQuenteById(id);
        pedido.setProdutos(pedidoDetails.getProdutos());
        pedido.setDataPedido(pedidoDetails.getDataPedido());
        pedido.setStatus(pedidoDetails.getStatus());

        PedidoService.pedidosSistemaCamaraQuenteMap.put(id, pedido);
        return pedido;
    }


    @GET
    @Path("/teste")
    @Produces(MediaType.APPLICATION_JSON)
    public String gerarPedTestes() {
        return PedidoService.gerarTesteComRetorno();
    }



//    @POST
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    public Pedido createPedido(Pedido pedido) {
//        pedido.setId(PedidoService.getProximoPedidoId());
//        PedidoService.pedidosMap.put(pedido.getId(), pedido);
//        return pedido;
//    }
//

//
//    @DELETE
//    @Path("/{id}")
//    public void deletePedido(@PathParam("id") Integer id) {
//        Pedido pedido = PedidoService.getPedidoById(id);
//        PedidoService.pedidosMap.remove(id);
//    }
//
//    @POST
//    @Path("/{pedidoId}/produtos")
//    @Consumes(MediaType.APPLICATION_JSON)
//    public void adicionarProdutoPedido(@PathParam("pedidoId") Integer pedidoId, Produto produto, @QueryParam("quantidade") int quantidade) {
//        PedidoService.adicionarProdutoPedido(pedidoId, produto, quantidade);
//    }
//
//    @DELETE
//    @Path("/{pedidoId}/produtos")
//    public void removerProdutoPedido(@PathParam("pedidoId") Integer pedidoId, @QueryParam("nomeProduto") String nomeProduto) {
//        PedidoService.removerProdutoPedido(pedidoId, nomeProduto);
//    }
}
