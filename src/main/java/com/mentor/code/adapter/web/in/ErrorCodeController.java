package com.mentor.code.adapter.web.in;

import com.mentor.code.adapter.web.model.ErrorQuery;
import com.mentor.common.controller.ApiV1Controller;
import com.mentor.common.exception.ExceptionType;
import com.mentor.common.model.CommonResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@ApiV1Controller
@RequiredArgsConstructor
public class ErrorCodeController {
    @GetMapping("/errors")
    public CommonResponse<List<ErrorQuery>> getErrors() {
        return CommonResponse.ok(Arrays.stream(ExceptionType.values())
                .map(it -> ErrorQuery.of(it))
                .collect(Collectors.toList()));
    }
}
