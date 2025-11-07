package br.com.fiap.beans;

public class Endereco {
    private int idEndereco;
    private String nomeRua;
    private int numero;
    private String cidade;
    private String estado;
    private String cep;

    public Endereco() {}

    public Endereco(int idEndereco, String nomeRua, int numero, String cidade, String estado, String cep) {
        this.idEndereco = idEndereco;
        this.nomeRua = nomeRua;
        this.numero = numero;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
    }

    public int getIdEndereco() { return idEndereco; }
    public void setIdEndereco(int idEndereco) { this.idEndereco = idEndereco; }
    public String getNomeRua() { return nomeRua; }
    public void setNomeRua(String nomeRua) { this.nomeRua = nomeRua; }
    public int getNumero() { return numero; }
    public void setNumero(int numero) { this.numero = numero; }
    public String getCidade() { return cidade; }
    public void setCidade(String cidade) { this.cidade = cidade; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
    public String getCep() { return cep; }
    public void setCep(String cep) { this.cep = cep; }
}
