package com.user.common.constant.code;

import com.user.code.annotation.CodeClass;
import com.user.common.constant.CommonCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@CodeClass
public enum Yn implements CommonCode {
    Y("Y", "예"),
    N("N", "아니오");

    private String code;
    private String desc;

    public boolean isY() {
        return this == Y;
    }

    public boolean isN() {
        return this == N;
    }
}