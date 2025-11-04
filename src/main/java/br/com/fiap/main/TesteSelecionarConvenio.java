package br.com.fiap.main;

import br.com.fiap.beans.Consulta;
import br.com.fiap.beans.Convenio;
import br.com.fiap.dao.ConsultaDAO;
import br.com.fiap.dao.ConvenioDAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TesteSelecionarConvenio {



    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        ConvenioDAO convenioDAO = new ConvenioDAO();

        List<Convenio> listaConvenio= (ArrayList<Convenio>)convenioDAO.selecionar();

        if(listaConvenio != null){
            for(Convenio a : listaConvenio){
                System.out.println(
                        a.getId() + " " +
                                a.getId() + " " +
                                a.getNome() + " " +
                                a.getCobertura()+ " "


                );
            }
        }

    }

}

