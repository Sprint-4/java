package br.com.fiap.dao;

import java.sql.*;
import java.util.*;
import br.com.fiap.beans.Endereco;
import br.com.fiap.conexoes.ConexaoFactory;

public class EnderecoDAO {

    private Connection conexao;

    public EnderecoDAO() throws SQLException, ClassNotFoundException {
        this.conexao = new ConexaoFactory().conexao();
    }

    // INSERT
    public void inserir(Endereco e) throws SQLException {
        String sql = "INSERT INTO TB_ENDERECO (NM_RUA, NR_ENDERECO, NM_CIDADE, SG_ESTADO, NR_CEP) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setString(1, e.getNomeRua());
            ps.setInt(2, e.getNumero());
            ps.setString(3, e.getCidade());
            ps.setString(4, e.getEstado());
            ps.setString(5, e.getCep());
            ps.executeUpdate();
        }
    }

    // UPDATE
    public void atualizar(Endereco e) throws SQLException {
        String sql = "UPDATE TB_ENDERECO SET NM_RUA=?, NR_ENDERECO=?, NM_CIDADE=?, SG_ESTADO=?, NR_CEP=? WHERE ID_ENDERECO=?";
        try (PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setString(1, e.getNomeRua());
            ps.setInt(2, e.getNumero());
            ps.setString(3, e.getCidade());
            ps.setString(4, e.getEstado());
            ps.setString(5, e.getCep());
            ps.setInt(6, e.getIdEndereco());
            ps.executeUpdate();
        }
    }

    // DELETE
    public void deletar(int id) throws SQLException {
        String sql = "DELETE FROM TB_ENDERECO WHERE ID_ENDERECO=?";
        try (PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    // SELECT
    public List<Endereco> selecionar() throws SQLException {
        List<Endereco> lista = new ArrayList<>();
        String sql = "SELECT * FROM TB_ENDERECO";
        try (PreparedStatement ps = conexao.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Endereco e = new Endereco(
                        rs.getInt("ID_ENDERECO"),
                        rs.getString("NM_RUA"),
                        rs.getInt("NR_ENDERECO"),
                        rs.getString("NM_CIDADE"),
                        rs.getString("SG_ESTADO"),
                        rs.getString("NR_CEP")
                );
                lista.add(e);
            }
        }
        return lista;
    }
}
