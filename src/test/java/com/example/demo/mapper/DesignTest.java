package com.example.demo.mapper;

import com.example.demo.design.factory.PayFactory;
import com.example.demo.design.handler.AbstractPayHandler;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author okcgogogo
 * @date 2021/2/4 15:05
 */
@Slf4j
public class DesignTest extends AppTest{

    /**
     * 不带设计模式
     */
    @Test
    public void testNoDesign(){
        String name = "alipay";
        if ("alipay".equals(name)) {
            // 执行相关逻辑
            log.info("");
        } else if ("wechatPay".equals(name)) {

        }else if ("unionPay".equals(name)) {

        }else if ("others".equals(name)) {

        }
    }

    /**
     * 用设计模式
     */
    @Test
    public void testDesign(){
        AbstractPayHandler aliPay = PayFactory.getHandler("aliPay");
        aliPay.pay();
    }

}
