package com.BackEndAep.model;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "\"Protocolos\"")
public class Protocolo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"NumeroProtocolo\"", nullable = false)
    private Integer numeroProtocolo;
    @Column(name = "\"CpfSolicitante\"", nullable = false)
    private String cpfSolicitante = "";


    @Column(name = "\"Tipo\"", nullable = false)
    private int tipo;

    @Column(name = "\"Descricao\"", nullable = false)
    private String descricao = "";

    @Column(name = "\"Cep\"", nullable = false)
    private String cep = "";

    @Column(name = "\"Rua\"", nullable = false)
    private String rua = "";

    @Column(name = "\"Numero\"", nullable = false)
    private int numero;

    @Column(name = "\"Bairro\"", nullable = false)
    private String bairro = "";

    @Column(name = "\"Complemento\"", nullable = false)
    private String complemento = "";

    @Convert(converter = StatusProtocoloConverter.class)
    @Column(name = "\"Status\"", nullable = false)

    private StatusProtocolo status = StatusProtocolo.Aberto;

    public Integer getNumeroProtocolo() {
        return numeroProtocolo;
    }

    public void setNumeroProtocolo(Integer numeroProtocolo) {
        this.numeroProtocolo = numeroProtocolo;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public StatusProtocolo getStatus() {
        return status;
    }

    public void setStatus(StatusProtocolo status) {
        this.status = status;
    }
    public String getCpfSolicitante() {
        return cpfSolicitante;
    }

    public void setCpfSolicitante(String cpfSolicitante) {
        this.cpfSolicitante = cpfSolicitante;
    }

}
