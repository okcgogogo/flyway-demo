package com.example.demo.design.factory;

import com.example.demo.design.handler.AbstractPayHandler;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * 工厂+策略+模板方法 设计模式示例
 * @author okcgogogo
 * @date 2021/2/4 14:54
 */
public class PayFactory {
    private static Map<String, AbstractPayHandler> map = new HashMap<>();

    public static void register(String name, AbstractPayHandler handler){
        if (StringUtils.isEmpty(name) || handler == null) {
            return;
        }
        map.put(name, handler);
    }

    public static AbstractPayHandler getHandler(String name){
        return map.get(name);
    }

}
