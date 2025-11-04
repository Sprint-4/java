package br.com.fiap.Bo;


import br.com.fiap.beans.Paciente;
import br.com.fiap.dao.PacienteDAO;
import java.sql.SQLException;
import java.util.ArrayList;

public class PacienteBO {

    public PacienteDAO pacienteDAO;


    //Selecionar

    public ArrayList<Paciente> selecionarBo() throws SQLException, ClassNotFoundException {
        pacienteDAO= new PacienteDAO();

        // Regra de negócios

        return (ArrayList<Paciente>)  pacienteDAO.selecionar();
    }

    //Inserir
    public void inserirBo(Paciente paciente) throws SQLException, ClassNotFoundException {
        PacienteDAO pacienteDAO = new PacienteDAO();

        // Regra de negócios

        pacienteDAO.inserir(paciente);
    }

    //Deletar
    public void deletarBo(int codigo) throws SQLException, ClassNotFoundException {
        PacienteDAO pacienteDAO = new PacienteDAO();

        // Regra de negócios

        pacienteDAO.deletar(codigo);
    }

    //Atualizar
    public void atualizarBo(Paciente paciente) throws SQLException, ClassNotFoundException {
        PacienteDAO pacienteDAO = new PacienteDAO();

        // Regra de negócios

        pacienteDAO.atualizar(paciente);
    }

}

