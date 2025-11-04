package br.com.fiap.dao;

import br.com.fiap.beans.Prontuario;
import br.com.fiap.beans.Paciente;
import br.com.fiap.conexoes.ConexaoFactory;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProntuarioDAO {

    private Connection minhaconexao;

    public ProntuarioDAO() throws SQLException, ClassNotFoundException {
        this.minhaconexao = new ConexaoFactory().conexao();
    }

    public String inserir(Prontuario p) throws SQLException {
        String sql = "INSERT INTO TB_PRONTUARIO (ID, ID_PACIENTE, DS_HISTORICO) VALUES (?, ?, ?)";
        PreparedStatement stmt = minhaconexao.prepareStatement(sql);
        stmt.setInt(1, p.getId());
        stmt.setInt(2, p.getPaciente().getId());
        stmt.setString(3, p.getHistorico());
        stmt.execute();
        stmt.close();
        return "Prontuário inserido com sucesso";
    }

    public String atualizar(Prontuario p) throws SQLException {
        String sql = "UPDATE TB_PRONTUARIO SET ID_PACIENTE=?, DS_HISTORICO=? WHERE Id=?";
        PreparedStatement stmt = minhaconexao.prepareStatement(sql);
        stmt.setInt(1, p.getPaciente().getId());
        stmt.setString(2, p.getHistorico());
        stmt.setInt(3, p.getId());
        stmt.executeUpdate();
        stmt.close();
        return "Prontuário atualizado com sucesso";
    }

    public String deletar(int id) throws SQLException {
        String sql = "DELETE FROM TB_PRONTUARIO WHERE Id=?";
        PreparedStatement stmt = minhaconexao.prepareStatement(sql);
        stmt.setInt(1, id);
        stmt.executeUpdate();
        stmt.close();
        return "Prontuário deletado com sucesso";
    }

    public List<Prontuario> selecionar() throws SQLException {
        List<Prontuario> lista = new ArrayList<>();
        String sql = "SELECT ID_PRONTUARIO, ID_PACIENTE, DS_HISTORICO FROM TB_PRONTUARIO";
        PreparedStatement stmt = minhaconexao.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {

            Prontuario p = new Prontuario();
            Paciente pac = new Paciente();


            p.setId(rs.getInt("ID_PRONTUARIO"));


            pac.setId(rs.getInt("ID_PACIENTE"));
            p.setPaciente(pac);


            p.setHistorico(rs.getString("DS_HISTORICO"));
            lista.add(p);
        }
        rs.close();
        stmt.close();

        return lista;

    }
}
