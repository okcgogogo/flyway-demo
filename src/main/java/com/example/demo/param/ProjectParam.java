package com.example.demo.param;

import lombok.Data;

import java.util.List;

/**
 * @author okcgogogo
 * @date 2020/12/31 10:17
 */
@Data
public class ProjectParam {
    private String id;
    private String code;
    private String name;
    private String description;
    private List<Children> list;

    @Data
    static class Children {
        private String a;
        private String b;
    }
}
