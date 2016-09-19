package br.upis.ext.javaweb.loja.rest;

import br.upis.ext.javaweb.loja.dao.LojaDAO;
import br.upis.ext.javaweb.loja.model.Pedidos;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by franciscovneto on 03/09/16.
 */

@Path("/pedidos")
public class RestPedidos {

    @Inject
    LojaDAO dao;

    @GET
    @Path("/")
    @Produces("application/json")
    public Response todosPedidos() {

        List<Pedidos> pedidos = dao.todosPedidos();
        return Response.ok().entity(pedidos).build();
    }

    @POST
    @Path("/")
    public Response criarPedido(){
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    public Response deletePedido(@PathParam("id") long id){
        return Response.ok().build();
    }

    @PUT
    @Path("/{id}")
    public Response alteraPedido(@PathParam("id") long id){
        return Response.ok().build();
    }
}
