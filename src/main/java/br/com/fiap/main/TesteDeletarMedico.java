package br.com.fiap.main;

import br.com.fiap.beans.Medico;
import br.com.fiap.dao.MedicoDAO;

import javax.swing.*;
import java.sql.SQLException;

public class TesteDeletarMedico {


    static int inteiro(String j) {
        return Integer.parseInt(JOptionPane.showInputDialog(j));
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        // Instanciar objetos
        MedicoDAO medicoDAO = new MedicoDAO();

        Medico objMedico = new Medico();

        objMedico.setId(inteiro("Informe o ID do Medico que sera  deletado"));

        System.out.println(medicoDAO.deletar(objMedico.getId()));

    }

}






