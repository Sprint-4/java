package br.com.fiap.Bo;

import java.sql.SQLException;
import java.util.List;
import br.com.fiap.beans.Convenio;
import br.com.fiap.dao.ConvenioDAO;

public class ConvenioBO {

    private ConvenioDAO convenioDAO;

    public ConvenioBO() throws SQLException, ClassNotFoundException {
        convenioDAO = new ConvenioDAO();
    }

    public void inserirBo(Convenio convenio) throws SQLException {
        convenioDAO.inserir(convenio);
    }

    public void atualizarBo(Convenio convenio) throws SQLException {
        convenioDAO.atualizar(convenio);
    }

    public void deletarBo(int id) throws SQLException {
        convenioDAO.deletar(id);
    }

    public List<Convenio> selecionarBo() throws SQLException {
        return convenioDAO.selecionar();
    }
}
