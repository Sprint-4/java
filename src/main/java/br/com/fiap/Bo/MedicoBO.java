package br.com.fiap.Bo;

import java.sql.SQLException;
import java.util.List;
import br.com.fiap.beans.Medico;
import br.com.fiap.dao.MedicoDAO;

public class MedicoBO {

    private MedicoDAO medicoDAO;

    public MedicoBO() throws SQLException, ClassNotFoundException {
        medicoDAO = new MedicoDAO();
    }

    public void inserirBo(Medico medico) throws SQLException {
        medicoDAO.inserir(medico);
    }

    public void atualizarBo(Medico medico) throws SQLException {
        medicoDAO.atualizar(medico);
    }

    public void deletarBo(int id) throws SQLException {
        medicoDAO.deletar(id);
    }

    public List<Medico> selecionarBo() throws SQLException {
        return medicoDAO.selecionar();
    }
}
