package com.user.code.adapter.web.model;

import com.user.code.service.model.BaseCode;
import com.user.code.service.model.CodeQuery;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CodeDocumentResponse {
    private Map<String, Map<String, String>> codeMap;

    public static CodeDocumentResponse make(CodeQuery adminCodes) {
        Map<String, Map<String, String>> codeMap = new HashMap<>();
        adminCodes.getCodeMap().forEach(
                (k, v) -> {
                    codeMap.put(k, covertTo(v));
                }
        );

        return new CodeDocumentResponse(codeMap);
    }

    private static <T> Map<String, String> covertTo(Set<T> codeSet) {
        Map<String, String> codeMap = new HashMap<>();

        codeSet.stream().forEach(
                code -> {
                    codeMap.put(((BaseCode) code).getCode(), ((BaseCode) code).getDesc());
                }
        );

        return codeMap;
    }
}
