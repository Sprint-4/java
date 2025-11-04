package br.com.fiap.dao;

import br.com.fiap.beans.Endereco;
// import br.com.fiap.beans.Paciente; // Import não utilizado nesta classe
import br.com.fiap.conexoes.ConexaoFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EnderecoDAO {

    // 1. CORREÇÃO DE CONEXÃO
    // Removido 'static' para ser uma variável de instância.
    public Connection minhaconexao;

    public EnderecoDAO() throws SQLException, ClassNotFoundException {
        this.minhaconexao = new ConexaoFactory().conexao();
    }

    // --- INSERT ---
    // 2. CORREÇÃO DO INSERT
    public String inserir(Endereco endereco) throws SQLException {
        // CORREÇÃO:
        // 1. Nome da tabela (TB_ENDERECO)
        // 2. Sintaxe SQL (VALUES)
        // 3. Nomes das colunas (ID_ENDERECO, NM_RUA, NR_ENDERECO, NM_CIDADE, SG_ESTADO)
        PreparedStatement stmt = minhaconexao.prepareStatement(
                "INSERT INTO TB_ENDERECO (ID_ENDERECO, NM_RUA, NR_ENDERECO, NM_CIDADE, SG_ESTADO) " +
                        "VALUES (?, ?, ?, ?, ?)");

        stmt.setInt(1, endereco.getId());
        stmt.setString(2, endereco.getRua());
        stmt.setString(3, endereco.getNumero());
        stmt.setString(4, endereco.getCidade());
        stmt.setString(5, endereco.getEstado());

        stmt.execute();
        stmt.close();

        return "Endereço cadastrado com sucesso";
    }

    // --- DELETE ---
    // 3. CORREÇÃO DO DELETE
    public String deletar(int id) throws SQLException { // Removido 'static'
        // CORREÇÃO:
        // 1. Removido 'static' do método.
        // 2. Nome da tabela (TB_ENDERECO)
        // 3. Nome da coluna (ID_ENDERECO)
        PreparedStatement stmt = minhaconexao.prepareStatement(
                "DELETE FROM TB_ENDERECO WHERE ID_ENDERECO = ?");

        stmt.setInt(1, id);

        stmt.execute();
        stmt.close();

        return "Endereço deletado com sucesso";
    }

    // --- UPDATE ---
    // 4. CORREÇÃO DO UPDATE
    public String atualizar(Endereco endereco) throws SQLException { // Removido 'static'
        // CORREÇÃO:
        // 1. Removido 'static' do método.
        // 2. Nome da tabela (TB_ENDERECO)
        // 3. Sintaxe SQL (SET col1 = ?, ... WHERE id = ?)
        // 4. Nomes das colunas (NM_RUA, NR_ENDERECO, NM_CIDADE, SG_ESTADO, ID_ENDERECO)
        // 5. Ordem correta dos parâmetros (o WHERE vai por último)
        PreparedStatement stmt = minhaconexao.prepareStatement(
                "UPDATE TB_ENDERECO SET NM_RUA = ?, NR_ENDERECO = ?, NM_CIDADE = ?, SG_ESTADO = ? " +
                        "WHERE ID_ENDERECO = ?");

        // A ordem dos 'set' deve bater com a SQL
        stmt.setString(1, endereco.getRua());
        stmt.setString(2, endereco.getNumero());
        stmt.setString(3, endereco.getCidade());
        stmt.setString(4, endereco.getEstado());
        stmt.setInt(5, endereco.getId()); // O WHERE (ID_ENDERECO) é o último

        stmt.executeUpdate();
        stmt.close();

        return "Endereço atualizado com sucesso!";
    }

    // --- SELECT ---
    // 5. CORREÇÃO DO SELECT
    public List<Endereco> selecionar() throws SQLException {
        ArrayList<Endereco> listaEnderecos = new ArrayList<>(); // Mudei o nome

        // CORREÇÃO:
        // 1. Nome da tabela (TB_ENDERECO)
        // 2. Boa prática: especificar colunas ao invés de 'select *'
        PreparedStatement stmt = minhaconexao.prepareStatement(
                "SELECT ID_ENDERECO, NM_RUA, NR_ENDERECO, NM_CIDADE, SG_ESTADO FROM TB_ENDERECO");

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Endereco objEndereco = new Endereco();

            // CORREÇÃO: Usando nomes das colunas (mais seguro que índices)
            objEndereco.setId(rs.getInt("ID_ENDERECO"));
            objEndereco.setRua(rs.getString("NM_RUA"));
            objEndereco.setNumero(rs.getString("NR_ENDERECO"));
            objEndereco.setCidade(rs.getString("NM_CIDADE"));
            objEndereco.setEstado(rs.getString("SG_ESTADO"));

            listaEnderecos.add(objEndereco);
        }

        rs.close(); // Fechando o ResultSet
        stmt.close();

        return listaEnderecos;
    }
}