package br.com.fiap.main;

import br.com.fiap.beans.Consulta;
import br.com.fiap.beans.Paciente;
import br.com.fiap.dao.ConsultaDAO;
import br.com.fiap.dao.PacienteDAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TesteSelecionarConsulta {


    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        ConsultaDAO consultaDAO = new ConsultaDAO();

        List<Consulta> listaConsulta = (ArrayList<Consulta>)consultaDAO.selecionar();

        if(listaConsulta != null){
            for(Consulta a : listaConsulta){
                System.out.println(
                        a.getId() + " " +
                                a.getId() + " " +
                                a.getDataHora() + " " +
                                a.getStatus()+ " "


                );
            }
        }

    }

}

