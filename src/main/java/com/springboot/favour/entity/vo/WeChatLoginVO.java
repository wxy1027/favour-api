package com.springboot.favour.entity.vo;

import lombok.Data;

/**
 * @author Jun
 * @date 2020/4/22 下午10:58
 */
@Data
public class WeChatLoginVO {
    private Integer userId;
    private String openId;
}
