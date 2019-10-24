package com.feri.rbac.shiro;

import com.feri.rbac.dao.UserDao;
import com.feri.rbac.entity.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @program: CommonRbac
 * @description:
 * @author: Feri
 * @create: 2019-10-22 10:13
 */
@Component //Spring IOC创建对象
public class MyRealm extends AuthorizingRealm {
    @Autowired
    private UserDao userDao;
    //1、授权  查询登录用户的角色或者权限
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //1、获取登录用户
        User user=(User) SecurityUtils.getSubject().getSession().getAttribute("curruser");
        //2、查询当前用户的所有权限
        List<String> perms=userDao.selectPerms(user.getId());
        //3、实例化授权对象
        SimpleAuthorizationInfo authorizationInfo=new SimpleAuthorizationInfo();
        //4、赋值
        authorizationInfo.addStringPermissions(perms);

        return authorizationInfo;
    }
    //2、认证 生成凭证 登录成功
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token=(UsernamePasswordToken)authenticationToken;
        if(token.getUsername()!=null){
            //登录成功
            AuthenticationInfo info=new SimpleAuthenticationInfo(token.getPrincipal(),token.getPassword(),getName());
            return info;
        }
        return null;
    }
}
