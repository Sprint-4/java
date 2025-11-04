package br.com.fiap.main;


import br.com.fiap.beans.Prontuario;
import br.com.fiap.dao.ProntuarioDAO;
import javax.swing.*;
import java.sql.SQLException;

public class TesteAtualizarProntuario {


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
        ProntuarioDAO prontuarioDAO = new ProntuarioDAO();

        Prontuario objProntuario = new Prontuario();

        objProntuario.setId(inteiro("informe o id do prontuario"));
        objProntuario.setHistorico(texto("informe o Prontuario"));


    }
}