package br.com.fiap.Bo;

import java.sql.SQLException;
import java.util.List;
import br.com.fiap.beans.Prontuario;
import br.com.fiap.dao.ProntuarioDAO;

public class ProntuarioBO {

    private ProntuarioDAO prontuarioDAO;

    public ProntuarioBO() throws SQLException, ClassNotFoundException {
        prontuarioDAO = new ProntuarioDAO();
    }

    public void inserirBo(Prontuario prontuario) throws SQLException {
        prontuarioDAO.inserir(prontuario);
    }

    public void atualizarBo(Prontuario prontuario) throws SQLException {
        prontuarioDAO.atualizar(prontuario);
    }

    public void deletarBo(int id) throws SQLException {
        prontuarioDAO.deletar(id);
    }

    public List<Prontuario> selecionarBo() throws SQLException {
        return prontuarioDAO.selecionar();
    }
}
