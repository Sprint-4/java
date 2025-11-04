package br.com.fiap.main;

import br.com.fiap.beans.Endereco;
import br.com.fiap.beans.Medico;
import br.com.fiap.dao.EnderecoDAO;
import br.com.fiap.dao.MedicoDAO;

import javax.swing.*;
import java.sql.SQLException;

public class TesteAtualizarMedico {

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
        MedicoDAO medicoDAO = new MedicoDAO();

        Medico objMedico= new Medico();

        objMedico.setId(inteiro("Informe o ID do Medico que sera atualizado "));
        objMedico.setCrm(texto("Informe o CRM que sera atualizado "));
        objMedico.setNome(texto("Nome que sera atualizado "));



        System.out.println(MedicoDAO.atualizar(objMedico));

    }

}


