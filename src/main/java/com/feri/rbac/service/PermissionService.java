package com.feri.rbac.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.feri.rbac.entity.Permission;
import com.feri.rbac.entity.Role;
import com.feri.rbac.vo.R;

public interface PermissionService extends IService<Permission> {
    R checkPerms(String p);
}
