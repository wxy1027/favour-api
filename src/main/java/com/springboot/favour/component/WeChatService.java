package com.springboot.favour.component;

import com.alibaba.fastjson.JSONObject;
import com.springboot.favour.constant.WeChatConstant;
import com.springboot.favour.entity.User;
import com.springboot.favour.repository.UserRepository;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * @Author: WXY
 * @Dscription:
 * @Date: Created in 2020/4/23
 * @Modified By:
 */
@Slf4j
@Service
public class WeChatService {

    @Autowired
    private  UserRepository userRepository;

    public void test() {
        Optional<User> userOptional = userRepository.findById(1);
        if (userOptional.isPresent()) {
            System.out.println(userOptional.get());
        }
    }

    public Map<String, String> getSessionAndOpenId(String code) {
        Map<String, String> map = new HashMap<>(2);

        if (code == null || code.isEmpty()) {
            return map;
        }

        String url = "https://api.weixin.qq.com/sns/jscode2session?appid=" + WeChatConstant.APP_ID +
                "&secret=" + WeChatConstant.APP_SECRET + "&js_code=" + code + "&grant_type=authorization_code";

        OkHttpClient client = new OkHttpClient();
        Response response = null;
        try {
            response = client.newCall(new Request.Builder().url(url).build()).execute();
            String string = response.body().string();
            log.info("请求结果 {} ", string);

            JSONObject jsonObject = JSONObject.parseObject(string);

            Integer errcode = (Integer) jsonObject.get("errcode");
            String errmsg = (String) jsonObject.get("errmsg");
            String openId = (String) jsonObject.get("openid");
            String sessionKey = (String) jsonObject.get("session_key");

            if (errcode != null || errmsg != null) {
                return null;
            }

            Optional<User> optional = userRepository.findByOpenId(openId);
            if (optional.isPresent()) {
                map.put("session_key", sessionKey);
                map.put("openid", openId);
                return map;
            }
        } catch (IOException e) {
            e.printStackTrace();
            log.error("请求失败 {}", e);
        }
        return map;
    }
}
