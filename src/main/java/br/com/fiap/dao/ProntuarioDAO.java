package br.com.fiap.dao;

// 1. CORREÇÃO DE IMPORTS
// br.com.fiap.beans.Consulta; // Import não utilizado
import br.com.fiap.beans.Paciente; // Importação necessária
import br.com.fiap.beans.Prontuario;
import br.com.fiap.conexoes.ConexaoFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProntuarioDAO {

    public Connection minhaconexao;

    public ProntuarioDAO() throws SQLException, ClassNotFoundException {
        this.minhaconexao = new ConexaoFactory().conexao();
    }

    public String inserir(Prontuario prontuario) throws SQLException {

        PreparedStatement stmt = minhaconexao.prepareStatement(
                "INSERT INTO TB_PRONTUARIO (ID_PRONTUARIO, ID_PACIENTE, DS_HISTORICO) VALUES (?, ?, ?)");

        stmt.setInt(1, prontuario.getId());
        stmt.setInt(2, prontuario.getPaciente().getId()); // Pegando o ID do objeto Paciente
        stmt.setString(3, prontuario.getHistorico());

        stmt.execute();
        stmt.close();

        return "Prontuário cadastrado com sucesso";
    }

    // --- DELETE ---

    public String deletar(int id) throws SQLException {
        PreparedStatement stmt = minhaconexao.prepareStatement(
                "DELETE FROM TB_PRONTUARIO WHERE ID_PRONTUARIO = ?");

        stmt.setInt(1, id);

        stmt.execute();
        stmt.close();

        return "Prontuário deletado com sucesso";
    }

    // --- UPDATE ---

    public String atualizar(Prontuario prontuario) throws SQLException {

        PreparedStatement stmt = minhaconexao.prepareStatement(
                "UPDATE TB_PRONTUARIO SET ID_PACIENTE = ?, DS_HISTORICO = ? WHERE ID_PRONTUARIO = ?");

        // A ordem dos 'set' deve bater com a SQL
        stmt.setInt(1, prontuario.getPaciente().getId());
        stmt.setString(2, prontuario.getHistorico());
        stmt.setInt(3, prontuario.getId());

        stmt.executeUpdate();
        stmt.close();

        return "Prontuário atualizado com sucesso!";
    }


    public List<Prontuario> selecionar() throws SQLException {
        ArrayList<Prontuario> listaProntuarios = new ArrayList<>(); // Mudei o nome


        PreparedStatement stmt = minhaconexao.prepareStatement(
                "SELECT " +
                        "    PR.ID_PRONTUARIO, PR.DS_HISTORICO, " +
                        "    PA.ID_PACIENTE, PA.NM_PACIENTE, PA.NR_CPF " +
                        "FROM " +
                        "    TB_PRONTUARIO PR " +
                        "INNER JOIN " +
                        "    TB_PACIENTE PA ON PR.ID_PACIENTE = PA.ID_PACIENTE");

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            // Criando os objetos para popular
            Prontuario objProntuario = new Prontuario();
            Paciente objPaciente = new Paciente();

            // 1. Populando o Paciente
            objPaciente.setId(rs.getInt("ID_PACIENTE"));
            objPaciente.setNome(rs.getString("NM_PACIENTE"));
            objPaciente.setCpf(rs.getString("NR_CPF"));


            // 2. Populando o Prontuário
            objProntuario.setId(rs.getInt("ID_PRONTUARIO"));
            objProntuario.setHistorico(rs.getString("DS_HISTORICO"));

            // Associando o paciente ao prontuário
            objProntuario.setPaciente(objPaciente);

            listaProntuarios.add(objProntuario);
        }

        rs.close();
        stmt.close();

        return listaProntuarios;
    }
}