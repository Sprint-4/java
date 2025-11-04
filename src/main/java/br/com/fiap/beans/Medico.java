package br.com.fiap.beans;

public class Medico {
    private int id;
    private String nome;
    private String crm;
    private Especialidades especialidades;

    public Medico() {}

    public Medico(int id, String nome, String crm, Especialidades especialidades) {
        this.id = id;
        this.nome = nome;
        this.crm = crm;
        this.especialidades = especialidades;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getCrm() { return crm; }
    public void setCrm(String crm) { this.crm = crm; }
    public Especialidades getEspecialidade() { return especialidades; }
    public void setEspecialidade(Especialidades especialidades) { this.especialidades = especialidades; }
}


