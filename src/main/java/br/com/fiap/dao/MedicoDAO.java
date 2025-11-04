package br.com.fiap.dao;

import br.com.fiap.beans.Medico;
import br.com.fiap.beans.Especialidades;
import br.com.fiap.conexoes.ConexaoFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MedicoDAO {

    private Connection minhaconexao;

    // Construtor, conecta ao banco de dados
    public MedicoDAO() throws SQLException, ClassNotFoundException {
        this.minhaconexao = new ConexaoFactory().conexao();
    }

    // Inserir um médico no banco de dados
    public String inserir(Medico m) throws SQLException {
        String sql = "INSERT INTO TB_MEDICO (ID_MEDICO, NM_MEDICO, NR_CRM, ID_ESPECIALIDADE) VALUES (?, ?, ?, ?)";
        PreparedStatement stmt = minhaconexao.prepareStatement(sql);
        stmt.setInt(1, m.getId());
        stmt.setString(2, m.getNome());
        stmt.setString(3, m.getCrm());
        stmt.setInt(4, m.getEspecialidade().getId()); // A especialidade está sendo usada para pegar o ID

        stmt.execute();
        stmt.close();
        return "Médico inserido com sucesso";
    }

    // Atualizar um médico no banco de dados
    public String atualizar(Medico m) throws SQLException {
        String sql = "UPDATE TB_MEDICO SET NM_MEDICO = ?, NR_CRM = ?, ID_ESPECIALIDADE = ? WHERE ID_MEDICO = ?";
        PreparedStatement stmt = minhaconexao.prepareStatement(sql);
        stmt.setString(1, m.getNome());
        stmt.setString(2, m.getCrm());
        stmt.setInt(3, m.getEspecialidade().getId()); // Atualizando o ID da especialidade
        stmt.setInt(4, m.getId());

        stmt.executeUpdate();
        stmt.close();
        return "Médico atualizado com sucesso";
    }

    // Deletar um médico do banco de dados
    public String deletar(int id) throws SQLException {
        String sql = "DELETE FROM TB_MEDICO WHERE ID_MEDICO = ?";
        PreparedStatement stmt = minhaconexao.prepareStatement(sql);
        stmt.setInt(1, id);
        stmt.executeUpdate();
        stmt.close();
        return "Médico deletado com sucesso";
    }

    // Selecionar todos os médicos no banco de dados
    public List<Medico> selecionar() throws SQLException {
        List<Medico> lista = new ArrayList<>();
        String sql = "SELECT ID_MEDICO, NM_MEDICO, NR_CRM, ID_ESPECIALIDADE FROM TB_MEDICO";
        PreparedStatement stmt = minhaconexao.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Medico m = new Medico();
            Especialidades e = new Especialidades();

            m.setId(rs.getInt("ID_MEDICO"));
            m.setNome(rs.getString("NM_MEDICO"));
            m.setCrm(rs.getString("NR_CRM"));
            e.setId(rs.getInt("ID_ESPECIALIDADE"));
            m.setEspecialidade(e);

            lista.add(m);
        }

        rs.close();
        stmt.close();
        return lista;
    }
}
