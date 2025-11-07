package br.com.fiap.beans;

public class Convenio {
    private int idConvenio;
    private String nome;
    private String descricao;

    public Convenio() {}

    public Convenio(int idConvenio, String nome, String descricao) {
        this.idConvenio = idConvenio;
        this.nome = nome;
        this.descricao = descricao;
    }

    public int getIdConvenio() { return idConvenio; }
    public void setIdConvenio(int idConvenio) { this.idConvenio = idConvenio; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
}
