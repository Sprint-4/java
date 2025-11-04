package br.com.fiap;

import br.com.fiap.Bo.ProntuarioBO;
import br.com.fiap.beans.Prontuario;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import java.sql.SQLException;
// import java.util.ArrayList; // É melhor usar a interface List
import java.util.List;

@Path("/prontuario")
public class ProntuarioResource {



    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Prontuario> selecionarRs() throws SQLException, ClassNotFoundException {
        // 2. Instancie o BO aqui (dentro do método)
        ProntuarioBO prontuarioBO = new ProntuarioBO();
        return prontuarioBO.selecionarBo();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response inserirRs(Prontuario prontuario, @Context UriInfo uriInfo) throws SQLException, ClassNotFoundException {
        // 2. Instancie o BO aqui
        ProntuarioBO prontuarioBO = new ProntuarioBO();
        prontuarioBO.inserirBo(prontuario);
        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path(Integer.toString(prontuario.getId()));
        return Response.created(builder.build()).build();
    }

    @DELETE
    @Path("{id}")
    public Response deletarRs(@PathParam("id") int id) throws SQLException, ClassNotFoundException {
        ProntuarioBO prontuarioBO = new ProntuarioBO();
        prontuarioBO.deletarBo(id);
        return Response.ok().build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualizarRs(Prontuario prontuario) throws SQLException, ClassNotFoundException {

        ProntuarioBO prontuarioBO = new ProntuarioBO();
        prontuarioBO.atualizarBo(prontuario);
        return Response.ok().build();
    }
}