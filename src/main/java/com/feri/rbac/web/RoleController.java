package com.feri.rbac.web;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.feri.rbac.dto.UserDto;
import com.feri.rbac.entity.Role;
import com.feri.rbac.entity.User;
import com.feri.rbac.service.RoleService;
import com.feri.rbac.service.UserService;
import com.feri.rbac.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @program: CommonRbac
 * @description:
 * @author: Feri
 * @create: 2019-10-22 10:23
 */
@RestController
public class RoleController {
    @Autowired
    private RoleService roleService;


    //增
    @PostMapping("/api/role/save.do")
    public R save(@RequestBody Role role){
       return R.setResult(roleService.save(role),"新增角色");
    }
    //删
    @DeleteMapping("/api/role/delByid.do")
    public R del(int id){
        return R.setResult(roleService.removeById(id),"删除角色");
    }
    //改
    @PutMapping("/api/role/updateById.do")
    public R update(@RequestBody Role role){
        return R.setResult(roleService.updateById(role),"修改角色");
    }
    //查
    @GetMapping("/api/role/queryAll.do")
    public R all(){
        return R.setResult(true,roleService.list());
    }
    //分页查询
    @GetMapping("/api/role/queryPage.do")
    public R getPage(int page,int size){
       return R.setOK(roleService.page(new Page<>(page-1,size)));
    }
}
