package br.com.fiap.dao;

import br.com.fiap.beans.Convenio;
// import br.com.fiap.beans.Paciente; // Import não utilizado nesta classe
import br.com.fiap.conexoes.ConexaoFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConvenioDAO {

    // 1. CORREÇÃO DE CONEXÃO
    public Connection minhaconexao;

    public ConvenioDAO() throws SQLException, ClassNotFoundException {
        this.minhaconexao = new ConexaoFactory().conexao();
    }

    // --- INSERT ---
    public String inserir(Convenio convenio) throws SQLException {
        PreparedStatement stmt = minhaconexao.prepareStatement(
                "INSERT INTO TB_CONVENIO (ID_CONVENIO, NM_CONVENIO, DS_COBERTURA) VALUES (?, ?, ?)");

        stmt.setInt(1, convenio.getId());
        stmt.setString(2, convenio.getNome());
        stmt.setString(3, convenio.getCobertura());

        stmt.execute();
        stmt.close();

        return "Convenio cadastrado com sucesso";
    }

    // --- DELETE ---
    public String deletar(int id) throws SQLException {
        PreparedStatement stmt = minhaconexao.prepareStatement(
                "DELETE FROM TB_CONVENIO WHERE ID_CONVENIO = ?");

        stmt.setInt(1, id);

        stmt.execute();
        stmt.close();

        return "Convenio deletado com sucesso";
    }

    // --- UPDATE ---

    public String atualizar(Convenio convenio) throws SQLException { // Removido 'static'
        PreparedStatement stmt = minhaconexao.prepareStatement(
                "UPDATE TB_CONVENIO SET NM_CONVENIO = ?, DS_COBERTURA = ? WHERE ID_CONVENIO = ?");


        stmt.setString(1, convenio.getNome());
        stmt.setString(2, convenio.getCobertura());
        stmt.setInt(3, convenio.getId()); // O WHERE (ID_CONVENIO) é o último

        stmt.executeUpdate();
        stmt.close();

        return "Convenio atualizado com sucesso!";
    }

    // --- SELECT ---
    public List<Convenio> selecionar() throws SQLException {
        ArrayList<Convenio> listaConvenios = new ArrayList<>(); // Mudei o nome


        PreparedStatement stmt = minhaconexao.prepareStatement(
                "SELECT ID_CONVENIO, NM_CONVENIO, DS_COBERTURA FROM TB_CONVENIO");

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Convenio objConvenio = new Convenio();


            objConvenio.setId(rs.getInt("ID_CONVENIO"));
            objConvenio.setNome(rs.getString("NM_CONVENIO"));
            objConvenio.setCobertura(rs.getString("DS_COBERTURA"));

            listaConvenios.add(objConvenio);
        }

        rs.close();
        stmt.close();

        return listaConvenios;
    }
}