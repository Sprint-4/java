package br.com.fiap.main;

import br.com.fiap.beans.Consulta;
import br.com.fiap.dao.ConsultaDAO;
import javax.swing.*;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class TesteInserirConsulta {


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

        ConsultaDAO consultaDAO = new ConsultaDAO();

        Consulta objConsulta = new Consulta();

        objConsulta.setId(inteiro("ID que deseja inserir"));
        objConsulta.setDataHora(LocalDateTime.parse(texto("Que hora deseja inserir")));
        objConsulta.setStatus(texto("Status  que deseja insereir"));


        consultaDAO.inserir(objConsulta);

        System.out.println(consultaDAO.inserir(objConsulta));

    }
}