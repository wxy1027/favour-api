package com.springboot.favour.service.impl;

import com.springboot.favour.component.WeChatService;
import com.springboot.favour.entity.User;
import com.springboot.favour.entity.dto.WeChatLoginDTO;
import com.springboot.favour.entity.vo.WeChatLoginVO;
import com.springboot.favour.repository.UserRepository;
import com.springboot.favour.service.UserService;
import com.springboot.favour.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.Map;
import java.util.Optional;

/**
 * @Author: WXY
 * @Dscription:
 * @Date: Created in 2020/4/23
 * @Modified By:
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired(required = false)
    private UserRepository userRepository;
    @Autowired
    private WeChatService weChatService;

    @Override
    public Result wechatLogin(WeChatLoginDTO weChatLoginDTO) {


        String avatar = weChatLoginDTO.getAvatar();
        String code = weChatLoginDTO.getCode();
        String nickname = weChatLoginDTO.getNickname();

        Map<String, String> sessionAndOpenIdMap = weChatService.getSessionAndOpenId(code);
        if (sessionAndOpenIdMap.size() < 1) {
            return Result.error("fail");
        }

        String openId = sessionAndOpenIdMap.get("openId");
        Optional<User> optionalUser = userRepository.findByOpenId(openId);
        if (optionalUser.isPresent()) {
            return returnSuccessResult(optionalUser.get());
        }

        return returnSuccessResult(saveUser(avatar, openId, nickname));
    }

    private Result returnSuccessResult(User user) {
        if (user == null) {
            return Result.error("fail");
        }

        WeChatLoginVO weChatLoginVO = new WeChatLoginVO();
        weChatLoginVO.setOpenId(user.getOpenId());
        weChatLoginVO.setUserId(user.getPkId());
        return Result.success(weChatLoginVO);
    }

    @Transactional(rollbackFor = Exception.class)
    public User saveUser(String avatar, String openId, String nickname) {


        Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
        User userDO = new User();

        userDO.setAvatar(avatar);
        userDO.setNickname(nickname);
        userDO.setOpenId(openId);
        userDO.setPhone("");
        userDO.setCreateTime(currentTimestamp);
        userDO.setUpdateTime(currentTimestamp);

        return userRepository.save(userDO);
    }
}
