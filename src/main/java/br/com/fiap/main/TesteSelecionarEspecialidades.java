package br.com.fiap.main;

import br.com.fiap.beans.Especialidades;
import br.com.fiap.dao.EspecialidadesDAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TesteSelecionarEspecialidades {



    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        EspecialidadesDAO especialidadesDAO = new EspecialidadesDAO();

        List<Especialidades> listaEspecialidades = (ArrayList<Especialidades>)especialidadesDAO.selecionar();

        if(listaEspecialidades != null){
            for(Especialidades a : listaEspecialidades){
                System.out.println(
                        a.getId() + " " +
                                a.getId() + " " +
                                a.getNome() + " "


                );
            }
        }

    }

}

