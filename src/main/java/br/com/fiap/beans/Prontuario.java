package br.com.fiap.beans;

public class Prontuario {
    private int id;
    private Paciente paciente;
    private String historico;

    public Prontuario() {}

    public Prontuario(int id, Paciente paciente, String historico) {
        this.id = id;
        this.paciente = paciente;
        this.historico = historico;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public Paciente getPaciente() { return paciente; }
    public void setPaciente(Paciente paciente) { this.paciente = paciente; }
    public String getHistorico() { return historico; }
    public void setHistorico(String historico) { this.historico = historico; }
}
