package br.com.fiap.dao;

import java.sql.*;
import java.util.*;
import br.com.fiap.beans.Prontuario;
import br.com.fiap.conexoes.ConexaoFactory;

public class ProntuarioDAO {

    private Connection conexao;

    public ProntuarioDAO() throws SQLException, ClassNotFoundException {
        this.conexao = new ConexaoFactory().conexao();
    }

    // INSERT
    public void inserir(Prontuario p) throws SQLException {
        String sql = "INSERT INTO TB_PRONTUARIO (ID_PACIENTE, DS_HISTORICO) VALUES (?, ?)";
        try (PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setInt(1, p.getIdPaciente());
            ps.setString(2, p.getHistorico());
            ps.executeUpdate();
        }
    }

    // UPDATE
    public void atualizar(Prontuario p) throws SQLException {
        String sql = "UPDATE TB_PRONTUARIO SET ID_PACIENTE=?, DS_HISTORICO=? WHERE ID_PRONTUARIO=?";
        try (PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setInt(1, p.getIdPaciente());
            ps.setString(2, p.getHistorico());
            ps.setInt(3, p.getIdProntuario());
            ps.executeUpdate();
        }
    }

    // DELETE
    public void deletar(int id) throws SQLException {
        String sql = "DELETE FROM TB_PRONTUARIO WHERE ID_PRONTUARIO=?";
        try (PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    // SELECT
    public List<Prontuario> selecionar() throws SQLException {
        List<Prontuario> lista = new ArrayList<>();
        String sql = "SELECT * FROM TB_PRONTUARIO";
        try (PreparedStatement ps = conexao.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Prontuario p = new Prontuario(
                        rs.getInt("ID_PRONTUARIO"),
                        rs.getInt("ID_PACIENTE"),
                        rs.getString("DS_HISTORICO")
                );
                lista.add(p);
            }
        }
        return lista;
    }
}
