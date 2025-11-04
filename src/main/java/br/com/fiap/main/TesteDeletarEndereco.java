package br.com.fiap.main;

import br.com.fiap.beans.Endereco;
import br.com.fiap.dao.EnderecoDAO;

import javax.swing.*;
import java.sql.SQLException;

public class TesteDeletarEndereco {




    static int inteiro(String j) {
        return Integer.parseInt(JOptionPane.showInputDialog(j));
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        // Instanciar objetos
        EnderecoDAO enderecoDAO = new EnderecoDAO();

        Endereco objEndereco = new Endereco();

        objEndereco.setId(inteiro("Informe o ID do Endereco que sera  deletado"));

        System.out.println(enderecoDAO.deletar(objEndereco.getId()));

    }

}



