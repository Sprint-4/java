package br.com.fiap.main;

import br.com.fiap.beans.Endereco;
import br.com.fiap.dao.EnderecoDAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TesteSelecionarEndereco {


  public static void main(String[] args) throws SQLException, ClassNotFoundException {

    EnderecoDAO enderecoDAO = new EnderecoDAO();

    List<Endereco> listamedicos = (ArrayList<Endereco>)enderecoDAO.selecionar();

    if(listamedicos != null){
        for(Endereco a : listamedicos){
            System.out.println(
                    a.getId() + " " +
                            a.getRua() + " " +
                            a.getNumero() + " " +
                            a.getCidade()+ " " +
                            a.getEstado() + "\n "

            );
        }
    }

}

}


