package br.com.fiap;

import br.com.fiap.Bo.PacienteBO;
import br.com.fiap.beans.Paciente;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import java.sql.SQLException;
import java.util.List;

@Path("/paciente")
public class PacienteResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Paciente> selecionarRs() throws SQLException, ClassNotFoundException {
        PacienteBO pacienteBO = new PacienteBO();
        return pacienteBO.selecionarBo();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response inserirRs(Paciente paciente, @Context UriInfo uriInfo) throws SQLException, ClassNotFoundException {
        PacienteBO pacienteBO = new PacienteBO();
        pacienteBO.inserirBo(paciente);
        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path(Integer.toString(paciente.getIdPaciente()));
        return Response.created(builder.build()).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualizarRs(Paciente paciente) throws SQLException, ClassNotFoundException {
        PacienteBO pacienteBO = new PacienteBO();
        pacienteBO.atualizarBo(paciente);
        return Response.ok().build();
    }

    @DELETE
    @Path("{id}")
    public Response deletarRs(@PathParam("id") int id) throws SQLException, ClassNotFoundException {
        PacienteBO pacienteBO = new PacienteBO();
        pacienteBO.deletarBo(id);
        return Response.ok().build();
    }
}
