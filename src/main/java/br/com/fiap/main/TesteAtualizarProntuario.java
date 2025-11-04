package br.com.fiap.main;

import br.com.fiap.beans.Prontuario;
import br.com.fiap.beans.Paciente;
import br.com.fiap.dao.ProntuarioDAO;
import javax.swing.*;
import java.sql.SQLException;

public class TesteAtualizarProntuario {

    static String texto(String j) {
        return JOptionPane.showInputDialog(j);
    }

    static int inteiro(String j) {
        return Integer.parseInt(JOptionPane.showInputDialog(j));
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Prontuario objProntuario = new Prontuario();
        ProntuarioDAO dao = new ProntuarioDAO();
        Paciente paciente = new Paciente();

        objProntuario.setId(inteiro("Informe o ID do prontuário:"));
        paciente.setId(inteiro("Informe o ID do paciente:"));
        objProntuario.setPaciente(paciente);
        objProntuario.setHistorico(texto("Informe o novo histórico:"));

        System.out.println(dao.atualizar(objProntuario));
    }
}
