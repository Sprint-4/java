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
        String sql = "INSERT INTO TB_PACIENTE (ID_PACIENTE, NM_PACIENTE, NR_CPF, NR_TELEFONE, ID_ENDERECO, ID_CONVENIO) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement stmt = minhaconexao.prepareStatement(sql);
        stmt.setInt(1, p.getId());
        stmt.setString(2, p.getNome());
        stmt.setString(3, p.getCpf());
        stmt.setString(4, p.getTelefone());
        stmt.setInt(5, p.getEndereco().getId());
        stmt.setInt(6, p.getConvenio().getId());
        stmt.execute();
        stmt.close();
        minhaconexao.close();
        return "Paciente inserido com sucesso";
    }

    public String atualizar(Paciente p) throws SQLException {
        String sql = "UPDATE TB_PACIENTE SET NM_PACIENTE=?, NR_CPF=?, NR_TELEFONE=?, ID_ENDERECO=?, ID_CONVENIO=? WHERE ID_PACIENTE=?";
        PreparedStatement stmt = minhaconexao.prepareStatement(sql);
        stmt.setString(1, p.getNome());
        stmt.setString(2, p.getCpf());
        stmt.setString(3, p.getTelefone());
        stmt.setInt(4, p.getEndereco().getId());
        stmt.setInt(5, p.getConvenio().getId());
        stmt.setInt(6, p.getId());
        stmt.executeUpdate();
        stmt.close();
        minhaconexao.close();
        return "Paciente atualizado com sucesso";
    }

    public String deletar(int id) throws SQLException {
        String sql = "DELETE FROM TB_PACIENTE WHERE ID_PACIENTE=?";
        PreparedStatement stmt = minhaconexao.prepareStatement(sql);
        stmt.setInt(1, id);
        stmt.executeUpdate();
        stmt.close();
        minhaconexao.close();
        return "Paciente deletado com sucesso";
    }

    public List<Paciente> selecionar() throws SQLException {
        List<Paciente> lista = new ArrayList<>();
        String sql = "SELECT ID_PACIENTE, NM_PACIENTE, NR_CPF, NR_TELEFONE, ID_ENDERECO, ID_CONVENIO FROM TB_PACIENTE";
        PreparedStatement stmt = minhaconexao.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Paciente p = new Paciente();
            p.setId(rs.getInt("ID_PACIENTE"));
            p.setNome(rs.getString("NM_PACIENTE"));
            p.setCpf(rs.getString("NR_CPF"));
            p.setTelefone(rs.getString("NR_TELEFONE"));
            lista.add(p);
        }
        rs.close();
        stmt.close();
        minhaconexao.close();
        return lista;
    }
}
