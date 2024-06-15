package com.user.code.service.model;


import com.user.common.constant.CommonCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

@Getter
@ToString
public class BaseCode {
    @NonNull
    private String code;
    @NonNull
    private String desc;

    protected BaseCode(CommonCode commonCode) {
        this.code = commonCode.getCode();
        this.desc = commonCode.getDesc();
    }

    public static BaseCode of(CommonCode commonCode) {
        return new BaseCode(commonCode);
    }
}
