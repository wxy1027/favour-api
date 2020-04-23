package com.springboot.favour.service;

import com.springboot.favour.entity.dto.WeChatLoginDTO;
import com.springboot.favour.util.Result;

/**
 * @Author: WXY
 * @Dscription:
 * @Date: Created in 2020/4/23
 * @Modified By:
 */
public interface UserService {


    /**
     * wechat login
     *
     * @param weChatLoginDTO
     * @return
     */
    Result wechatLogin(WeChatLoginDTO weChatLoginDTO);
}
