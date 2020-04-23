package com.springboot.favour.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.sql.Timestamp;

/**
 * @Author: WXY
 * @Dscription:
 * @Date: Created in 2020/4/23
 * @Modified By:
 */
@Data
@ToString
@EqualsAndHashCode
public class User {
    private Integer pkId;
    private String nickname;
    private String phone;
    private String avatar;
    private String openId;
    private Timestamp updateTime;
    private Timestamp createTime;
}
