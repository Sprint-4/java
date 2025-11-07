package br.com.fiap;

import br.com.fiap.Bo.ConvenioBO;
import br.com.fiap.beans.Convenio;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import java.sql.SQLException;
import java.util.List;

@Path("/convenio")
public class ConvenioResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Convenio> selecionarRs() throws SQLException, ClassNotFoundException {
        ConvenioBO convenioBO = new ConvenioBO();
        return convenioBO.selecionarBo();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response inserirRs(Convenio convenio, @Context UriInfo uriInfo) throws SQLException, ClassNotFoundException {
        ConvenioBO convenioBO = new ConvenioBO();
        convenioBO.inserirBo(convenio);
        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path(Integer.toString(convenio.getIdConvenio()));
        return Response.created(builder.build()).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualizarRs(Convenio convenio) throws SQLException, ClassNotFoundException {
        ConvenioBO convenioBO = new ConvenioBO();
        convenioBO.atualizarBo(convenio);
        return Response.ok().build();
    }

    @DELETE
    @Path("{id}")
    public Response deletarRs(@PathParam("id") int id) throws SQLException, ClassNotFoundException {
        ConvenioBO convenioBO = new ConvenioBO();
        convenioBO.deletarBo(id);
        return Response.ok().build();
    }
}
