package br.com.fiap;

import br.com.fiap.Bo.EspecialidadesBO;
import br.com.fiap.beans.Especialidades;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import java.sql.SQLException;
// import java.util.ArrayList; // É melhor usar a interface List
import java.util.List;

@Path("/especialidades")
public class EspecialidadesResource {



    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Especialidades> selecionarRs() throws SQLException, ClassNotFoundException {
        // 2. Instancie o BO aqui (dentro do método)
        EspecialidadesBO especialidadesBO = new EspecialidadesBO();
        return especialidadesBO.selecionarBo();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response inserirRs(Especialidades especialidade, @Context UriInfo uriInfo) throws SQLException, ClassNotFoundException {

        EspecialidadesBO especialidadesBO = new EspecialidadesBO();
        especialidadesBO.inserirBo(especialidade);

        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path(Integer.toString(especialidade.getId()));
        return Response.created(builder.build()).build();
    }

    @DELETE
    @Path("{id}")
    public Response deletarRs(@PathParam("id") int id) throws SQLException, ClassNotFoundException {

        EspecialidadesBO especialidadesBO = new EspecialidadesBO();
        especialidadesBO.deletarBo(id);
        return Response.ok().build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualizarRs(Especialidades especialidade) throws SQLException, ClassNotFoundException {

        EspecialidadesBO especialidadesBO = new EspecialidadesBO();
        especialidadesBO.atualizarBo(especialidade);
        return Response.ok().build();
    }
}