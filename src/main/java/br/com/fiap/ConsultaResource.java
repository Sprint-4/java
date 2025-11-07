package br.com.fiap;

import br.com.fiap.Bo.ConsultaBO;
import br.com.fiap.beans.Consulta;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import java.sql.SQLException;
import java.util.List;

@Path("/consulta")
public class ConsultaResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Consulta> listar() throws SQLException, ClassNotFoundException {
        ConsultaBO consultaBO = new ConsultaBO();
        return consultaBO.selecionarBo();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response inserir(Consulta consulta, @Context UriInfo uriInfo) throws SQLException, ClassNotFoundException {
        ConsultaBO consultaBO = new ConsultaBO();
        consultaBO.inserirBo(consulta);
        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path(Integer.toString(consulta.getIdConsulta()));
        return Response.created(builder.build()).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualizar(Consulta consulta) throws SQLException, ClassNotFoundException {
        ConsultaBO consultaBO = new ConsultaBO();
        consultaBO.atualizarBo(consulta);
        return Response.ok().build();
    }

    @DELETE
    @Path("{id}")
    public Response deletar(@PathParam("id") int id) throws SQLException, ClassNotFoundException {
        ConsultaBO consultaBO = new ConsultaBO();
        consultaBO.deletarBo(id);
        return Response.ok().build();
    }
}
