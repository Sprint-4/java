package br.com.fiap;

import br.com.fiap.Bo.UsuarioBo;
import br.com.fiap.beans.Usuario;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import java.sql.SQLException;
// import java.util.ArrayList; // É melhor usar a interface List
import java.util.List;

@Path("/usuario")
public class UsuarioResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Usuario> selecionarRs() throws SQLException, ClassNotFoundException {
        UsuarioBo usuarioBO = new UsuarioBo();
        return usuarioBO.selecionarBo();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response inserirRs(Usuario usuario, @Context UriInfo uriInfo) throws SQLException, ClassNotFoundException {
        UsuarioBo usuarioBO = new UsuarioBo();
        usuarioBO.inserirBo(usuario);

        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path(Integer.toString(usuario.getId()));
        return Response.created(builder.build()).build();
    }

    @DELETE
    @Path("{id}")
    public Response deletarRs(@PathParam("id") int id) throws SQLException, ClassNotFoundException {
        UsuarioBo usuarioBO = new UsuarioBo();
        usuarioBO.deletarBo(id);
        return Response.ok().build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualizarRs(Usuario usuario) throws SQLException, ClassNotFoundException {
        // 2. Instancie o BO aqui
        UsuarioBo usuarioBO = new UsuarioBo();
        usuarioBO.atualizarBo(usuario);
        return Response.ok().build();
    }
}