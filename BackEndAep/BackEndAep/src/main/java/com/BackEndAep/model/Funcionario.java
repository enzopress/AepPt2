package com.BackEndAep.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
public class Funcionario extends Usuario{
 
    @Column(name = "\"Matricula\"", nullable = false)
    private String matricula = "";

    public String getMatricula() {
        return matricula;
    }
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
}
