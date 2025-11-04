package br.com.fiap.main;

import br.com.fiap.beans.Medico;
import br.com.fiap.beans.Especialidades;
import br.com.fiap.dao.MedicoDAO;
import javax.swing.*;
import java.sql.SQLException;

public class TesteAtualizarMedico {

    static String texto(String j) {
        return JOptionPane.showInputDialog(j);
    }

    static int inteiro(String j) {
        return Integer.parseInt(JOptionPane.showInputDialog(j));
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Medico objMedico = new Medico();
        MedicoDAO dao = new MedicoDAO();
        Especialidades especialidade = new Especialidades();

        objMedico.setId(inteiro("Informe o ID do médico:"));
        objMedico.setNome(texto("Informe o novo nome do médico:"));
        objMedico.setCrm(texto("Informe o novo CRM:"));
        especialidade.setId(inteiro("Informe o ID da especialidade:"));
        objMedico.setEspecialidade(especialidade);

        System.out.println(dao.atualizar(objMedico));
    }
}
