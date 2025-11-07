package br.com.fiap.beans;

public class Especialidades {
    private int idEspecialidade;
    private String nomeEspecialidade;

    public Especialidades() {}

    public Especialidades(int idEspecialidade, String nomeEspecialidade) {
        this.idEspecialidade = idEspecialidade;
        this.nomeEspecialidade = nomeEspecialidade;
    }

    public int getIdEspecialidade() { return idEspecialidade; }
    public void setIdEspecialidade(int idEspecialidade) { this.idEspecialidade = idEspecialidade; }
    public String getNomeEspecialidade() { return nomeEspecialidade; }
    public void setNomeEspecialidade(String nomeEspecialidade) { this.nomeEspecialidade = nomeEspecialidade; }
}
