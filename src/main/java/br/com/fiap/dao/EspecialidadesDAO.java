package br.com.fiap.dao;

import br.com.fiap.beans.Especialidades;
import br.com.fiap.conexoes.ConexaoFactory;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EspecialidadesDAO {
    private Connection minhaconexao;

    public EspecialidadesDAO() throws SQLException, ClassNotFoundException {
        this.minhaconexao = new ConexaoFactory().conexao();
    }

    public String inserir(Especialidades e) throws SQLException {
        String sql = "INSERT INTO TB_ESPECIALIDADE (ID_ESPECIALIDADE, NM_ESPECIALIDADE) VALUES (?, ?)";
        PreparedStatement stmt = minhaconexao.prepareStatement(sql);
        stmt.setInt(1, e.getId());
        stmt.setString(2, e.getNome());
        stmt.execute();
        stmt.close();
        minhaconexao.close();
        return "Especialidade inserida com sucesso";
    }

    public String atualizar(Especialidades e) throws SQLException {
        String sql = "UPDATE TB_ESPECIALIDADE SET NM_ESPECIALIDADE=? WHERE ID_ESPECIALIDADE=?";
        PreparedStatement stmt = minhaconexao.prepareStatement(sql);
        stmt.setString(1, e.getNome());
        stmt.setInt(2, e.getId());
        stmt.executeUpdate();
        stmt.close();
        minhaconexao.close();
        return "Especialidade atualizada com sucesso";
    }

    public String deletar(int id) throws SQLException {
        String sql = "DELETE FROM TB_ESPECIALIDADE WHERE ID_ESPECIALIDADE=?";
        PreparedStatement stmt = minhaconexao.prepareStatement(sql);
        stmt.setInt(1, id);
        stmt.executeUpdate();
        stmt.close();
        minhaconexao.close();
        return "Especialidade deletada com sucesso";
    }

    public List<Especialidades> selecionar() throws SQLException {
        List<Especialidades> lista = new ArrayList<>();
        String sql = "SELECT ID_ESPECIALIDADE, NM_ESPECIALIDADE FROM TB_ESPECIALIDADE";
        PreparedStatement stmt = minhaconexao.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Especialidades e = new Especialidades();
            e.setId(rs.getInt("ID_ESPECIALIDADE"));
            e.setNome(rs.getString("NM_ESPECIALIDADE"));
            lista.add(e);
        }
        rs.close();
        stmt.close();
        minhaconexao.close();
        return lista;
    }
}
