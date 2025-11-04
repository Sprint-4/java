package br.com.fiap.beans;

public class Convenio {
    private int id;
    private String nome;
    private String cobertura;

    public Convenio() {}

    public Convenio(int id, String nome, String cobertura) {
        this.id = id;
        this.nome = nome;
        this.cobertura = cobertura;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getCobertura() { return cobertura; }
    public void setCobertura(String cobertura) { this.cobertura = cobertura; }
}
