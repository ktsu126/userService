package com.user.common.component;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CommonBeans {
    public static MessageUtil messageUtil;
    public static ObjectMapper objectMapper;
    public static String myUrl;

    private final MessageUtil messageUtilBean;
    private final ObjectMapper objectMapperBean;


    @PostConstruct
    private void initialize() {
        messageUtil = messageUtilBean;
        objectMapper = objectMapperBean;
    }
}
