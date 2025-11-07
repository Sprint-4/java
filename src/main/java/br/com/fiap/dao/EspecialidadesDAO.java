package br.com.fiap.dao;

import java.sql.*;
import java.util.*;
import br.com.fiap.beans.Especialidades;
import br.com.fiap.conexoes.ConexaoFactory;

public class EspecialidadesDAO {

    private Connection conexao;

    public EspecialidadesDAO() throws SQLException, ClassNotFoundException {
        this.conexao = new ConexaoFactory().conexao();
    }

    public void inserir(Especialidades e) throws SQLException {
        String sql = "INSERT INTO TB_ESPECIALIDADE (NM_ESPECIALIDADE) VALUES (?)";
        try (PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setString(1, e.getNomeEspecialidade());
            ps.executeUpdate();
        }
    }

    public void atualizar(Especialidades e) throws SQLException {
        String sql = "UPDATE TB_ESPECIALIDADE SET NM_ESPECIALIDADE=? WHERE ID_ESPECIALIDADE=?";
        try (PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setString(1, e.getNomeEspecialidade());
            ps.setInt(2, e.getIdEspecialidade());
            ps.executeUpdate();
        }
    }

    public void deletar(int id) throws SQLException {
        String sql = "DELETE FROM TB_ESPECIALIDADE WHERE ID_ESPECIALIDADE=?";
        try (PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    public List<Especialidades> selecionar() throws SQLException {
        List<Especialidades> lista = new ArrayList<>();
        String sql = "SELECT * FROM TB_ESPECIALIDADE";
        try (PreparedStatement ps = conexao.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Especialidades e = new Especialidades(
                        rs.getInt("ID_ESPECIALIDADE"),
                        rs.getString("NM_ESPECIALIDADE")
                );
                lista.add(e);
            }
        }
        return lista;
    }
}
