package br.com.fiap.main;

import br.com.fiap.beans.Endereco;
import br.com.fiap.beans.Medico;
import br.com.fiap.dao.EnderecoDAO;
import br.com.fiap.dao.MedicoDAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TesteSelecionarMedico {


    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        MedicoDAO medicoDAO = new MedicoDAO();

        List<Medico> listaMedicos = (ArrayList<Medico>)medicoDAO.selecionar();

        if(listaMedicos != null){
            for(Medico a : listaMedicos){
                System.out.println(
                        a.getId() + " " +
                                a.getId() + " " +
                                a.getNome() + " " +
                                a.getCrm()+ " \n  "


                );
            }
        }

    }

}



