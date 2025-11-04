package br.com.fiap.dao;

import br.com.fiap.beans.Especialidades;
import br.com.fiap.conexoes.ConexaoFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EspecialidadesDAO {

    public Connection minhaconexao;

    public EspecialidadesDAO() throws SQLException, ClassNotFoundException {
        this.minhaconexao = new ConexaoFactory().conexao();
    }

    // --- INSERT ---
    public String inserir(Especialidades especialidades) throws SQLException {
        PreparedStatement stmt = minhaconexao.prepareStatement(
                "INSERT INTO TB_ESPECIALIDADE (ID_ESPECIALIDADE, NM_ESPECIALIDADE) VALUES (?, ?)");

        stmt.setInt(1, especialidades.getId());
        stmt.setString(2, especialidades.getNome());

        stmt.execute();
        stmt.close();

        return "Especialidade cadastrada com sucesso";
    }

    // --- DELETE ---
    public String deletar(int id) throws SQLException {
        PreparedStatement stmt = minhaconexao.prepareStatement(
                "DELETE FROM TB_ESPECIALIDADE WHERE ID_ESPECIALIDADE = ?");

        stmt.setInt(1, id);

        stmt.execute();
        stmt.close();

        return "Especialidade deletada com sucesso";
    }

    // --- UPDATE ---
    public String atualizar(Especialidades especialidades) throws SQLException { // Removido 'static'
        PreparedStatement stmt = minhaconexao.prepareStatement(
                "UPDATE TB_ESPECIALIDADE SET NM_ESPECIALIDADE = ? WHERE ID_ESPECIALIDADE = ?");

        // A ordem dos 'set' deve bater com a SQL
        stmt.setString(1, especialidades.getNome());
        stmt.setInt(2, especialidades.getId());

        stmt.executeUpdate();
        stmt.close();

        return "Especialidade atualizada com sucesso!";
    }

    // --- SELECT ---
    public List<Especialidades> selecionar() throws SQLException {
        ArrayList<Especialidades> listEspecialidades = new ArrayList<>();

        PreparedStatement stmt = minhaconexao.prepareStatement(
                "SELECT ID_ESPECIALIDADE, NM_ESPECIALIDADE FROM TB_ESPECIALIDADE");

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Especialidades objEspecialidades = new Especialidades();


            objEspecialidades.setId(rs.getInt("ID_ESPECIALIDADE"));
            objEspecialidades.setNome(rs.getString("NM_ESPECIALIDADE"));

            listEspecialidades.add(objEspecialidades);
        }

        rs.close();
        stmt.close();

        return listEspecialidades;
    }
}