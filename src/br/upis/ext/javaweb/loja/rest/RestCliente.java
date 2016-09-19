package br.upis.ext.javaweb.loja.rest;

import br.upis.ext.javaweb.loja.dao.LojaDAO;
import br.upis.ext.javaweb.loja.data.ClienteCampoEnum;
import br.upis.ext.javaweb.loja.data.ClienteData;
import br.upis.ext.javaweb.loja.model.Cliente;
import javax.inject.Inject;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Objects;

/**
 * Created by franciscovneto on 03/09/16.
 */

@Path("/clientes")
public class RestCliente {

    @Inject
    LojaDAO dao;

    @GET
    @Path("/")
    @Produces("application/json")
    public Response todosClientes(@QueryParam("pageIndex") int pageIndex,
                                  @QueryParam("pageSize") int pageSize,
                                  @QueryParam("sortField") String field,
                                  @QueryParam("sortOrder") String orderBy) {

        ClienteCampoEnum campoOrdem;

        if (Objects.equals(field, "nome")) {
            campoOrdem = ClienteCampoEnum.NOME;
        } else {
            campoOrdem = ClienteCampoEnum.CPF;
        }

        boolean descOrdem = Objects.equals(orderBy, "desc");

        List<ClienteData> clientes = dao.todosClientesPaginados(pageIndex, pageSize, campoOrdem, descOrdem);
        RestGridData data = new RestGridData(clientes, (int) dao.qtdCliente());
        return Response.ok().entity(data).build();
    }

    @POST
    @Path("/")
    public Response criarCliente(@FormParam("cpf") long cpf, @FormParam("nome") String nome) {

        Cliente cliente = new Cliente();
        cliente.setCpf(cpf);
        cliente.setNome(nome);

        dao.criaCliente(cliente);

        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteCliente(@PathParam("id") long id) {
        dao.deleteCliente(id);

        return Response.ok().build();
    }

//
//  PorCPF
//
//  @DELETE
//    @Path("/{cpf}")
//    public Response deleteCliente(@PathParam("cpf") long cpf){
//        dao.deleteClientePorCpf(cpf);
//
//        return Response.ok().build();
//    }

    @PUT
    @Path("/{id}")
    public Response alteracliente(@PathParam("id") long id, @FormParam("cpf") long cpf, @FormParam("nome") String nome) {
        Cliente cliente = new Cliente();
        cliente.setId(id);
        cliente.setCpf(cpf);
        cliente.setNome(nome);

        dao.alteraCliente(cliente);

        return Response.ok().build();
    }


    @GET
    @Path("/gerarRelatorio")
    @Produces("application/json")
    public Response relatorio() {
        List<ClienteData> clientes = dao.gerarRelatorio();

        return Response.ok().entity(clientes).build();
    }
}
