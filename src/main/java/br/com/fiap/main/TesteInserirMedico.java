package br.com.fiap.main;

import br.com.fiap.beans.Endereco;
import br.com.fiap.beans.Medico;
import br.com.fiap.dao.EnderecoDAO;
import br.com.fiap.dao.MedicoDAO;

import javax.swing.*;
import java.sql.SQLException;

public class TesteInserirMedico {

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

        MedicoDAO medicoDAO = new MedicoDAO();

        Medico objMedico = new Medico();

        objMedico.setId(inteiro("ID que deseja inserir"));
        objMedico.setNome(texto("Nome do Medico que deseja inserir"));
        objMedico.setCrm(texto("CRM do medico que deseja insereir"));




        medicoDAO.inserir(objMedico);

        System.out.println(medicoDAO.inserir(objMedico));

    }

}
