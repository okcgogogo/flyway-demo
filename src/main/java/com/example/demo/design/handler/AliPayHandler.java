package com.example.demo.design.handler;

import com.example.demo.design.factory.PayFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * @author xiangli.chen
 * @date 2021/2/4 14:58
 */
@Slf4j
@Component
public class AliPayHandler extends AbstractPayHandler {

    @Override
    public void pay() {
        log.info("支付宝支付");
    }

    @Override
    public String consume() {
        return "支付宝消费";
    }

    @Override
    public void afterPropertiesSet() {
        PayFactory.register("aliPay", this);
    }
}
