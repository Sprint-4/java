package br.com.fiap.main;

import br.com.fiap.beans.Medico;
import br.com.fiap.beans.Paciente;
import br.com.fiap.dao.MedicoDAO;
import br.com.fiap.dao.PacienteDAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TesteSelecionarPaciente {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        PacienteDAO pacienteDAO = new PacienteDAO();

        List<Paciente> listaPaciente = (ArrayList<Paciente>)pacienteDAO.selecionar();

        if(listaPaciente != null){
            for(Paciente a : listaPaciente){
                System.out.println(
                        a.getId() + " " +
                                a.getId() + " " +
                                a.getNome() + " " +
                                a.getCpf()+ " "   +
                                a.getTelefone() + " \n"


                );
            }
        }

    }

}



