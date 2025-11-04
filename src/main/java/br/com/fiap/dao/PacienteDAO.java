package br.com.fiap.dao;

import br.com.fiap.beans.Convenio; // Importação necessária
import br.com.fiap.beans.Endereco; // Importação necessária
import br.com.fiap.beans.Paciente;
import br.com.fiap.conexoes.ConexaoFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PacienteDAO {

    public Connection minhaconexao;

    public PacienteDAO() throws SQLException, ClassNotFoundException {
        this.minhaconexao = new ConexaoFactory().conexao();
    }


    public String inserir(Paciente paciente) throws SQLException {

        PreparedStatement stmt = minhaconexao.prepareStatement(
                "INSERT INTO TB_PACIENTE (ID_PACIENTE, NM_PACIENTE, NR_CPF, NR_TELEFONE, ID_ENDERECO, ID_CONVENIO) " +
                        "VALUES (?, ?, ?, ?, ?, ?)");

        stmt.setInt(1, paciente.getId());
        stmt.setString(2, paciente.getNome()); // Corrigido: Nome é o 2º parâmetro no BD
        stmt.setString(3, paciente.getCpf());   // Corrigido: CPF é o 3º
        stmt.setString(4, paciente.getTelefone());


        stmt.setInt(5, paciente.getEndereco().getId());


        if (paciente.getConvenio() != null) {
            stmt.setInt(6, paciente.getConvenio().getId());
        } else {
            stmt.setNull(6, java.sql.Types.INTEGER);
        }

        stmt.execute();
        stmt.close();

        return "Paciente cadastrado com sucesso";
    }


    public String deletar(int id) throws SQLException {

        PreparedStatement stmt = minhaconexao.prepareStatement(
                "DELETE FROM TB_PACIENTE WHERE ID_PACIENTE = ?");

        stmt.setInt(1, id);

        stmt.execute();
        stmt.close();

        return "Paciente deletado com sucesso";
    }


    public String atualizar(Paciente paciente) throws SQLException {

        PreparedStatement stmt = minhaconexao.prepareStatement(
                "UPDATE TB_PACIENTE SET NM_PACIENTE = ?, NR_CPF = ?, NR_TELEFONE = ?, ID_ENDERECO = ?, ID_CONVENIO = ? " +
                        "WHERE ID_PACIENTE = ?");


        stmt.setString(1, paciente.getNome());
        stmt.setString(2, paciente.getCpf());
        stmt.setString(3, paciente.getTelefone());
        stmt.setInt(4, paciente.getEndereco().getId());


        if (paciente.getConvenio() != null) {
            stmt.setInt(5, paciente.getConvenio().getId());
        } else {
            stmt.setNull(5, java.sql.Types.INTEGER);
        }

        stmt.setInt(6, paciente.getId());

        stmt.executeUpdate();
        stmt.close();

        return "Paciente atualizado com sucesso!";
    }


    public List<Paciente> selecionar() throws SQLException {
        ArrayList<Paciente> listaPacientes = new ArrayList<>();


        PreparedStatement stmt = minhaconexao.prepareStatement(
                "SELECT " +
                        "    P.ID_PACIENTE, P.NM_PACIENTE, P.NR_CPF, P.NR_TELEFONE, " + // Dados do Paciente
                        "    E.ID_ENDERECO, E.NM_RUA, E.NR_ENDERECO, E.NM_CIDADE, E.SG_ESTADO, " + // Dados do Endereço
                        "    C.ID_CONVENIO, C.NM_CONVENIO, C.DS_COBERTURA " + // Dados do Convênio
                        "FROM " +
                        "    TB_PACIENTE P " +
                        "INNER JOIN " + // Endereço é obrigatório
                        "    TB_ENDERECO E ON P.ID_ENDERECO = E.ID_ENDERECO " +
                        "LEFT JOIN " + // Convênio é opcional
                        "    TB_CONVENIO C ON P.ID_CONVENIO = C.ID_CONVENIO");

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            // Criando os objetos para popular
            Paciente objPaciente = new Paciente();
            Endereco objEndereco = new Endereco();

            // 1. Populando o Endereço
            objEndereco.setId(rs.getInt("ID_ENDERECO"));
            objEndereco.setRua(rs.getString("NM_RUA"));
            objEndereco.setNumero(rs.getString("NR_ENDERECO"));
            objEndereco.setCidade(rs.getString("NM_CIDADE"));
            objEndereco.setEstado(rs.getString("SG_ESTADO"));

            // 2. Populando o Paciente
            objPaciente.setId(rs.getInt("ID_PACIENTE"));
            objPaciente.setNome(rs.getString("NM_PACIENTE"));
            objPaciente.setCpf(rs.getString("NR_CPF"));
            objPaciente.setTelefone(rs.getString("NR_TELEFONE"));

            // Associando o endereço ao paciente
            objPaciente.setEndereco(objEndereco);


            int convenioId = rs.getInt("ID_CONVENIO");
            if (!rs.wasNull()) {
                Convenio objConvenio = new Convenio();
                objConvenio.setId(convenioId);
                objConvenio.setNome(rs.getString("NM_CONVENIO"));
                objConvenio.setCobertura(rs.getString("DS_COBERTURA"));

                // Associando o convênio ao paciente
                objPaciente.setConvenio(objConvenio);
            } else {
                objPaciente.setConvenio(null);
            }

            listaPacientes.add(objPaciente);
        }

        rs.close();
        stmt.close();

        return listaPacientes;
    }
}