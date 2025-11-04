package br.com.fiap.dao;

// import br.com.fiap.beans.Paciente; // Import não utilizado
import br.com.fiap.beans.Usuario;
import br.com.fiap.conexoes.ConexaoFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {


    public Connection minhaconexao;

    public UsuarioDAO() throws SQLException, ClassNotFoundException {
        this.minhaconexao = new ConexaoFactory().conexao();
    }


    public String inserir(Usuario usuario) throws SQLException {

        PreparedStatement stmt = minhaconexao.prepareStatement(
                "INSERT INTO TB_USUARIO (ID_USUARIO, NM_LOGIN, DS_SENHA, DS_PERFIL) VALUES (?, ?, ?, ?)");

        stmt.setInt(1, usuario.getId());
        stmt.setString(2, usuario.getLogin());


        stmt.setString(3, String.valueOf(usuario.getSenha()));

        stmt.setString(4, usuario.getPerfil());

        stmt.execute();
        stmt.close();

        return "Usuário cadastrado com sucesso";
    }

    public String deletar(int id) throws SQLException {

        PreparedStatement stmt = minhaconexao.prepareStatement(
                "DELETE FROM TB_USUARIO WHERE ID_USUARIO = ?");

        stmt.setInt(1, id);

        stmt.execute();
        stmt.close();

        return "Usuário deletado com sucesso";
    }


    public String atualizar(Usuario usuario) throws SQLException {
        PreparedStatement stmt = minhaconexao.prepareStatement(
                "UPDATE TB_USUARIO SET NM_LOGIN = ?, DS_SENHA = ?, DS_PERFIL = ? WHERE ID_USUARIO = ?");


        stmt.setString(1, usuario.getLogin());
        stmt.setString(2, String.valueOf(usuario.getSenha()));
        stmt.setString(3, usuario.getPerfil());
        stmt.setInt(4, usuario.getId());

        stmt.executeUpdate();
        stmt.close();

        return "Usuário atualizado com sucesso!";
    }


    public List<Usuario> selecionar() throws SQLException {
        ArrayList<Usuario> listUsuario = new ArrayList<>();


        PreparedStatement stmt = minhaconexao.prepareStatement(
                "SELECT ID_USUARIO, NM_LOGIN, DS_SENHA, DS_PERFIL FROM TB_USUARIO");

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Usuario objUsuario = new Usuario();


            objUsuario.setId(rs.getInt("ID_USUARIO"));
            objUsuario.setLogin(rs.getString("NM_LOGIN"));


            objUsuario.setSenha(Integer.parseInt(rs.getString("DS_SENHA")));

            objUsuario.setPerfil(rs.getString("DS_PERFIL"));

            listUsuario.add(objUsuario);
        }

        rs.close(); // Fechando o ResultSet
        stmt.close();

        return listUsuario;
    }
}