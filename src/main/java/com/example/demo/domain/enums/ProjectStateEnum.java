package com.example.demo.domain.enums;

import com.baomidou.mybatisplus.core.enums.IEnum;

/**
 * @author okcgogogo
 * @date 2020/12/6 15:06
 */
public enum ProjectStateEnum implements IEnum<Integer> {
    /** The developing. */
    DEVELOPING(1, "开发中"),
    /** The planned. */
    PLANNED(2, "规划完成"),
    /** The pre release. */
    PRE_RELEASE(3, "预发布"),
    /** The released. */
    RELEASED(4, "发布");

    private Integer value;
    private String description;
    ProjectStateEnum(Integer value,String description){
        this.value = value;
        this.description = description;
    }
    @Override
    public Integer getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }
}
