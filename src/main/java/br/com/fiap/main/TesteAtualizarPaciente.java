package br.com.fiap.main;

import br.com.fiap.beans.Paciente;
import br.com.fiap.dao.PacienteDAO;
import javax.swing.*;
import java.sql.SQLException;

public class TesteAtualizarPaciente {

    static String texto(String j) {
        return JOptionPane.showInputDialog(j);
    }

    static int inteiro(String j) {
        return Integer.parseInt(JOptionPane.showInputDialog(j));
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Paciente objPaciente = new Paciente();
        PacienteDAO dao = new PacienteDAO();

        objPaciente.setId(inteiro("Informe o ID do paciente:"));
        objPaciente.setNome(texto("Informe o novo nome:"));
        objPaciente.setCpf(texto("Informe o novo CPF:"));
        objPaciente.setTelefone(texto("Informe o novo telefone:"));

        System.out.println(dao.atualizar(objPaciente));
    }
}
