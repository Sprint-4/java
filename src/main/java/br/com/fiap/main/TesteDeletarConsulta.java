package br.com.fiap.main;

import br.com.fiap.beans.Consulta;
import br.com.fiap.dao.ConsultaDAO;
import javax.swing.*;
import java.sql.SQLException;

public class TesteDeletarConsulta {

    static int inteiro(String j) {
        return Integer.parseInt(JOptionPane.showInputDialog(j));
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        // Instanciar objetos
        ConsultaDAO consultaDAO = new ConsultaDAO();

        Consulta objConsulta = new Consulta();

        objConsulta.setId(inteiro("Informe o ID da Consulta que deseja deletar "));

        System.out.println(consultaDAO.deletar(objConsulta.getId()));

    }

}

