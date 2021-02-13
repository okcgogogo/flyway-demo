package com.example.demo.domain;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.Version;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author okcgogogo
 * @date 2021/1/11 19:00
 */
@Data
public class BaseEntity implements Serializable {
    @TableField(
            value = "create_time",
            fill = FieldFill.INSERT
    )
    private Date createTime;
    @TableField(
            value = "update_time",
            fill = FieldFill.INSERT_UPDATE
    )
    private Date updateTime;
    @Version
    @TableField(
            value = "version",
            fill = FieldFill.INSERT
    )
    private Integer version;
}
