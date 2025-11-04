package br.com.fiap.Bo;

import br.com.fiap.beans.Prontuario;
import br.com.fiap.dao.ProntuarioDAO;

import java.sql.SQLException;
import java.util.ArrayList;

public class ProntuarioBO {

    public ProntuarioDAO prontuarioDAO;


    //Selecionar

    public ArrayList<Prontuario> selecionarBo() throws SQLException, ClassNotFoundException {
        prontuarioDAO= new ProntuarioDAO();

        // Regra de negócios

        return (ArrayList<Prontuario>)  prontuarioDAO.selecionar();
    }

    //Inserir
    public void inserirBo(Prontuario prontuario) throws SQLException, ClassNotFoundException {
        ProntuarioDAO prontuarioDAO = new ProntuarioDAO();

        // Regra de negócios

        prontuarioDAO.inserir(prontuario);
    }

    //Deletar
    public void deletarBo(int codigo) throws SQLException, ClassNotFoundException {
        ProntuarioDAO prontuarioDAO = new ProntuarioDAO();

        // Regra de negócios

        prontuarioDAO.deletar(codigo);
    }

    //Atualizar
    public void atualizarBo(Prontuario prontuario) throws SQLException, ClassNotFoundException {
        ProntuarioDAO prontuarioDAO = new ProntuarioDAO();

        // Regra de negócios

        prontuarioDAO.atualizar(prontuario);
    }

}

