package br.com.fiap.main;

import br.com.fiap.beans.Endereco;
import br.com.fiap.dao.EnderecoDAO;

import javax.swing.*;
import java.sql.SQLException;

public class TesteAtualizarEndereco {


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

        // Instanciar objetos
        EnderecoDAO enderecoDAO = new EnderecoDAO();

        Endereco objEndereco= new Endereco();

        objEndereco.setId(inteiro("Informe o ID do Endereco que sera atualizado "));
        objEndereco.setRua(texto("Nome da Rua que sera atualizada "));
        objEndereco.setNumero(texto("Numero que sera atualizado "));
        objEndereco.setCidade(texto("Cidade que sera atualizada "));
        objEndereco.setEstado(texto("Estado que sera atualizado "));

        System.out.println(EnderecoDAO.atualizar(objEndereco));

    }

}

