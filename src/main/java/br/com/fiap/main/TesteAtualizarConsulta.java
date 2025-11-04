package br.com.fiap.main;

import br.com.fiap.beans.Consulta;
import br.com.fiap.dao.ConsultaDAO;
import javax.swing.*;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class TesteAtualizarConsulta {

    static String texto(String j) {
        return JOptionPane.showInputDialog(j);
    }

    static int inteiro(String j) {
        return Integer.parseInt(JOptionPane.showInputDialog(j));
    }

    static double real(String j) {
        return Double.parseDouble(JOptionPane.showInputDialog(j));
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        // Instanciar objetos
        ConsultaDAO dao = new ConsultaDAO();
        Consulta objConsulta = new Consulta();

        // Coletar dados
        objConsulta.setId(inteiro("Informe o ID da Consulta que será atualizada:"));
        objConsulta.setDataHora(LocalDateTime.parse(texto("Informe a nova data/hora da consulta (ex: 2025-11-04T14:30):")));
        objConsulta.setStatus(texto("Informe o novo status da consulta:"));


        System.out.println(dao.atualizar(objConsulta));
    }
}
