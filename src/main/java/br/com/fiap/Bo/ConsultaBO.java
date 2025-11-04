package br.com.fiap.Bo;

import br.com.fiap.beans.Consulta;
import br.com.fiap.dao.ConsultaDAO;

import java.sql.SQLException;
import java.util.ArrayList;

public class ConsultaBO {



    public ConsultaDAO consultaDAO;

    //Selecionar
    public ArrayList<Consulta> selecionarBo() throws SQLException, ClassNotFoundException {
        consultaDAO = new ConsultaDAO();

        // Regra de negócios

        return (ArrayList<Consulta>) consultaDAO.selecionar();
    }

    //Inserir
    public void inserirBo(Consulta consulta) throws SQLException, ClassNotFoundException {
        ConsultaDAO consultaDAO = new ConsultaDAO();

        // Regra de negócios

        consultaDAO.inserir(consulta);
    }

    //Deletar
    public void deletarBo(int codigo) throws SQLException, ClassNotFoundException {
        ConsultaDAO consultaDAO = new ConsultaDAO();

        // Regra de negócios

        consultaDAO.deletar(codigo);
    }

    //Atualizar
    public void atualizarBo(Consulta consulta) throws SQLException, ClassNotFoundException {
        ConsultaDAO consultaDAO = new ConsultaDAO();

        // Regra de negócios

        consultaDAO.atualizar(consulta);
    }

}


