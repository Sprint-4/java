package br.com.fiap.dao;

import java.sql.*;
import java.util.*;
import br.com.fiap.beans.Paciente;
import br.com.fiap.conexoes.ConexaoFactory;

public class PacienteDAO {

    private Connection conexao;

    public PacienteDAO() throws SQLException, ClassNotFoundException {
        this.conexao = new ConexaoFactory().conexao();
    }

    // INSERT
    public void inserir(Paciente p) throws SQLException {
        String sql = "INSERT INTO TB_PACIENTE (NM_PACIENTE, NR_CPF, NR_TELEFONE, ID_ENDERECO, ID_CONVENIO) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setString(1, p.getNome());
            ps.setString(2, p.getCpf());
            ps.setString(3, p.getTelefone());
            ps.setInt(4, p.getIdEndereco());
            ps.setInt(5, p.getIdConvenio());
            ps.executeUpdate();
        }
    }

    // UPDATE
    public void atualizar(Paciente p) throws SQLException {
        String sql = "UPDATE TB_PACIENTE SET NM_PACIENTE=?, NR_CPF=?, NR_TELEFONE=?, ID_ENDERECO=?, ID_CONVENIO=? WHERE ID_PACIENTE=?";
        try (PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setString(1, p.getNome());
            ps.setString(2, p.getCpf());
            ps.setString(3, p.getTelefone());
            ps.setInt(4, p.getIdEndereco());
            ps.setInt(5, p.getIdConvenio());
            ps.setInt(6, p.getIdPaciente());
            ps.executeUpdate();
        }
    }

    // DELETE
    public void deletar(int id) throws SQLException {
        String sql = "DELETE FROM TB_PACIENTE WHERE ID_PACIENTE=?";
        try (PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    // SELECT
    public List<Paciente> selecionar() throws SQLException {
        List<Paciente> lista = new ArrayList<>();
        String sql = "SELECT * FROM TB_PACIENTE";
        try (PreparedStatement ps = conexao.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Paciente p = new Paciente(
                        rs.getInt("ID_PACIENTE"),
                        rs.getString("NM_PACIENTE"),
                        rs.getString("NR_CPF"),
                        rs.getString("NR_TELEFONE"),
                        rs.getInt("ID_ENDERECO"),
                        rs.getInt("ID_CONVENIO")
                );
                lista.add(p);
            }
        }
        return lista;
    }
}
