package br.com.fiap.dao;

import br.com.fiap.beans.Consulta;
import br.com.fiap.beans.Medico;
import br.com.fiap.beans.Paciente;
import br.com.fiap.conexoes.ConexaoFactory;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ConsultaDAO {
    private Connection minhaconexao;

    public ConsultaDAO() throws SQLException, ClassNotFoundException {
        this.minhaconexao = new ConexaoFactory().conexao();
    }

    public String inserir(Consulta c) throws SQLException {
        String sql = "INSERT INTO TB_CONSULTA (ID, ID_PACIENTE, ID_MEDICO, DATAHORA, STATUS) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement stmt = minhaconexao.prepareStatement(sql);
        stmt.setInt(1, c.getId());
        stmt.setInt(2, c.getPaciente().getId());
        stmt.setInt(3, c.getMedico().getId());
        stmt.setTimestamp(4, Timestamp.valueOf(c.getDataHora()));
        stmt.setString(5, c.getStatus());
        stmt.execute();
        stmt.close();
        return "Consulta inserida com sucesso";
    }

    public String atualizar(Consulta c) throws SQLException {
        String sql = "UPDATE TB_CONSULTA SET DATAHORA=?, STATUS=? WHERE ID=?";
        PreparedStatement stmt = minhaconexao.prepareStatement(sql);
        stmt.setTimestamp(1, Timestamp.valueOf(c.getDataHora()));
        stmt.setString(2, c.getStatus());
        stmt.setInt(3, c.getId());
        stmt.executeUpdate();
        stmt.close();
        return "Consulta atualizada com sucesso";
    }

    public String deletar(int id) throws SQLException {
        String sql = "DELETE FROM TB_CONSULTA WHERE ID=?";
        PreparedStatement stmt = minhaconexao.prepareStatement(sql);
        stmt.setInt(1, id);
        stmt.executeUpdate();
        stmt.close();
        return "Consulta deletada com sucesso";
    }

    public List<Consulta> selecionar() throws SQLException {
        List<Consulta> lista = new ArrayList<>();
        String sql = "SELECT ID_CONSULTA, ID_PACIENTE, ID_MEDICO, DT_CONSULTA, DS_STATUS FROM TB_CONSULTA";
        PreparedStatement stmt = minhaconexao.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Consulta consulta = new Consulta();
            Paciente paciente = new Paciente();
            Medico medico = new Medico();

            consulta.setId(rs.getInt("ID_CONSULTA"));
            paciente.setId(rs.getInt("ID_PACIENTE"));
            consulta.setPaciente(paciente);
            medico.setId(rs.getInt("ID_MEDICO"));
            consulta.setMedico(medico);
            consulta.setDataHora(rs.getTimestamp("DT_CONSULTA").toLocalDateTime());
            consulta.setStatus(rs.getString("DS_STATUS"));

            lista.add(consulta);
        }

        rs.close();
        stmt.close();
        return lista;
    }
}

