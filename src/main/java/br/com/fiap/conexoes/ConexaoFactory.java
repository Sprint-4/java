package br.com.fiap.conexoes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoFactory {

    public static Connection conexao() throws SQLException {
        String url = System.getenv("DB_URL");
        String usuario = System.getenv("DB_USER");
        String senha = System.getenv("DB_PASSWORD");

        if (url == null || usuario == null || senha == null) {
            url = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";
            usuario = "RM563405";
            senha = "250307";
        }

        return DriverManager.getConnection(url, usuario, senha);
    }
}
