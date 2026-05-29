package com.univet.br.tutor.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "tutores")
public class Tutor {

    @Id
    private String id;
    private String nomeCompletoTutor;
    private String cpf;
    private String telefone;
    private String rua;
    private String numero;
    private String bairro;

    public Tutor() {}

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getNomeCompletoTutor() { return nomeCompletoTutor; }
    public void setNomeCompletoTutor(String nomeCompletoTutor) { this.nomeCompletoTutor = nomeCompletoTutor; }

    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }

    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }

    public String getRua() { return rua; }
    public void setRua(String rua) { this.rua = rua; }

    public String getNumero() { return numero; }
    public void setNumero(String numero) { this.numero = numero; }

    public String getBairro() { return bairro; }
    public void setBairro(String bairro) { this.bairro = bairro; }
}
