package br.com.fiap.main;

import br.com.fiap.beans.Prontuario;
import br.com.fiap.beans.Usuario;
import br.com.fiap.dao.UsuarioDAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TesteSelecionarUsuario {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        UsuarioDAO usuarioDAO = new UsuarioDAO();

        List<Usuario> listaUsuario = (ArrayList<Usuario>)usuarioDAO.selecionar();

        if(listaUsuario != null){
            for(Usuario a : listaUsuario){
                System.out.println(
                        a.getId() + " " +
                                a.getId() + " " +
                                a.getLogin() + " " +
                                a.getPerfil()+ " " +
                                a.getSenha()+ " "



                );
            }
        }

    }

}

