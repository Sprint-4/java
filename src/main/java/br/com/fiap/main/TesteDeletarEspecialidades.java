package br.com.fiap.main;


import br.com.fiap.beans.Especialidades;
import br.com.fiap.dao.EspecialidadesDAO;
import javax.swing.*;
import java.sql.SQLException;

public class TesteDeletarEspecialidades {


    static int inteiro(String j) {
        return Integer.parseInt(JOptionPane.showInputDialog(j));
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        // Instanciar objetos
        EspecialidadesDAO especialidadesDAO = new EspecialidadesDAO();

        Especialidades objEspecialidades = new Especialidades();

        objEspecialidades.setId(inteiro("Informe o ID da especialidade que sera  deletado"));

        System.out.println(especialidadesDAO.deletar(objEspecialidades.getId()));

    }

}
