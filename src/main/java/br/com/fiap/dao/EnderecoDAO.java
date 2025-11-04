package br.com.fiap.dao;

import br.com.fiap.beans.Endereco;
import br.com.fiap.conexoes.ConexaoFactory;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EnderecoDAO {
    private Connection minhaconexao;

    public EnderecoDAO() throws SQLException, ClassNotFoundException {
        this.minhaconexao = new ConexaoFactory().conexao();
    }

    public String inserir(Endereco e) throws SQLException {
        String sql = "INSERT INTO ENDERECO (ID, LOGRADOURO, NUMERO, CIDADE, ESTADO) VALUES (?, ?, ?, ?,)";
        PreparedStatement stmt = minhaconexao.prepareStatement(sql);
        stmt.setInt(1, e.getId());
        stmt.setInt(2, e.getNumero());
        stmt.setString(3, e.getCidade());
        stmt.setString(4, e.getEstado());
        stmt.execute();
        stmt.close();
        return "Endereço inserido com sucesso";
    }

    public String atualizar(Endereco e) throws SQLException {
        String sql = "UPDATE ENDERECO SET  NUMERO=?, CIDADE=?, ESTADO=? WHERE ID=?";
        PreparedStatement stmt = minhaconexao.prepareStatement(sql);
        stmt.setInt(1, e.getNumero());
        stmt.setString(2, e.getCidade());
        stmt.setString(3, e.getEstado());
        stmt.setInt(4, e.getId());
        stmt.executeUpdate();
        stmt.close();
        return "Endereço atualizado com sucesso";
    }

    public String deletar(int id) throws SQLException {
        String sql = "DELETE FROM ENDERECO WHERE ID=?";
        PreparedStatement stmt = minhaconexao.prepareStatement(sql);
        stmt.setInt(1, id);
        stmt.executeUpdate();
        stmt.close();
        return "Endereço deletado com sucesso";
    }

    public List<Endereco> selecionar() throws SQLException {
        List<Endereco> lista = new ArrayList<>();
        String sql = "SELECT * FROM ENDERECO";
        PreparedStatement stmt = minhaconexao.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Endereco e = new Endereco();
            e.setId(rs.getInt("ID"));
            lista.add(e);
        }
        rs.close();
        stmt.close();
        return lista;
    }
}
