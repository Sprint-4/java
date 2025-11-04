package br.com.fiap.beans;

public class Usuario {
    private int id;
    private String senha;

    public Usuario() {}

    public Usuario(int id, String senha) {
        this.id = id;
        this.senha = senha;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; }
}
