package br.com.fiap.beans;

public class Paciente {

    private int id;
    private String nome;
    private String cpf;
    private String telefone;
    private Endereco endereco;
    private Convenio convenio;

    public Paciente() {}

    public Paciente(int id, String nome, String cpf, String telefone, Endereco endereco, Convenio convenio) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.endereco = endereco;
        this.convenio = convenio;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
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


}





