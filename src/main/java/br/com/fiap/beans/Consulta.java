package br.com.fiap.beans;

import java.time.LocalDateTime;

public class Consulta {
  private int idConsulta;
  private Paciente paciente;
  private Medico medico;
  private LocalDateTime dataHora;
  private String status;

  public Consulta() {}

  public Consulta(int idConsulta, Paciente paciente, Medico medico, LocalDateTime dataHora, String status) {
    this.idConsulta = idConsulta;
    this.paciente = paciente;
    this.medico = medico;
    this.dataHora = dataHora;
    this.status = status;
  }

  public Consulta(int idConsulta, int idPaciente, int idMedico, LocalDateTime dataHora, String status) {
    this.idConsulta = idConsulta;
    this.paciente = new Paciente();
    this.paciente.setIdPaciente(idPaciente);
    this.medico = new Medico();
    this.medico.setIdMedico(idMedico);
    this.dataHora = dataHora;
    this.status = status;
  }

  public int getIdConsulta() { return idConsulta; }
  public void setIdConsulta(int idConsulta) { this.idConsulta = idConsulta; }
  public Paciente getPaciente() { return paciente; }
  public void setPaciente(Paciente paciente) { this.paciente = paciente; }
  public Medico getMedico() { return medico; }
  public void setMedico(Medico medico) { this.medico = medico; }
  public LocalDateTime getDataHora() { return dataHora; }
  public void setDataHora(LocalDateTime dataHora) { this.dataHora = dataHora; }
  public String getStatus() { return status; }
  public void setStatus(String status) { this.status = status; }
  public int getIdPaciente() { return (paciente != null) ? paciente.getIdPaciente() : 0; }
  public int getIdMedico() { return (medico != null) ? medico.getIdMedico() : 0; }
}
