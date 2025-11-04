package br.com.fiap;

import br.com.fiap.Bo.MedicoBO;
import br.com.fiap.beans.Medico;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import java.sql.SQLException;
// import java.util.ArrayList; // É melhor usar a interface List
import java.util.List;

@Path("/medico")
public class MedicoResource {



    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Medico> selecionarRs() throws SQLException, ClassNotFoundException {

        MedicoBO medicoBO = new MedicoBO();
        return medicoBO.selecionarBo();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response inserirRs(Medico medico, @Context UriInfo uriInfo) throws SQLException, ClassNotFoundException {

        MedicoBO medicoBO = new MedicoBO();
        medicoBO.inserirBo(medico);

        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path(Integer.toString(medico.getId()));
        return Response.created(builder.build()).build();
    }

    @DELETE
    @Path("{id}")
    public Response deletarRs(@PathParam("id") int id) throws SQLException, ClassNotFoundException {

        MedicoBO medicoBO = new MedicoBO();
        medicoBO.deletarBo(id);
        return Response.ok().build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualizarRs(Medico medico) throws SQLException, ClassNotFoundException {

        MedicoBO medicoBO = new MedicoBO();
        medicoBO.atualizarBo(medico);
        return Response.ok().build();
    }
}