package br.com.fiap.Bo;
import br.com.fiap.beans.Medico;
import br.com.fiap.dao.MedicoDAO;
import java.sql.SQLException;
import java.util.ArrayList;

public class MedicoBO {


    public MedicoDAO medicoDAO;


    //Selecionar

    public ArrayList<Medico> selecionarBo() throws SQLException, ClassNotFoundException {
        medicoDAO = new MedicoDAO();

        // Regra de negócios

        return (ArrayList<Medico>) medicoDAO.selecionar();
    }

    //Inserir
    public void inserirBo(Medico medico) throws SQLException, ClassNotFoundException {
        MedicoDAO medicoDAO = new MedicoDAO();

        // Regra de negócios

        medicoDAO.inserir(medico);
    }

    //Deletar
    public void deletarBo(int codigo) throws SQLException, ClassNotFoundException {
        MedicoDAO medicoDAO = new MedicoDAO();

        // Regra de negócios

        medicoDAO.deletar(codigo);
    }

    //Atualizar
    public void atualizarBo(Medico medico) throws SQLException, ClassNotFoundException {
        MedicoDAO medicoDAO = new MedicoDAO();

        // Regra de negócios

        medicoDAO.atualizar(medico);
    }

}
