package br.com.fiap.main;

import br.com.fiap.beans.Paciente;
import br.com.fiap.beans.Prontuario;
import br.com.fiap.dao.PacienteDAO;
import br.com.fiap.dao.ProntuarioDAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TesteSelecionarProntuario {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        ProntuarioDAO prontuarioDAO = new ProntuarioDAO();

        List<Prontuario> listaProntuario = (ArrayList<Prontuario>)prontuarioDAO.selecionar();

        if(listaProntuario != null){
            for(Prontuario a : listaProntuario){
                System.out.println(
                        a.getId() + " " +
                                a.getId() + " " +
                                a.getHistorico() + " " +
                                a.getPaciente()+ " "



                );
            }
        }

    }

}

