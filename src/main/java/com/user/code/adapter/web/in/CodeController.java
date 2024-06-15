package com.user.code.adapter.web.in;

import com.user.code.adapter.web.model.CodeDocumentResponse;
import com.user.code.service.CodeQueryService;
import com.user.code.service.model.CodeQuery;
import com.user.common.controller.ApiV1Controller;
import com.user.common.model.CommonResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;


@ApiV1Controller
@RequiredArgsConstructor
public class CodeController {
    private final CodeQueryService codeQueryService;

    @GetMapping("/codes")
    public CommonResponse<CodeQuery> getCodes() {
        return CommonResponse.ok(codeQueryService.getCodeQuery());
    }

    // Restdocs 작성을 위해 별도 API 신설
    @GetMapping("/codes/documents")
    public CommonResponse<CodeDocumentResponse> getCodesForDocuments() {
        return CommonResponse.ok(CodeDocumentResponse.make(codeQueryService.getCodeQuery()));
    }
}
