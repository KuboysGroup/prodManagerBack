package kuboys.gestProd;

import kuboys.gestProd.services.PedidoService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PedidoApplication {

    public static void main(String[] args) {
        PedidoService.gerarRegistrosDeTeste();
        //PedidoService.carregarDados();
        SpringApplication.run(PedidoApplication.class, args);
    }
}
