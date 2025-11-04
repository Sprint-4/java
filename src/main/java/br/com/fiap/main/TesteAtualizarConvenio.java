package br.com.fiap.main;

import br.com.fiap.beans.Convenio;
import br.com.fiap.dao.ConvenioDAO;
import javax.swing.*;
import java.sql.SQLException;

public class TesteAtualizarConvenio {

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
        ConvenioDAO convenioDAO = new ConvenioDAO();

        Convenio objConvenio= new Convenio();

        objConvenio.setId(inteiro("Informe o ID do Endereco que sera atualizado "));
        objConvenio.setCobertura(texto("Cobertura que sera atualizada "));
        objConvenio.setNome(texto("Nome do convenio que sera atualizado "));



        System.out.println(ConvenioDAO.atualizar(objConvenio));

    }

}

