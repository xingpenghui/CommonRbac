package com.feri.rbac.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @program: CommonRbac
 * @description:
 * @author: Feri
 * @create: 2019-10-23 09:42
 */
@Data
@TableName("sys_role") //标记对应的数据库表名
public class Role {
    @TableId(type = IdType.AUTO) //标记主键  设置主键的增长类型 自增
    private Integer id;
    private String name;
    private String info;
    private int parentid;
}