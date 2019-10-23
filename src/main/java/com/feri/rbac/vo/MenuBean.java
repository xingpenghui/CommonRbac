package com.feri.rbac.vo;

import lombok.Data;

import java.util.List;

/**
 * @program: CommonRbac
 * @description: 菜单类
 * @author: Feri
 * @create: 2019-10-23 14:34
 */
@Data
public class MenuBean {
    private Integer id;
    private String name;
    private String murl;
    private String icons;
    private int level;//菜单的级别
    private List<MenuBean> childs; //内部子菜单 下属的菜单
}
