package br.com.fiap.main;

import br.com.fiap.beans.Paciente;
import br.com.fiap.dao.PacienteDAO;

import javax.swing.*;
import java.sql.SQLException;

public class TesteAtualizarPaciente {
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

        PacienteDAO pacienteDAO = new PacienteDAO();

        Paciente objPaciente = new Paciente();

       objPaciente.setId(inteiro("informe seu id"));
       objPaciente.setCpf(texto("informe seu cpf"));
       objPaciente.setNome("informe seu nome");
       objPaciente.setTelefone("informe seu telefone");






    }
}
