package com.feri.rbac.web;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.feri.rbac.entity.Permission;
import com.feri.rbac.entity.Role;
import com.feri.rbac.service.PermissionService;
import com.feri.rbac.service.RoleService;
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
public class PermissionController {
    @Autowired
    private PermissionService permissionService;


    //校验是否存在某个权限
    @GetMapping("/api/permission/checkperms.do")
    public R check(String perms){
        return permissionService.checkPerms(perms);
    }
    //增
    @PostMapping("/api/permission/save.do")
    public R save(@RequestBody Permission permission){
       return R.setResult(permissionService.save(permission),"新增权限");
    }
    //删
    @DeleteMapping("/api/permission/delByid.do")
    public R del(int id){
        return R.setResult(permissionService.removeById(id),"删除权限");
    }
    //改
    @PutMapping("/api/permission/updateById.do")
    public R update(@RequestBody Permission permission){
        return R.setResult(permissionService.updateById(permission),"修改权限");
    }
    //查
    @GetMapping("/api/permission/queryAll.do")
    public R all(){
        return R.setResult(true,permissionService.list());
    }
    //分页查询
    @GetMapping("/api/permission/queryPage.do")
    public R getPage(int page,int size){
       return R.setOK(permissionService.page(new Page<>(page-1,size)));
    }
}
