package br.com.fiap.Bo;

import java.sql.SQLException;
import java.util.List;
import br.com.fiap.beans.Consulta;
import br.com.fiap.dao.ConsultaDAO;

public class ConsultaBO {

    private ConsultaDAO consultaDAO;

    public ConsultaBO() throws SQLException, ClassNotFoundException {
        consultaDAO = new ConsultaDAO();
    }

    public void inserirBo(Consulta consulta) throws SQLException {
        consultaDAO.inserir(consulta);
    }

    public void atualizarBo(Consulta consulta) throws SQLException {
        consultaDAO.atualizar(consulta);
    }

    public void deletarBo(int id) throws SQLException {
        consultaDAO.deletar(id);
    }

    public List<Consulta> selecionarBo() throws SQLException {
        return consultaDAO.selecionar();
    }
}
