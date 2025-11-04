package br.com.fiap.main;

import br.com.fiap.beans.Medico;
import br.com.fiap.beans.Paciente;
import br.com.fiap.dao.MedicoDAO;
import br.com.fiap.dao.PacienteDAO;

import javax.swing.*;
import java.sql.SQLException;

public class TesteInserirPaciente {


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

        objPaciente.setId(inteiro("ID que deseja inserir"));
        objPaciente.setNome(texto("Nome do Medico que deseja inserir"));
        objPaciente.setCpf(texto("CPF do Paciente que deseja insereir"));
        objPaciente.setTelefone(texto("Telefone do Paciente que deseja insereir"));




        pacienteDAO.inserir(objPaciente);

        System.out.println(pacienteDAO.inserir(objPaciente));

    }





}
