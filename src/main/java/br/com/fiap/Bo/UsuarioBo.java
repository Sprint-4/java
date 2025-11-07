package br.com.fiap.Bo;

import java.sql.SQLException;
import java.util.List;
import br.com.fiap.beans.Usuario;
import br.com.fiap.dao.UsuarioDAO;

public class UsuarioBo {

    private UsuarioDAO usuarioDAO;

    public UsuarioBo() throws SQLException, ClassNotFoundException {
        usuarioDAO = new UsuarioDAO();
    }

    public void inserirBo(Usuario usuario) throws SQLException {
        usuarioDAO.inserir(usuario);
    }

    public void atualizarBo(Usuario usuario) throws SQLException {
        usuarioDAO.atualizar(usuario);
    }

    public void deletarBo(int id) throws SQLException {
        usuarioDAO.deletar(id);
    }

    public List<Usuario> selecionarBo() throws SQLException {
        return usuarioDAO.selecionar();
    }
}
