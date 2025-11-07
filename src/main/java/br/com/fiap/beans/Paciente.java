package br.com.fiap.beans;

public class Paciente {
    private int idPaciente;
    private String nome;
    private String cpf;
    private String telefone;
    private Endereco endereco;
    private Convenio convenio;

    public Paciente() {}

    public Paciente(int idPaciente, String nome, String cpf, String telefone, Endereco endereco, Convenio convenio) {
        this.idPaciente = idPaciente;
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.endereco = endereco;
        this.convenio = convenio;
    }

    public Paciente(int idPaciente, String nome, String cpf, String telefone, int idEndereco, int idConvenio) {
        this.idPaciente = idPaciente;
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.endereco = new Endereco();
        this.endereco.setIdEndereco(idEndereco);
        this.convenio = new Convenio();
        this.convenio.setIdConvenio(idConvenio);
    }

    public int getIdPaciente() { return idPaciente; }
    public void setIdPaciente(int idPaciente) { this.idPaciente = idPaciente; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }
    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }
    public Endereco getEndereco() { return endereco; }
    public void setEndereco(Endereco endereco) { this.endereco = endereco; }
    public Convenio getConvenio() { return convenio; }
    public void setConvenio(Convenio convenio) { this.convenio = convenio; }
    public int getIdEndereco() { return (endereco != null) ? endereco.getIdEndereco() : 0; }
    public int getIdConvenio() { return (convenio != null) ? convenio.getIdConvenio() : 0; }
}
