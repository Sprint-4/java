package br.com.fiap.main;

import br.com.fiap.beans.Usuario;
import br.com.fiap.dao.MedicoDAO;
import br.com.fiap.dao.UsuarioDAO;

import javax.swing.*;
import java.sql.SQLException;

public class TesteAtualizarUsuario {

    static String texto (String j) {
        return JOptionPane.showInputDialog(j);
    }

    static int inteiro(String j) {
        return Integer.parseInt(JOptionPane.showInputDialog(j));
    }

    static double real (String j) {
        return Double.parseDouble(JOptionPane.showInputDialog(j));
    }


    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        // Instanciar objetos
        UsuarioDAO usuarioDAO = new UsuarioDAO();

        Usuario objUsuario= new Usuario();

        objUsuario.setId(inteiro("Informe o ID do Medico que sera atualizado "));
        objUsuario.setLogin(texto("Informe o CRM que sera atualizado "));
        objUsuario.setPerfil(texto("Nome que sera atualizado "));
        objUsuario.setSenha(inteiro("Nome que sera atualizado "));



        System.out.println(UsuarioDAO.atualizar(objUsuario));

    }

}



