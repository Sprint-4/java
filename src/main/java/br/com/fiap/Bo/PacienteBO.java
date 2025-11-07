package br.com.fiap.Bo;

import java.sql.SQLException;
import java.util.List;
import br.com.fiap.beans.Paciente;
import br.com.fiap.dao.PacienteDAO;

public class PacienteBO {

    private PacienteDAO pacienteDAO;

    public PacienteBO() throws SQLException, ClassNotFoundException {
        pacienteDAO = new PacienteDAO();
    }

    public void inserirBo(Paciente paciente) throws SQLException {
        pacienteDAO.inserir(paciente);
    }

    public void atualizarBo(Paciente paciente) throws SQLException {
        pacienteDAO.atualizar(paciente);
    }

    public void deletarBo(int id) throws SQLException {
        pacienteDAO.deletar(id);
    }

    public List<Paciente> selecionarBo() throws SQLException {
        return pacienteDAO.selecionar();
    }
}
