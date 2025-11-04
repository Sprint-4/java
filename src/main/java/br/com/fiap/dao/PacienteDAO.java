package br.com.fiap.dao;

import br.com.fiap.beans.Paciente;
import br.com.fiap.conexoes.ConexaoFactory;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PacienteDAO {
    private Connection minhaconexao;

    public PacienteDAO() throws SQLException, ClassNotFoundException {
        this.minhaconexao = new ConexaoFactory().conexao();
    }

    public String inserir(Paciente p) throws SQLException {
        String sql = "INSERT INTO PACIENTE (ID, NOME, IDADE, TELEFONE, EXAME) VALUES (?, ?, ?,)";
        PreparedStatement stmt = minhaconexao.prepareStatement(sql);
        stmt.setInt(1, p.getId());
        stmt.setString(2, p.getNome());
        stmt.setString(3, p.getTelefone());
        stmt.execute();
        stmt.close();
        return "Paciente inserido com sucesso";
    }

    public String atualizar(Paciente p) throws SQLException {
        String sql = "UPDATE PACIENTE SET NOME=?,  TELEFONE=? WHERE ID=?";
        PreparedStatement stmt = minhaconexao.prepareStatement(sql);
        stmt.setString(1, p.getNome());
        stmt.setString(2, p.getTelefone());
        stmt.setInt(3, p.getId());
        stmt.executeUpdate();
        stmt.close();
        return "Paciente atualizado com sucesso";
    }

    public String deletar(int id) throws SQLException {
        String sql = "DELETE FROM PACIENTE WHERE ID=?";
        PreparedStatement stmt = minhaconexao.prepareStatement(sql);
        stmt.setInt(1, id);
        stmt.executeUpdate();
        stmt.close();
        return "Paciente deletado com sucesso";
    }

    public List<Paciente> selecionar() throws SQLException {
        List<Paciente> lista = new ArrayList<>();
        String sql = "SELECT * FROM PACIENTE";
        PreparedStatement stmt = minhaconexao.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Paciente p = new Paciente();
            p.setId(rs.getInt("ID"));
            p.setNome(rs.getString("NOME"));
            p.setTelefone(rs.getString("TELEFONE"));
            lista.add(p);
        }
        rs.close();
        stmt.close();
        return lista;
    }
}
