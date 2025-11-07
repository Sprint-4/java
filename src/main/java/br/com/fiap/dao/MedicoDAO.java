package br.com.fiap.dao;

import java.sql.*;
import java.util.*;
import br.com.fiap.beans.Medico;
import br.com.fiap.conexoes.ConexaoFactory;

public class MedicoDAO {

    private Connection conexao;

    public MedicoDAO() throws SQLException, ClassNotFoundException {
        this.conexao = new ConexaoFactory().conexao();
    }

    // INSERT
    public void inserir(Medico m) throws SQLException {
        String sql = "INSERT INTO TB_MEDICO (NM_MEDICO, NR_CRM, ID_ESPECIALIDADE) VALUES (?, ?, ?)";
        try (PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setString(1, m.getNome());
            ps.setString(2, m.getCrm());
            ps.setInt(3, m.getIdEspecialidade());
            ps.executeUpdate();
        }
    }

    // UPDATE
    public void atualizar(Medico m) throws SQLException {
        String sql = "UPDATE TB_MEDICO SET NM_MEDICO=?, NR_CRM=?, ID_ESPECIALIDADE=? WHERE ID_MEDICO=?";
        try (PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setString(1, m.getNome());
            ps.setString(2, m.getCrm());
            ps.setInt(3, m.getIdEspecialidade());
            ps.setInt(4, m.getIdMedico());
            ps.executeUpdate();
        }
    }

    // DELETE
    public void deletar(int id) throws SQLException {
        String sql = "DELETE FROM TB_MEDICO WHERE ID_MEDICO=?";
        try (PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    // SELECT
    public List<Medico> selecionar() throws SQLException {
        List<Medico> lista = new ArrayList<>();
        String sql = "SELECT * FROM TB_MEDICO";
        try (PreparedStatement ps = conexao.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Medico m = new Medico(
                        rs.getInt("ID_MEDICO"),
                        rs.getString("NM_MEDICO"),
                        rs.getString("NR_CRM"),
                        rs.getInt("ID_ESPECIALIDADE")
                );
                lista.add(m);
            }
        }
        return lista;
    }
}
