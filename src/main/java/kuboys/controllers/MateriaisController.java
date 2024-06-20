package kuboys.controllers;

import kuboys.models.Material;
import kuboys.services.PedidoService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/materiais")
public class MateriaisController {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Material> getMateriais(){
        return PedidoService.obterListaMateriais();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void atualizarMateriais(List<Material> materialList){
        PedidoService.materialList = materialList;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void createMaterial(Material material) {
        PedidoService.materialList.add(material);
    }

}
