package com.BackEndAep.model;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class StatusProtocoloConverter implements AttributeConverter<StatusProtocolo, Integer> {
    @Override
    public Integer convertToDatabaseColumn(StatusProtocolo attribute) {
        return attribute == null ? null : attribute.getCodigo();
    }

    @Override
    public StatusProtocolo convertToEntityAttribute(Integer dbData) {
        return dbData == null ? null : StatusProtocolo.fromCodigo(dbData);
    }
}
