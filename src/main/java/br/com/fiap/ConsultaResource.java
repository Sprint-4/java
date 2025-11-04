package br.com.fiap;

import br.com.fiap.Bo.ConsultaBO;
import br.com.fiap.beans.Consulta;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List; // Prefira retornar a Interface "List"

@Path("/consulta")
public class ConsultaResource {

    // 1. Remova a instância daqui
    // ConsultaBO consultaBO = new ConsultaBO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Consulta> selecionarRs() throws SQLException, ClassNotFoundException {
        // 2. Instancie o BO aqui
        ConsultaBO consultaBO = new ConsultaBO();
        return consultaBO.selecionarBo();
        // O cast para (ArrayList) não é mais necessário se o método retornar List
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response inserirRs(Consulta consulta, @Context UriInfo uriInfo) throws SQLException, ClassNotFoundException {
        // 2. Instancie o BO aqui
        ConsultaBO consultaBO = new ConsultaBO();
        consultaBO.inserirBo(consulta);

        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path(Integer.toString(consulta.getId()));
        return Response.created(builder.build()).build();
    }

    @DELETE
    @Path("{id}")
    public Response deletarRs(@PathParam("id") int id) throws SQLException, ClassNotFoundException {
        // 2. Instancie o BO aqui
        ConsultaBO consultaBO = new ConsultaBO();
        consultaBO.deletarBo(id);
        return Response.ok().build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualizarRs(Consulta consulta) throws SQLException, ClassNotFoundException {
        // 2. Instancie o BO aqui
        ConsultaBO consultaBO = new ConsultaBO();
        consultaBO.atualizarBo(consulta);
        return Response.ok().build();
    }
}