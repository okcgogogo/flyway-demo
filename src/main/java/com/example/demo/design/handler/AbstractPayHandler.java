package com.example.demo.design.handler;

import org.springframework.beans.factory.InitializingBean;

/**
 * @author okcgogogo
 * @date 2021/2/4 14:51
 */
public abstract class AbstractPayHandler implements InitializingBean {

    public void pay() {
        throw new UnsupportedOperationException();
    }

    public String consume() {
        throw new UnsupportedOperationException();
    }
}
