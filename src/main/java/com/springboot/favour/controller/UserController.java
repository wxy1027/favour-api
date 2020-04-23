package com.springboot.favour.controller;

import com.springboot.favour.entity.dto.WeChatLoginDTO;
import com.springboot.favour.service.UserService;
import com.springboot.favour.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: WXY
 * @Dscription:
 * @Date: Created in 2020/4/23
 * @Modified By:
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("wechat/login")
    public Result wechatLogin(@RequestBody WeChatLoginDTO weChatLoginDTO) {
        return userService.wechatLogin(weChatLoginDTO);
    }
}
