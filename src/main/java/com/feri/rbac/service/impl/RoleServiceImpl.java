package com.feri.rbac.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.feri.rbac.dao.RoleDao;
import com.feri.rbac.entity.Role;
import com.feri.rbac.service.RoleService;
import org.springframework.stereotype.Service;

/**
 * @program: CommonRbac
 * @description:
 * @author: Feri
 * @create: 2019-10-23 10:03
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleDao, Role> implements RoleService {
}
