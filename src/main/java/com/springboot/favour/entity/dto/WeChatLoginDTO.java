package com.springboot.favour.entity.dto;

import lombok.Data;

/**
 * @Author: WXY
 * @Dscription:
 * @Date: Created in 2020/4/23
 * @Modified By:
 */
@Data
public class WeChatLoginDTO {
    private String code;
    private String avatar;
    private String nickname;
}
