package br.com.fiap.main;

import br.com.fiap.beans.Medico;
import br.com.fiap.beans.Paciente;
import br.com.fiap.dao.MedicoDAO;
import br.com.fiap.dao.PacienteDAO;

import javax.swing.*;
import java.sql.SQLException;

public class TesteDeletarPaciente {


    static int inteiro(String j) {
        return Integer.parseInt(JOptionPane.showInputDialog(j));
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        // Instanciar objetos
        PacienteDAO pacienteDAO = new PacienteDAO();

        Paciente objPaciente = new Paciente();

        objPaciente.setId(inteiro("Informe o ID do Paciente que sera  deletado"));

        System.out.println(pacienteDAO.deletar(objPaciente.getId()));

    }





}
