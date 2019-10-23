package com.feri.rbac.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.feri.rbac.dto.UserDto;
import com.feri.rbac.entity.User;
import com.feri.rbac.vo.R;

public interface UserService extends IService<User> {
    R login(UserDto userDto);
    //查询当前用户的左菜单
    R queryMenu();
}
