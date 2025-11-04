package br.com.fiap.main;
import br.com.fiap.beans.Convenio;
import br.com.fiap.dao.ConvenioDAO;
import javax.swing.*;
import java.sql.SQLException;

public class TesteDeletarConvenio {


    static int inteiro(String j) {
        return Integer.parseInt(JOptionPane.showInputDialog(j));
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        // Instanciar objetos
        ConvenioDAO convenioDAO = new ConvenioDAO();

        Convenio objConvenio = new Convenio();

        objConvenio.setId(inteiro("Informe o ID do convenio que sera  deletado"));

        System.out.println(convenioDAO.deletar(objConvenio.getId()));

    }

}
