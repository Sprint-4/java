package br.com.fiap.main;

import br.com.fiap.beans.Paciente;
import br.com.fiap.beans.Usuario;
import br.com.fiap.dao.PacienteDAO;
import br.com.fiap.dao.UsuarioDAO;

import javax.swing.*;
import java.sql.SQLException;

public class TesteInserirUsuario {


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

        UsuarioDAO usuarioDAO = new UsuarioDAO();

        Usuario objUsuario = new Usuario();

        objUsuario.setId(inteiro("ID que deseja inserir"));
        objUsuario.setSenha(texto("CPF do Usuario que deseja insereir"));




        usuarioDAO.inserir(objUsuario);

        System.out.println(usuarioDAO.inserir(objUsuario));

    }
}
