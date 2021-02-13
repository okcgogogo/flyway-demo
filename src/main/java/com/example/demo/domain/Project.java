package com.example.demo.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.example.demo.domain.enums.ProjectStateEnum;
import lombok.Data;

/**
 * @author okcgogogo
 * @date 2020/12/6 14:40
 */
@Data
@TableName("project")
public class Project extends BaseEntity{
    private String id;
    private String code;
    private String name;
    private String description;
    private ProjectStateEnum state;
}
