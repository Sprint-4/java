package br.com.fiap;

import br.com.fiap.Bo.ProntuarioBO;
import br.com.fiap.beans.Prontuario;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import java.sql.SQLException;
import java.util.List;

@Path("/prontuario")
public class ProntuarioResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Prontuario> listar() throws SQLException, ClassNotFoundException {
        ProntuarioBO prontuarioBO = new ProntuarioBO();
        return prontuarioBO.selecionarBo();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response inserir(Prontuario prontuario, @Context UriInfo uriInfo) throws SQLException, ClassNotFoundException {
        ProntuarioBO prontuarioBO = new ProntuarioBO();
        prontuarioBO.inserirBo(prontuario);
        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path(Integer.toString(prontuario.getIdProntuario()));
        return Response.created(builder.build()).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualizar(Prontuario prontuario) throws SQLException, ClassNotFoundException {
        ProntuarioBO prontuarioBO = new ProntuarioBO();
        prontuarioBO.atualizarBo(prontuario);
        return Response.ok().build();
    }

    @DELETE
    @Path("{id}")
    public Response deletar(@PathParam("id") int id) throws SQLException, ClassNotFoundException {
        ProntuarioBO prontuarioBO = new ProntuarioBO();
        prontuarioBO.deletarBo(id);
        return Response.ok().build();
    }
}
