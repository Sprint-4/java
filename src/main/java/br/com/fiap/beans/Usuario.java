package br.com.fiap.beans;

public class Usuario {
    private int idUsuario;
    private String senha;

    public Usuario() {}

    public Usuario(int idUsuario, String senha) {
        this.idUsuario = idUsuario;
        this.senha = senha;
    }

    public int getIdUsuario() { return idUsuario; }
    public void setIdUsuario(int idUsuario) { this.idUsuario = idUsuario; }
    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; }
}
