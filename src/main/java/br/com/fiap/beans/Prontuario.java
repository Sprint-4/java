package br.com.fiap.beans;

public class Prontuario {
    private int idProntuario;
    private Paciente paciente;
    private String historico;

    public Prontuario() {}

    public Prontuario(int idProntuario, Paciente paciente, String historico) {
        this.idProntuario = idProntuario;
        this.paciente = paciente;
        this.historico = historico;
    }

    public Prontuario(int idProntuario, int idPaciente, String historico) {
        this.idProntuario = idProntuario;
        this.paciente = new Paciente();
        this.paciente.setIdPaciente(idPaciente);
        this.historico = historico;
    }

    public int getIdProntuario() { return idProntuario; }
    public void setIdProntuario(int idProntuario) { this.idProntuario = idProntuario; }
    public Paciente getPaciente() { return paciente; }
    public void setPaciente(Paciente paciente) { this.paciente = paciente; }
    public String getHistorico() { return historico; }
    public void setHistorico(String historico) { this.historico = historico; }
    public int getIdPaciente() { return (paciente != null) ? paciente.getIdPaciente() : 0; }
}
