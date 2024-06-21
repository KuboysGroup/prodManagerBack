package kuboys.controllers;

import kuboys.models.Componente;
import kuboys.models.Material;
import kuboys.services.PedidoService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/componentes")
public class ComponentesController {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Componente> getComponentes(){
        return PedidoService.obterListaComponentes();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void atualizarComponentes(List<Componente> componenteList){
        PedidoService.componentsList = componenteList;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void createComponente(Componente componente) {
        PedidoService.componentsList.add(componente);
    }
}
