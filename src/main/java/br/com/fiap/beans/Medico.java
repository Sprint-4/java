package br.com.fiap.beans;

public class Medico {
    private int idMedico;
    private String nome;
    private String crm;
    private Especialidades especialidade;

    public Medico() {}

    public Medico(int idMedico, String nome, String crm, Especialidades especialidade) {
        this.idMedico = idMedico;
        this.nome = nome;
        this.crm = crm;
        this.especialidade = especialidade;
    }

    public Medico(int idMedico, String nome, String crm, int idEspecialidade) {
        this.idMedico = idMedico;
        this.nome = nome;
        this.crm = crm;
        this.especialidade = new Especialidades();
        this.especialidade.setIdEspecialidade(idEspecialidade);
    }

    public int getIdMedico() { return idMedico; }
    public void setIdMedico(int idMedico) { this.idMedico = idMedico; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getCrm() { return crm; }
    public void setCrm(String crm) { this.crm = crm; }
    public Especialidades getEspecialidade() { return especialidade; }
    public void setEspecialidade(Especialidades especialidade) { this.especialidade = especialidade; }
    public int getIdEspecialidade() { return (especialidade != null) ? especialidade.getIdEspecialidade() : 0; }
}
