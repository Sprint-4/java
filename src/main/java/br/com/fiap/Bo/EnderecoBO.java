package br.com.fiap.Bo;


import br.com.fiap.beans.Endereco;
import br.com.fiap.dao.EnderecoDAO;
import java.sql.SQLException;
import java.util.ArrayList;

public class EnderecoBO {

    public EnderecoDAO enderecoDAO;


    //Selecionar

    public ArrayList<Endereco> selecionarBo() throws SQLException, ClassNotFoundException {
        enderecoDAO = new EnderecoDAO();

        // Regra de negócios

        return (ArrayList<Endereco>) enderecoDAO.selecionar();
    }

    //Inserir
    public void inserirBo(Endereco endereco) throws SQLException, ClassNotFoundException {
        EnderecoDAO enderecoDAO = new EnderecoDAO();

        // Regra de negócios

        enderecoDAO.inserir(endereco);
    }

    //Deletar
    public void deletarBo(int codigo) throws SQLException, ClassNotFoundException {
        EnderecoDAO enderecoDAO = new EnderecoDAO();

        // Regra de negócios

        enderecoDAO.deletar(codigo);
    }

    //Atualizar
    public void atualizarBo(Endereco endereco) throws SQLException, ClassNotFoundException {
        EnderecoDAO enderecoDAO = new EnderecoDAO();

        // Regra de negócios

        enderecoDAO.atualizar(endereco);
    }

}




