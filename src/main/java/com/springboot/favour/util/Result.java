package com.springboot.favour.util;

import lombok.Builder;
import lombok.Data;

/**
 * @Author: WXY
 * @Dscription:
 * @Date: Created in 2020/4/23
 * @Modified By:
 */
@Data
@Builder
public class Result {
    private Integer code;
    private String msg;
    private Object data;

    public static Result success() {
        return Result.builder()
                .code(0)
                .msg("success")
                .build();
    }

    public static Result success(Object data) {
        return Result.builder()
                .code(0)
                .msg("success")
                .data(data)
                .build();
    }

    public static Result error(String msg) {
        return Result.builder()
                .data(-1)
                .msg("fail")
                .build();
    }

}
