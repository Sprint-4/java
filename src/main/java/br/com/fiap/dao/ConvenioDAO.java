package br.com.fiap.dao;

import java.sql.*;
import java.util.*;
import br.com.fiap.beans.Convenio;
import br.com.fiap.conexoes.ConexaoFactory;

public class ConvenioDAO {

    private Connection conexao;

    public ConvenioDAO() throws SQLException, ClassNotFoundException {
        this.conexao = new ConexaoFactory().conexao();
    }

    public void inserir(Convenio c) throws SQLException {
        String sql = "INSERT INTO TB_CONVENIO (NM_CONVENIO, DS_COBERTURA) VALUES (?, ?)";
        try (PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setString(1, c.getNome());
            ps.setString(2, c.getDescricao());
            ps.executeUpdate();
        }
    }

    public void atualizar(Convenio c) throws SQLException {
        String sql = "UPDATE TB_CONVENIO SET NM_CONVENIO=?, DS_COBERTURA=? WHERE ID_CONVENIO=?";
        try (PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setString(1, c.getNome());
            ps.setString(2, c.getDescricao());
            ps.setInt(3, c.getIdConvenio());
            ps.executeUpdate();
        }
    }

    public void deletar(int id) throws SQLException {
        String sql = "DELETE FROM TB_CONVENIO WHERE ID_CONVENIO=?";
        try (PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    public List<Convenio> selecionar() throws SQLException {
        List<Convenio> lista = new ArrayList<>();
        String sql = "SELECT * FROM TB_CONVENIO";
        try (PreparedStatement ps = conexao.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Convenio c = new Convenio(
                        rs.getInt("ID_CONVENIO"),
                        rs.getString("NM_CONVENIO"),
                        rs.getString("DS_COBERTURA")
                );
                lista.add(c);
            }
        }
        return lista;
    }
}
