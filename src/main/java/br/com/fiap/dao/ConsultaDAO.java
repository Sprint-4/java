package br.com.fiap.dao;

import br.com.fiap.beans.Consulta;
import br.com.fiap.beans.Medico; // Importação necessária
import br.com.fiap.beans.Paciente;
import br.com.fiap.conexoes.ConexaoFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp; // Importação necessária
import java.time.LocalDateTime; // Importação necessária
import java.util.ArrayList;
import java.util.List;

public class ConsultaDAO {

    // 1. CORREÇÃO DE CONEXÃO
    // Removido 'static' para que cada instância do DAO tenha sua própria conexão,
    // o que é uma prática mais segura e evita conflitos.
    public Connection minhaconexao;

    public ConsultaDAO() throws SQLException, ClassNotFoundException {
        this.minhaconexao = new ConexaoFactory().conexao();
    }

    // --- INSERT ---
    // 2. CORREÇÃO DO INSERT
    public String inserir(Consulta consulta) throws SQLException {
        // CORREÇÃO:
        // 1. Nome da tabela (TB_CONSULTA)
        // 2. Sintaxe SQL (VALUES)
        // 3. Colunas corretas (ID_CONSULTA, ID_PACIENTE, ID_MEDICO, DT_CONSULTA, DS_STATUS)
        // 4. Conversão de LocalDateTime para Timestamp
        PreparedStatement stmt = minhaconexao.prepareStatement(
                "INSERT INTO TB_CONSULTA (ID_CONSULTA, ID_PACIENTE, ID_MEDICO, DT_CONSULTA, DS_STATUS) " +
                        "VALUES (?, ?, ?, ?, ?)");

        stmt.setInt(1, consulta.getId());
        stmt.setInt(2, consulta.getPaciente().getId()); // Pegando o ID do objeto Paciente
        stmt.setInt(3, consulta.getMedico().getId());   // Pegando o ID do objeto Medico

        // Convertendo LocalDateTime (Java) para Timestamp (SQL)
        stmt.setTimestamp(4, Timestamp.valueOf(consulta.getDataHora()));

        stmt.setString(5, consulta.getStatus());

        stmt.execute();
        stmt.close();

        return "Consulta cadastrada com sucesso";
    }

    // --- DELETE ---
    // 3. CORREÇÃO DO DELETE
    public String deletar(int id) throws SQLException {
        // CORREÇÃO:
        // 1. Nome da tabela (TB_CONSULTA)
        // 2. Nome da coluna (ID_CONSULTA)
        PreparedStatement stmt = minhaconexao.prepareStatement(
                "DELETE FROM TB_CONSULTA WHERE ID_CONSULTA = ?");

        stmt.setInt(1, id);

        stmt.execute();
        stmt.close();

        return "Consulta deletada com sucesso";
    }

    // --- UPDATE ---
    // 4. CORREÇÃO DO UPDATE
    public String atualizar(Consulta consulta) throws SQLException { // Removido 'static'
        // CORREÇÃO:
        // 1. Nome da tabela (TB_CONSULTA)
        // 2. Sintaxe SQL (SET col1 = ?, ... WHERE id = ?)
        // 3. Nomes das colunas corretos
        // 4. Ordem correta dos parâmetros
        // 5. Adição do WHERE
        PreparedStatement stmt = minhaconexao.prepareStatement(
                "UPDATE TB_CONSULTA SET ID_PACIENTE = ?, ID_MEDICO = ?, DT_CONSULTA = ?, DS_STATUS = ? " +
                        "WHERE ID_CONSULTA = ?");

        // A ordem dos 'set' deve bater com a SQL
        stmt.setInt(1, consulta.getPaciente().getId());
        stmt.setInt(2, consulta.getMedico().getId());
        stmt.setTimestamp(3, Timestamp.valueOf(consulta.getDataHora()));
        stmt.setString(4, consulta.getStatus());
        stmt.setInt(5, consulta.getId()); // O WHERE (ID_CONSULTA) é o último

        stmt.executeUpdate();
        stmt.close();

        return "Consulta atualizada com sucesso!";
    }

    // --- SELECT ---
    public List<Consulta> selecionar() throws SQLException {
        ArrayList<Consulta> listaConsultas = new ArrayList<>();
        PreparedStatement stmt = minhaconexao.prepareStatement(
                "SELECT " +
                        "    C.ID_CONSULTA, C.DT_CONSULTA, C.DS_STATUS, " +
                        "    P.ID_PACIENTE, P.NM_PACIENTE, P.NR_CPF, " +
                        "    M.ID_MEDICO, M.NM_MEDICO, M.NR_CRM " +
                        "FROM " +
                        "    TB_CONSULTA C " +
                        "INNER JOIN " +
                        "    TB_PACIENTE P ON C.ID_PACIENTE = P.ID_PACIENTE " +
                        "INNER JOIN " +
                        "    TB_MEDICO M ON C.ID_MEDICO = M.ID_MEDICO");

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Consulta objConsulta = new Consulta();
            Paciente objPaciente = new Paciente();
            Medico objMedico = new Medico();


            // 1. Populando o Paciente
            objPaciente.setId(rs.getInt("ID_PACIENTE"));
            objPaciente.setNome(rs.getString("NM_PACIENTE"));
            objPaciente.setCpf(rs.getString("NR_CPF"));


            // 2. Populando o Medico
            objMedico.setId(rs.getInt("ID_MEDICO"));
            objMedico.setNome(rs.getString("NM_MEDICO"));
            objMedico.setCrm(rs.getString("NR_CRM"));


            // 3. Populando a Consulta
            objConsulta.setId(rs.getInt("ID_CONSULTA"));
            objConsulta.setStatus(rs.getString("DS_STATUS"));


            objConsulta.setDataHora(rs.getTimestamp("DT_CONSULTA").toLocalDateTime());

            // Associando os objetos
            objConsulta.setPaciente(objPaciente);
            objConsulta.setMedico(objMedico);

            listaConsultas.add(objConsulta);
        }

        rs.close();
        stmt.close();

        return listaConsultas;
    }
}