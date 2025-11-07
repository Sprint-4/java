package br.com.fiap.dao;

import java.sql.*;
import java.util.*;
import br.com.fiap.beans.Consulta;
import br.com.fiap.conexoes.ConexaoFactory;

public class ConsultaDAO {

    private Connection conexao;

    public ConsultaDAO() throws SQLException, ClassNotFoundException {
        this.conexao = new ConexaoFactory().conexao();
    }

    // INSERT
    public void inserir(Consulta c) throws SQLException {
        String sql = "INSERT INTO TB_CONSULTA (ID_PACIENTE, ID_MEDICO, DT_CONSULTA, DS_STATUS) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setInt(1, c.getIdPaciente());
            ps.setInt(2, c.getIdMedico());
            ps.setTimestamp(3, Timestamp.valueOf(c.getDataHora()));
            ps.setString(4, c.getStatus());
            ps.executeUpdate();
        }
    }

    // UPDATE
    public void atualizar(Consulta c) throws SQLException {
        String sql = "UPDATE TB_CONSULTA SET ID_PACIENTE=?, ID_MEDICO=?, DT_CONSULTA=?, DS_STATUS=? WHERE ID_CONSULTA=?";
        try (PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setInt(1, c.getIdPaciente());
            ps.setInt(2, c.getIdMedico());
            ps.setTimestamp(3, Timestamp.valueOf(c.getDataHora()));
            ps.setString(4, c.getStatus());
            ps.setInt(5, c.getIdConsulta());
            ps.executeUpdate();
        }
    }

    // DELETE
    public void deletar(int id) throws SQLException {
        String sql = "DELETE FROM TB_CONSULTA WHERE ID_CONSULTA=?";
        try (PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    // SELECT
    public List<Consulta> selecionar() throws SQLException {
        List<Consulta> lista = new ArrayList<>();
        String sql = "SELECT * FROM TB_CONSULTA";
        try (PreparedStatement ps = conexao.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Consulta c = new Consulta(
                        rs.getInt("ID_CONSULTA"),
                        rs.getInt("ID_PACIENTE"),
                        rs.getInt("ID_MEDICO"),
                        rs.getTimestamp("DT_CONSULTA").toLocalDateTime(),
                        rs.getString("DS_STATUS")
                );
                lista.add(c);
            }
        }
        return lista;
    }
}
