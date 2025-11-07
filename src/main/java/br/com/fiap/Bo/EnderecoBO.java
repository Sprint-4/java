package br.com.fiap.Bo;

import java.sql.SQLException;
import java.util.List;
import br.com.fiap.beans.Endereco;
import br.com.fiap.dao.EnderecoDAO;

public class EnderecoBO {

    private EnderecoDAO enderecoDAO;

    public EnderecoBO() throws SQLException, ClassNotFoundException {
        enderecoDAO = new EnderecoDAO();
    }

    public void inserirBo(Endereco endereco) throws SQLException {
        enderecoDAO.inserir(endereco);
    }

    public void atualizarBo(Endereco endereco) throws SQLException {
        enderecoDAO.atualizar(endereco);
    }

    public void deletarBo(int id) throws SQLException {
        enderecoDAO.deletar(id);
    }

    public List<Endereco> selecionarBo() throws SQLException {
        return enderecoDAO.selecionar();
    }
}
