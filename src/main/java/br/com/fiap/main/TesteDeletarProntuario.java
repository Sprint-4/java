package br.com.fiap.main;

import br.com.fiap.beans.Paciente;
import br.com.fiap.beans.Prontuario;
import br.com.fiap.dao.PacienteDAO;
import br.com.fiap.dao.ProntuarioDAO;

import javax.swing.*;
import java.sql.SQLException;

public class TesteDeletarProntuario {


    static int inteiro(String j) {
        return Integer.parseInt(JOptionPane.showInputDialog(j));
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        // Instanciar objetos
        ProntuarioDAO prontuarioDAO = new ProntuarioDAO();

        Prontuario objProntuario = new Prontuario();

        objProntuario.setId(inteiro("Informe o ID do Prontuario  que sera  deletado"));

        System.out.println(prontuarioDAO.deletar(objProntuario.getId()));

    }

}
