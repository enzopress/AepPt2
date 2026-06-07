package com.BackEndAep.model;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum StatusProtocolo {
    Aberto(1),
    EmTriagem(2),
    EmAndamento(3),
    Resolvido(4),
    Reprovado(5);

    private final int codigo;

    StatusProtocolo(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }

    @JsonCreator
    public static StatusProtocolo fromJson(Object value) {
        if (value instanceof Number number) {
            return fromCodigo(number.intValue());
        }

        return StatusProtocolo.valueOf(value.toString());
    }

    public static StatusProtocolo fromCodigo(int codigo) {
        for (StatusProtocolo status : values()) {
            if (status.codigo == codigo) {
                return status;
            }
        }

        throw new IllegalArgumentException("Status de protocolo invalido: " + codigo);
    }
}
