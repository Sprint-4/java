package br.com.fiap.Bo;

import java.sql.SQLException;
import java.util.List;
import br.com.fiap.beans.Especialidades;
import br.com.fiap.dao.EspecialidadesDAO;

public class EspecialidadesBO {

    private EspecialidadesDAO especialidadesDAO;

    public EspecialidadesBO() throws SQLException, ClassNotFoundException {
        especialidadesDAO = new EspecialidadesDAO();
    }

    public void inserirBo(Especialidades especialidade) throws SQLException {
        especialidadesDAO.inserir(especialidade);
    }

    public void atualizarBo(Especialidades especialidade) throws SQLException {
        especialidadesDAO.atualizar(especialidade);
    }

    public void deletarBo(int id) throws SQLException {
        especialidadesDAO.deletar(id);
    }

    public List<Especialidades> selecionarBo() throws SQLException {
        return especialidadesDAO.selecionar();
    }
}
