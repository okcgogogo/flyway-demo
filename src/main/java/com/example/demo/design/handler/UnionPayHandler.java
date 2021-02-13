package com.example.demo.design.handler;

import com.example.demo.design.factory.PayFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * @author okcgogogo
 * @date 2021/2/4 14:58
 */
@Slf4j
@Component
public class UnionPayHandler extends AbstractPayHandler {

    @Override
    public void pay() {
        log.info("银联支付");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        PayFactory.register("unionPay", this);
    }
}
