package com.mentor.common.constant.converter;

import com.mentor.common.constant.CommonCode;
import com.mentor.common.constant.code.Yn;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.EnumSet;
import java.util.NoSuchElementException;

public class CommonCodeConverter<E extends Enum<E> & CommonCode> implements AttributeConverter<E, String> {
    private Class<E> clz;

    CommonCodeConverter(Class<E> enumClass) {
        this.clz = enumClass;
    }

    @Override
    public String convertToDatabaseColumn(E attribute) {
        if (attribute == null) return null;

        return attribute.getCode();
    }

    @Override
    public E convertToEntityAttribute(String dbData) {
        if (dbData == null) return null;

        return EnumSet.allOf(clz).stream()
                .filter(e -> e.getCode().equals(dbData))
                .findAny()
                .orElseThrow(NoSuchElementException::new);
    }
}

@Converter(autoApply = true)
class ExpirationPeriodTypeConverter extends CommonCodeConverter<Yn> {
    ExpirationPeriodTypeConverter() {
        super(Yn.class);
    }
}

