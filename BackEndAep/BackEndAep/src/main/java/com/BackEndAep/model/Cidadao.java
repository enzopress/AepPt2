package com.BackEndAep.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
public class Cidadao extends Usuario{


    @Column(name = "\"Cpf\"", nullable = false)
    private String cpf = "";
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
