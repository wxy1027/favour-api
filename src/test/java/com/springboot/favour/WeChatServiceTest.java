package com.springboot.favour;

import com.springboot.favour.component.WeChatService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Author: WXY
 * @Dscription:
 * @Date: Created in 2020/5/1
 * @Modified By:
 */
@SpringBootTest
public class WeChatServiceTest {
    @Autowired
    private WeChatService weChatService;

    @Test
    public void test() {
        weChatService.test();
    }
}
