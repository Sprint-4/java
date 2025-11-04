package br.com.fiap.dao;

// 1. IMPORT NECESSÁRIO (Estava faltando)
import br.com.fiap.beans.Especialidades;
import br.com.fiap.beans.Medico;
import br.com.fiap.conexoes.ConexaoFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MedicoDAO {


    public static Connection minhaconexao;

    public MedicoDAO() throws SQLException, ClassNotFoundException {

        this.minhaconexao = new ConexaoFactory().conexao();
    }

    // --- INSERT ---

    public String inserir(Medico medico) throws SQLException {
        PreparedStatement stmt = minhaconexao.prepareStatement(
                "INSERT INTO TB_MEDICO (ID_MEDICO, NM_MEDICO, NR_CRM, ID_ESPECIALIDADE) VALUES (?, ?, ?, ?)");

        stmt.setInt(1, medico.getId());
        stmt.setString(2, medico.getNome());
        stmt.setString(3, medico.getCrm());


        stmt.setInt(4, medico.getEspecialidade().getId());

        stmt.execute();
        stmt.close();

        return "Medico cadastrado com sucesso";
    }


    public String deletar(int id) throws SQLException {

        PreparedStatement stmt = minhaconexao.prepareStatement(
                "DELETE FROM TB_MEDICO WHERE ID_MEDICO = ?");

        stmt.setInt(1, id);

        stmt.execute();
        stmt.close();

        return "Medico deletado com sucesso";
    }


    public static String atualizar(Medico medico) throws SQLException {

        PreparedStatement stmt = minhaconexao.prepareStatement(
                "UPDATE TB_MEDICO SET NM_MEDICO = ?, NR_CRM = ?, ID_ESPECIALIDADE = ? WHERE ID_MEDICO = ?");

        // A ordem dos 'set' deve bater com a SQL
        stmt.setString(1, medico.getNome());
        stmt.setString(2, medico.getCrm());
        stmt.setInt(3, medico.getEspecialidade().getId());
        stmt.setInt(4, medico.getId());

        stmt.executeUpdate();
        stmt.close();

        return "Medico atualizado com sucesso!";
    }


    public List<Medico> selecionar() throws SQLException {
        ArrayList<Medico> listaMedicos = new ArrayList<Medico>();

        PreparedStatement stmt = minhaconexao.prepareStatement(
                "SELECT M.ID_MEDICO, M.NM_MEDICO, M.NR_CRM, " +
                        "E.ID_ESPECIALIDADE, E.NM_ESPECIALIDADE " +
                        "FROM TB_MEDICO M " +
                        "INNER JOIN TB_ESPECIALIDADE E ON M.ID_ESPECIALIDADE = E.ID_ESPECIALIDADE");

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Medico objMedico = new Medico();
            Especialidades objEspecialidade = new Especialidades();



            // Populando o Medico
            objMedico.setId(rs.getInt("ID_MEDICO"));
            objMedico.setNome(rs.getString("NM_MEDICO"));
            objMedico.setCrm(rs.getString("NR_CRM"));

            // Populando a Especialidade (graças ao JOIN)
            objEspecialidade.setId(rs.getInt("ID_ESPECIALIDADE"));
            objEspecialidade.setNome(rs.getString("NM_ESPECIALIDADE"));

            // Associando a especialidade ao médico
            objMedico.setEspecialidade(objEspecialidade);

            listaMedicos.add(objMedico);
        }

        rs.close();
        stmt.close();

        return listaMedicos;
    }
}