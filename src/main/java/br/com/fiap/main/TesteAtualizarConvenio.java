package br.com.fiap.main;

import br.com.fiap.beans.Convenio;
import br.com.fiap.dao.ConvenioDAO;
import javax.swing.*;
import java.sql.SQLException;

public class TesteAtualizarConvenio {

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

        ConvenioDAO convenioDAO = new ConvenioDAO();
        Convenio objConvenio = new Convenio();


        objConvenio.setId(inteiro("Informe o ID do Convênio que será atualizado:"));
        objConvenio.setCobertura(texto("Informe a nova cobertura do convênio:"));
        objConvenio.setNome(texto("Informe o novo nome do convênio:"));


        System.out.println(convenioDAO.atualizar(objConvenio));
    }
}
