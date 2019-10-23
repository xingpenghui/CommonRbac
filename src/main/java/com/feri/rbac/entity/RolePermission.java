package com.feri.rbac.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @program: CommonRbac
 * @description:
 * @author: Feri
 * @create: 2019-10-23 09:42
 */
@Data
@TableName("sys_rolepermission") //标记对应的数据库表名
public class RolePermission {
    @TableId(type = IdType.AUTO) //标记主键  设置主键的增长类型 自增
    private Integer id;
    private Integer rid; //角色id
    private Integer pid; //权限id

}