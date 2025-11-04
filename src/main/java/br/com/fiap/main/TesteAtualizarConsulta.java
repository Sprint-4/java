package br.com.fiap.main;

import br.com.fiap.beans.Consulta;
import br.com.fiap.dao.ConsultaDAO;
import br.com.fiap.dao.EnderecoDAO;
import javax.swing.*;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class TesteAtualizarConsulta {

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
        Consulta objConsulta= new Consulta();

        objConsulta.setId(inteiro("Informe o ID da Consulta que sera atualizado "));
        objConsulta.setDataHora(LocalDateTime.parse(texto("Para que hora deseja mudar sua consulta")));
        objConsulta.setStatus(texto("Para qual Status deseja atualizar  "));

        System.out.println(ConsultaDAO.atualizar(objConsulta));

    }

}


