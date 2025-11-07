package br.com.fiap.dao;

import java.sql.*;
import java.util.*;
import br.com.fiap.beans.Usuario;
import br.com.fiap.conexoes.ConexaoFactory;

public class UsuarioDAO {

    private Connection conexao;

    public UsuarioDAO() throws SQLException, ClassNotFoundException {
        this.conexao = new ConexaoFactory().conexao();
    }

    // INSERT
    public void inserir(Usuario u) throws SQLException {
        String sql = "INSERT INTO TB_USUARIO (DS_SENHA) VALUES (?)";
        try (PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setString(1, u.getSenha());
            ps.executeUpdate();
        }
    }

    // UPDATE
    public void atualizar(Usuario u) throws SQLException {
        String sql = "UPDATE TB_USUARIO SET DS_SENHA=? WHERE ID_USUARIO=?";
        try (PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setString(1, u.getSenha());
            ps.setInt(2, u.getIdUsuario());
            ps.executeUpdate();
        }
    }

    // DELETE
    public void deletar(int id) throws SQLException {
        String sql = "DELETE FROM TB_USUARIO WHERE ID_USUARIO=?";
        try (PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    // SELECT
    public List<Usuario> selecionar() throws SQLException {
        List<Usuario> lista = new ArrayList<>();
        String sql = "SELECT * FROM TB_USUARIO";
        try (PreparedStatement ps = conexao.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Usuario u = new Usuario(
                        rs.getInt("ID_USUARIO"),
                        rs.getString("DS_SENHA")
                );
                lista.add(u);
            }
        }
        return lista;
    }
}
