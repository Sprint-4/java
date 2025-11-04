package br.com.fiap.main;

import br.com.fiap.beans.Endereco;
import br.com.fiap.dao.EnderecoDAO;

import javax.swing.*;
import java.sql.SQLException;

public class TesteInserirEndereco {


    static String texto (String j) {
        return JOptionPane.showInputDialog(j);
    }

    static int inteiro(String j) {
        return Integer.parseInt(JOptionPane.showInputDialog(j));
    }

    static double real (String j) {
        return Double.parseDouble(JOptionPane.showInputDialog(j));
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        EnderecoDAO  enderecoDAO = new EnderecoDAO();

        Endereco objEndereco = new Endereco();

        objEndereco.setId(inteiro("ID que deseja inserir"));
        objEndereco.setRua(texto("Rua que deseja inserir"));
        objEndereco.setNumero(texto("Numero da casa que deseja insereir"));
        objEndereco.setCidade(texto("Cidade que deseja inserir"));
        objEndereco.setEstado(texto("Estado que deseja inserir"));



        enderecoDAO.inserir(objEndereco);

        System.out.println(enderecoDAO.inserir(objEndereco));

    }

}
