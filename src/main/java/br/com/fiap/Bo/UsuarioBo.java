package br.com.fiap.Bo;

import br.com.fiap.beans.Usuario;
import br.com.fiap.dao.UsuarioDAO;

import java.sql.SQLException;
import java.util.ArrayList;

public class UsuarioBo {


    public UsuarioDAO usuarioDAO;


    //Selecionar

    public ArrayList<Usuario> selecionarBo() throws SQLException, ClassNotFoundException {
        usuarioDAO= new UsuarioDAO();

        // Regra de negócios

        return (ArrayList<Usuario>)  usuarioDAO.selecionar();
    }

    //Inserir
    public void inserirBo(Usuario usuario) throws SQLException, ClassNotFoundException {
        UsuarioDAO usuarioDAO = new UsuarioDAO();

        // Regra de negócios

        usuarioDAO.inserir(usuario);
    }

    //Deletar
    public void deletarBo(int codigo) throws SQLException, ClassNotFoundException {
        UsuarioDAO usuarioDAO = new UsuarioDAO();

        // Regra de negócios

        usuarioDAO.deletar(codigo);
    }

    //Atualizar
    public void atualizarBo(Usuario usuario) throws SQLException, ClassNotFoundException {
        UsuarioDAO usuarioDAO = new UsuarioDAO();

        // Regra de negócios

        usuarioDAO.atualizar(usuario);
    }

}
