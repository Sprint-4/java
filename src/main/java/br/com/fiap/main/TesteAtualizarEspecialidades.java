package br.com.fiap.main;

import br.com.fiap.beans.Especialidades;
import br.com.fiap.dao.EspecialidadesDAO;
import javax.swing.*;
import java.sql.SQLException;

public class TesteAtualizarEspecialidades {

    static String texto(String j) {
        return JOptionPane.showInputDialog(j);
    }

    static int inteiro(String j) {
        return Integer.parseInt(JOptionPane.showInputDialog(j));
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Especialidades objEspecialidade = new Especialidades();
        EspecialidadesDAO dao = new EspecialidadesDAO();

        objEspecialidade.setId(inteiro("Informe o ID da especialidade:"));
        objEspecialidade.setNome(texto("Informe o novo nome da especialidade:"));

        System.out.println(dao.atualizar(objEspecialidade));
    }
}
