package com.feri.rbac.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.feri.rbac.entity.Permission;
import com.feri.rbac.entity.User;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserDao extends BaseMapper<User> {

    @Select("select p.* from sys_permission p inner join sys_rolepermission rp on p.id=rp.pid inner join sys_userrole ur on ur.rid=rp.rid where ur.uid=#{uid} and p.type=1 order by p.level,p.id")
    @ResultType(Permission.class)
    List<Permission> selectMenuByUid(int uid);

}
