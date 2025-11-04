package br.com.fiap.main;

import br.com.fiap.beans.Prontuario;
import br.com.fiap.beans.Usuario;
import br.com.fiap.dao.ProntuarioDAO;
import br.com.fiap.dao.UsuarioDAO;

import javax.swing.*;
import java.sql.SQLException;

public class TesteDeletarUsuario {


    static int inteiro(String j) {
        return Integer.parseInt(JOptionPane.showInputDialog(j));
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        // Instanciar objetos
        UsuarioDAO usuarioDAO = new UsuarioDAO();

        Usuario objUsuario = new Usuario();

        objUsuario.setId(inteiro("Informe o ID do Usuario  que sera  deletado"));

        System.out.println(usuarioDAO.deletar(objUsuario.getId()));

    }
}
