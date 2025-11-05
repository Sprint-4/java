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
        String sql = "INSERT INTO TB_ENDERECO (ID_ENDERECO, NM_RUA, NR_ENDERECO, NM_CIDADE, SG_ESTADO) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement stmt = minhaconexao.prepareStatement(sql);
        stmt.setInt(1, e.getId());
        stmt.setString(2, e.getRua());
        stmt.setInt(3, e.getNumero());
        stmt.setString(4, e.getCidade());
        stmt.setString(5, e.getEstado());
        stmt.execute();
        stmt.close();
        minhaconexao.close();
        return "Endereço inserido com sucesso";
    }

    public String atualizar(Endereco e) throws SQLException {
        String sql = "UPDATE TB_ENDERECO SET NM_RUA=?, NR_ENDERECO=?, NM_CIDADE=?, SG_ESTADO=? WHERE ID_ENDERECO=?";
        PreparedStatement stmt = minhaconexao.prepareStatement(sql);
        stmt.setString(1, e.getRua());
        stmt.setInt(2, e.getNumero());
        stmt.setString(3, e.getCidade());
        stmt.setString(4, e.getEstado());
        stmt.setInt(5, e.getId());
        stmt.executeUpdate();
        stmt.close();
        minhaconexao.close();
        return "Endereço atualizado com sucesso";
    }

    public String deletar(int id) throws SQLException {
        String sql = "DELETE FROM TB_ENDERECO WHERE ID_ENDERECO=?";
        PreparedStatement stmt = minhaconexao.prepareStatement(sql);
        stmt.setInt(1, id);
        stmt.executeUpdate();
        stmt.close();
        minhaconexao.close();
        return "Endereço deletado com sucesso";
    }

    public List<Endereco> selecionar() throws SQLException {
        List<Endereco> lista = new ArrayList<>();
        String sql = "SELECT ID_ENDERECO, NM_RUA, NR_ENDERECO, NM_CIDADE, SG_ESTADO FROM TB_ENDERECO";
        PreparedStatement stmt = minhaconexao.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Endereco e = new Endereco();
            e.setId(rs.getInt("ID_ENDERECO"));
            e.setRua(rs.getString("NM_RUA"));
            e.setNumero(rs.getInt("NR_ENDERECO"));
            e.setCidade(rs.getString("NM_CIDADE"));
            e.setEstado(rs.getString("SG_ESTADO"));
            lista.add(e);
        }
        rs.close();
        stmt.close();
        minhaconexao.close();
        return lista;
    }
}
