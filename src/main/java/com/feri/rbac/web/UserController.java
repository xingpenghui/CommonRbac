package com.feri.rbac.web;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.feri.rbac.dto.UserDto;
import com.feri.rbac.entity.User;
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
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/api/user/login.do")
    public R login(UserDto userDto){
        return userService.login(userDto);
    }

    //增
    @PostMapping("/api/user/save.do")
    public R save(@RequestBody User user){
       return R.setResult(userService.save(user),"新增用户");
    }
    //删
    @DeleteMapping("/api/user/delByid.do")
    public R del(int id){
        return R.setResult(userService.removeById(id),"删除用户");
    }
    //改
    @PutMapping("/api/user/updateById.do")
    public R update(@RequestBody User user){
        return R.setResult(userService.updateById(user),"修改用户");
    }
    //查
    @GetMapping("/api/user/queryAll.do")
    public R all(){
        return R.setResult(true,userService.list());
    }
    //分页查询
    @GetMapping("/api/user/queryPage.do")
    public R getPage(int page,int size){
       return R.setOK(userService.page(new Page<>(page-1,size)));
    }
    //查询当前登录用户的菜单信息
    @GetMapping(value = "/api/user/queryMenu.do")
    public R queryMenu(){
        return userService.queryMenu();
    }
}
