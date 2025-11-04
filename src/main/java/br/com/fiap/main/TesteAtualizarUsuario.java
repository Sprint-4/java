package br.com.fiap.main;

import br.com.fiap.beans.Usuario;
import br.com.fiap.dao.UsuarioDAO;
import javax.swing.*;
import java.sql.SQLException;

public class TesteAtualizarUsuario {

    static String texto(String j) {
        return JOptionPane.showInputDialog(j);
    }

    static int inteiro(String j) {
        return Integer.parseInt(JOptionPane.showInputDialog(j));
    }

    static double real(String j) {
        return Double.parseDouble(JOptionPane.showInputDialog(j));
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        // Instanciar objetos
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Usuario objUsuario = new Usuario();

        // Coletar dados
        objUsuario.setId(inteiro("Informe o ID do Usuário que será atualizado:"));

        // Executar atualização
        System.out.println(usuarioDAO.atualizar(objUsuario));
    }
}
