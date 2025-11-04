package br.com.fiap;

import br.com.fiap.Bo.EnderecoBO;
import br.com.fiap.beans.Endereco;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import java.sql.SQLException;
// import java.util.ArrayList; // É melhor usar a interface List
import java.util.List;

@Path("/endereco")
public class EnderecoResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Endereco> selecionarRs() throws SQLException, ClassNotFoundException {

        EnderecoBO enderecoBO = new EnderecoBO();
        return enderecoBO.selecionarBo();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response inserirRs(Endereco endereco, @Context UriInfo uriInfo) throws SQLException, ClassNotFoundException {

        EnderecoBO enderecoBO = new EnderecoBO();
        enderecoBO.inserirBo(endereco);

        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path(Integer.toString(endereco.getId()));
        return Response.created(builder.build()).build();
    }

    @DELETE
    @Path("{id}")
    public Response deletarRs(@PathParam("id") int id) throws SQLException, ClassNotFoundException {

        EnderecoBO enderecoBO = new EnderecoBO();
        enderecoBO.deletarBo(id);
        return Response.ok().build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualizarRs(Endereco endereco) throws SQLException, ClassNotFoundException {

        EnderecoBO enderecoBO = new EnderecoBO();
        enderecoBO.atualizarBo(endereco);
        return Response.ok().build();
    }
}