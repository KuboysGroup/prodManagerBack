package kuboys.gestProd.controllers;

import kuboys.gestProd.models.pedidoService;
import kuboys.gestProd.models.Pedido;
import kuboys.gestProd.models.Produto;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    @GetMapping
    public List<Pedido> getAllPedidos() {
        return pedidoService.obterListaPedidos();
    }

    @GetMapping("/{id}")
    public Pedido getPedidoById(@PathVariable Integer id) {
        return pedidoService.getPedidoById(id);
    }

    @PostMapping
    public Pedido createPedido(@RequestBody Pedido pedido) {
        pedido.setId(pedidoService.getProximoPedidoId());
        pedidoService.pedidosMap.put(pedido.getId(), pedido);
        pedidoService.salvarDados();
        return pedido;
    }

    @PutMapping("/{id}")
    public Pedido updatePedido(@PathVariable Integer id, @RequestBody Pedido pedidoDetails) {
        Pedido pedido = pedidoService.getPedidoById(id);

        pedido.setProdutos(pedidoDetails.getProdutos());
        pedido.setDataPedido(pedidoDetails.getDataPedido());
        pedido.setStatus(pedidoDetails.getStatus());

        pedidoService.pedidosMap.put(id, pedido);
        pedidoService.salvarDados();

        return pedido;
    }

    @DeleteMapping("/{id}")
    public void deletePedido(@PathVariable Integer id) {
        Pedido pedido = pedidoService.getPedidoById(id);
        pedidoService.pedidosMap.remove(id);
        pedidoService.salvarDados();
    }

    @PostMapping("/{pedidoId}/produtos")
    public void adicionarProdutoPedido(@PathVariable Integer pedidoId, @RequestBody Produto produto, @RequestParam int quantidade) {
        pedidoService.adicionarProdutoPedido(pedidoId, produto, quantidade);
        pedidoService.salvarDados();
    }

    @DeleteMapping("/{pedidoId}/produtos")
    public void removerProdutoPedido(@PathVariable Integer pedidoId, @RequestParam String nomeProduto) {
        pedidoService.removerProdutoPedido(pedidoId, nomeProduto);
        pedidoService.salvarDados();
    }
}
