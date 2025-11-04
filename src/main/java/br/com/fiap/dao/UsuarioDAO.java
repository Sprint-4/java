package br.com.fiap.dao;

import br.com.fiap.beans.Usuario;
import br.com.fiap.conexoes.ConexaoFactory;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {

    private Connection minhaconexao;

    public UsuarioDAO() throws SQLException, ClassNotFoundException {
        this.minhaconexao = new ConexaoFactory().conexao();
    }

    public String inserir(Usuario u) throws SQLException {
        String sql = "INSERT INTO TB_USUARIO (ID_USUARIO, DS_SENHA,) VALUES (?, ?,)";
        PreparedStatement stmt = minhaconexao.prepareStatement(sql);
        stmt.setInt(1, u.getId());
        stmt.setString(2, u.getSenha());
        stmt.execute();
        stmt.close();
        return "Usuário inserido com sucesso";
    }

    public String atualizar(Usuario u) throws SQLException {
        String sql = "UPDATE TB_USUARIO SET  DS_SENHA=? WHERE ID_USUARIO=?";
        PreparedStatement stmt = minhaconexao.prepareStatement(sql);
        stmt.setString(1, u.getSenha());
        stmt.setInt(2, u.getId());
        stmt.executeUpdate();
        stmt.close();
        return "Usuário atualizado com sucesso";
    }

    public String deletar(int id) throws SQLException {
        String sql = "DELETE FROM TB_USUARIO WHERE ID_USUARIO=?";
        PreparedStatement stmt = minhaconexao.prepareStatement(sql);
        stmt.setInt(1, id);
        stmt.executeUpdate();
        stmt.close();
        return "Usuário deletado com sucesso";
    }

    public List<Usuario> selecionar() throws SQLException {
        List<Usuario> lista = new ArrayList<>();
        String sql = "SELECT ID_USUARIO, DS_SENHA FROM TB_USUARIO";
        PreparedStatement stmt = minhaconexao.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Usuario u = new Usuario();
            u.setId(rs.getInt("ID_USUARIO"));
            u.setSenha(rs.getString("DS_SENHA"));
            lista.add(u);
        }
        rs.close();
        stmt.close();
        return lista;
    }
}
