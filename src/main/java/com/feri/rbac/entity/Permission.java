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
@TableName("sys_permission") //标记对应的数据库表名
public class Permission {
    @TableId(type = IdType.AUTO) //标记主键  设置主键的增长类型 自增
    private Integer id;
    private String name; //名称
    private String icon; //图标
    private int parentid; //上级id  菜单
    private String prms; //如果是菜单 则是对应的页面路径，如果是权限 则表示权限的名称
    private int type;//类型 1菜单 粗粒度 2权限 细粒度
    private int level;//级别 针对是菜单 一级菜单 二级菜单 三级菜单

}