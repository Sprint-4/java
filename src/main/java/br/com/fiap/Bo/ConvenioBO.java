package br.com.fiap.Bo;

import br.com.fiap.beans.Convenio;
import br.com.fiap.dao.ConvenioDAO;
import java.sql.SQLException;
import java.util.ArrayList;

public class ConvenioBO {

    public ConvenioDAO convenioDAO;


    //Selecionar

    public ArrayList<Convenio> selecionarBo() throws SQLException, ClassNotFoundException {
        convenioDAO = new ConvenioDAO();

        // Regra de negócios

        return (ArrayList<Convenio>) convenioDAO.selecionar();
    }

    //Inserir
    public void inserirBo(Convenio convenio) throws SQLException, ClassNotFoundException {
        ConvenioDAO convenioDAO = new ConvenioDAO();

        // Regra de negócios

        convenioDAO.inserir(convenio);
    }

    //Deletar
    public void deletarBo(int codigo) throws SQLException, ClassNotFoundException {
        ConvenioDAO consultaDAO = new ConvenioDAO();

        // Regra de negócios

        convenioDAO.deletar(codigo);
    }

    //Atualizar
    public void atualizarBo(Convenio convenio) throws SQLException, ClassNotFoundException {
        ConvenioDAO convenioDAO = new ConvenioDAO();

        // Regra de negócios

        convenioDAO.atualizar(convenio);
    }

}

