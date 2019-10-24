package com.feri.rbac.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.feri.rbac.dao.PermissionDao;
import com.feri.rbac.dao.RoleDao;
import com.feri.rbac.entity.Permission;
import com.feri.rbac.entity.Role;
import com.feri.rbac.service.PermissionService;
import com.feri.rbac.service.RoleService;
import com.feri.rbac.vo.R;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Service;

/**
 * @program: CommonRbac
 * @description:
 * @author: Feri
 * @create: 2019-10-23 10:03
 */
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionDao, Permission> implements PermissionService {
    @Override
    public R checkPerms(String p) {
        try{
            SecurityUtils.getSubject().checkPermission(p);
            return R.setOK("OK");
        }catch (Exception e){
            return R.setERROR();
        }
    }
}
