package br.com.fiap.dao;

import br.com.fiap.beans.Convenio;
import br.com.fiap.conexoes.ConexaoFactory;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ConvenioDAO {
    private Connection minhaconexao;

    public ConvenioDAO() throws SQLException, ClassNotFoundException {
        this.minhaconexao = new ConexaoFactory().conexao();
    }

    public String inserir(Convenio c) throws SQLException {
        String sql = "INSERT INTO CONVENIO (ID, NOME, COBERTURA) VALUES (?, ?, ?)";
        PreparedStatement stmt = minhaconexao.prepareStatement(sql);
        stmt.setInt(1, c.getId());
        stmt.setString(2, c.getNome());
        stmt.setString(3, c.getCobertura());
        stmt.execute();
        stmt.close();
        return "Convênio inserido com sucesso";
    }

    public String atualizar(Convenio c) throws SQLException {
        String sql = "UPDATE CONVENIO SET NOME=?, COBERTURA=? WHERE ID=?";
        PreparedStatement stmt = minhaconexao.prepareStatement(sql);
        stmt.setString(1, c.getNome());
        stmt.setString(2, c.getCobertura());
        stmt.setInt(3, c.getId());
        stmt.executeUpdate();
        stmt.close();
        return "Convênio atualizado com sucesso";
    }

    public String deletar(int id) throws SQLException {
        String sql = "DELETE FROM CONVENIO WHERE ID=?";
        PreparedStatement stmt = minhaconexao.prepareStatement(sql);
        stmt.setInt(1, id);
        stmt.executeUpdate();
        stmt.close();
        return "Convênio deletado com sucesso";
    }

    public List<Convenio> selecionar() throws SQLException {
        List<Convenio> lista = new ArrayList<>();
        String sql = "SELECT * FROM CONVENIO";
        PreparedStatement stmt = minhaconexao.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Convenio c = new Convenio();
            c.setId(rs.getInt("ID"));
            c.setNome(rs.getString("NOME"));
            c.setCobertura(rs.getString("COBERTURA"));
            lista.add(c);
        }
        rs.close();
        stmt.close();
        return lista;
    }
}
