package kuboys.gestProd.controllers;

import kuboys.gestProd.services.PedidoService;
import kuboys.gestProd.models.Pedido;
import kuboys.gestProd.models.Produto;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    @GetMapping
    public List<Pedido> getAllPedidos() {
        return PedidoService.obterListaPedidos();
    }

    @GetMapping("/{id}")
    public Pedido getPedidoById(@PathVariable Integer id) {
        return PedidoService.getPedidoById(id);
    }

    @PostMapping
    public Pedido createPedido(@RequestBody Pedido pedido) {
        pedido.setId(PedidoService.getProximoPedidoId());
        PedidoService.pedidosMap.put(pedido.getId(), pedido);
        PedidoService.salvarDados();
        return pedido;
    }

    @PutMapping("/{id}")
    public Pedido updatePedido(@PathVariable Integer id, @RequestBody Pedido pedidoDetails) {
        Pedido pedido = PedidoService.getPedidoById(id);

        pedido.setProdutos(pedidoDetails.getProdutos());
        pedido.setDataPedido(pedidoDetails.getDataPedido());
        pedido.setStatus(pedidoDetails.getStatus());

        PedidoService.pedidosMap.put(id, pedido);
        PedidoService.salvarDados();

        return pedido;
    }

    @DeleteMapping("/{id}")
    public void deletePedido(@PathVariable Integer id) {
        Pedido pedido = PedidoService.getPedidoById(id);
        PedidoService.pedidosMap.remove(id);
        PedidoService.salvarDados();
    }

    @PostMapping("/{pedidoId}/produtos")
    public void adicionarProdutoPedido(@PathVariable Integer pedidoId, @RequestBody Produto produto, @RequestParam int quantidade) {
        PedidoService.adicionarProdutoPedido(pedidoId, produto, quantidade);
        PedidoService.salvarDados();
    }

    @DeleteMapping("/{pedidoId}/produtos")
    public void removerProdutoPedido(@PathVariable Integer pedidoId, @RequestParam String nomeProduto) {
        PedidoService.removerProdutoPedido(pedidoId, nomeProduto);
        PedidoService.salvarDados();
    }
}
