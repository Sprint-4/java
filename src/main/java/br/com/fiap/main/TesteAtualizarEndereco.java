package br.com.fiap.main;

import br.com.fiap.beans.Endereco;
import br.com.fiap.dao.EnderecoDAO;
import javax.swing.*;
import java.sql.SQLException;

public class TesteAtualizarEndereco {

    static String texto(String j) {
        return JOptionPane.showInputDialog(j);
    }

    static int inteiro(String j) {
        return Integer.parseInt(JOptionPane.showInputDialog(j));
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Endereco objEndereco = new Endereco();
        EnderecoDAO dao = new EnderecoDAO();

        objEndereco.setId(inteiro("Informe o ID do endereço:"));
        objEndereco.setRua(texto("Informe a nova rua:"));
        objEndereco.setNumero(inteiro("Informe o novo número:"));
        objEndereco.setCidade(texto("Informe a nova cidade:"));
        objEndereco.setEstado(texto("Informe o novo estado:"));
        objEndereco.setCep(texto("Informe o novo CEP:"));

        System.out.println(dao.atualizar(objEndereco));
    }
}
