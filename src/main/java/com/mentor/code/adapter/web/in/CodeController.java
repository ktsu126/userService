package com.mentor.code.adapter.web.in;

import com.mentor.code.adapter.web.model.CodeDocumentResponse;
import com.mentor.code.service.CodeQueryService;
import com.mentor.code.service.model.CodeQuery;
import com.mentor.common.controller.ApiV1Controller;
import com.mentor.common.model.CommonResponse;
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
