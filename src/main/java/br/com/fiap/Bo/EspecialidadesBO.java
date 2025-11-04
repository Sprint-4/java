package br.com.fiap.Bo;


import br.com.fiap.beans.Especialidades;
import br.com.fiap.dao.EspecialidadesDAO;
import java.sql.SQLException;
import java.util.ArrayList;

public class EspecialidadesBO {


    public EspecialidadesDAO especialidadesDAO;

    //Selecionar

    public ArrayList<Especialidades> selecionarBo() throws SQLException, ClassNotFoundException {
          especialidadesDAO= new EspecialidadesDAO();

        // Regra de negócios

        return (ArrayList<Especialidades>) especialidadesDAO.selecionar();
    }

    //Inserir
    public void inserirBo(Especialidades especialidades) throws SQLException, ClassNotFoundException {
        EspecialidadesDAO especialidadesDAO = new EspecialidadesDAO();

        // Regra de negócios

        especialidadesDAO.inserir(especialidades);
    }

    //Deletar
    public void deletarBo(int codigo) throws SQLException, ClassNotFoundException {
        EspecialidadesDAO especialidadesDAO = new EspecialidadesDAO();

        // Regra de negócios

        especialidadesDAO.deletar(codigo);
    }

    //Atualizar
    public void atualizarBo(Especialidades especialidades) throws SQLException, ClassNotFoundException {
        EspecialidadesDAO especialidadesDAO = new EspecialidadesDAO();

        // Regra de negócios

        especialidadesDAO.atualizar(especialidades);
    }

}

