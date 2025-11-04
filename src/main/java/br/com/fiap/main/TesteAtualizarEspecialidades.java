package br.com.fiap.main;

import br.com.fiap.beans.Especialidades;
import br.com.fiap.beans.Medico;
import br.com.fiap.dao.EspecialidadesDAO;
import br.com.fiap.dao.MedicoDAO;

import javax.swing.*;
import java.sql.SQLException;

public class TesteAtualizarEspecialidades {

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
        EspecialidadesDAO especialidadesDAO = new EspecialidadesDAO();

        Especialidades objEspecialidades = new Especialidades();

        objEspecialidades.setId(inteiro("Informe o ID da Especialidade que sera atualizada "));
        objEspecialidades.setNome(texto("Nome da especialidade que sera atualizada "));


        System.out.println(EspecialidadesDAO.atualizar(objEspecialidades));

    }

}


