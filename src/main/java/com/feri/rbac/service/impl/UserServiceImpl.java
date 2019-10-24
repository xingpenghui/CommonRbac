package com.feri.rbac.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.feri.rbac.dao.UserDao;
import com.feri.rbac.dto.UserDto;
import com.feri.rbac.entity.Permission;
import com.feri.rbac.entity.User;
import com.feri.rbac.service.UserService;
import com.feri.rbac.vo.MenuBean;
import com.feri.rbac.vo.R;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @program: CommonRbac
 * @description:
 * @author: Feri
 * @create: 2019-10-22 10:20
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {
    @Override
    public R login(UserDto userDto) {
        //1、查询用户
        User user=getBaseMapper().selectOne(new QueryWrapper<User>().eq("mname",userDto.getUsername()));
        //2、验证账号是否存在
        if(user!=null){
            //3、验证密码
            if(Objects.equals(user.getPassword(),userDto.getPsw())){
                //4、操作Shiro
                //1、创建主题对象
                Subject subject = SecurityUtils.getSubject();
                //2、创建令牌 用户名密码令牌
                UsernamePasswordToken token = new UsernamePasswordToken(userDto.getUsername(), userDto.getPsw());
                //3、存储当前的User
                subject.getSession().setAttribute("curruser",user);
                //4、登录 告诉Shiro登录成功
                subject.login(token);
                return R.setOK("OK");
            }
        }
        return R.setERROR();
    }

    @Override
    public R queryMenu() {
        User user= (User) SecurityUtils.getSubject().getSession().getAttribute("curruser");
        List<Permission> permissions=getBaseMapper().selectMenuByUid(user.getId());
        //组装菜单信息
        List<MenuBean> menus=new ArrayList<>();
        //循环进行菜单内容的组装 安装级别关系
        for(int i=0;i<permissions.size();i++){
            Permission p=permissions.get(i);
            MenuBean bean=new MenuBean();
            bean.setId(p.getId());
            bean.setChilds(new ArrayList<>());
            bean.setIcons(p.getIcon());
            bean.setLevel(p.getLevel());
            bean.setMurl(p.getPrms());
            bean.setName(p.getName());
            if(p.getLevel()==1){
                //一级菜单
                menus.add(bean);
            }else if(p.getLevel()==2){
                //二级菜单
                //先寻找对应的一级菜单
                int index=searhP(menus,p.getParentid());
                //验证是否找到对应一级菜单
                if(index>0){
                    //找到了对应的一级菜单
                    MenuBean menuBean=menus.get(index);
                    //将当前的二级菜单添加到对应的一级菜单下
                    menuBean.getChilds().add(bean);
                }
            }
        }
        return R.setOK(menus);
    }
    private int searhP(List<MenuBean> menuBeans,int id){
        for(int i=0;i<menuBeans.size();i++){
            if(menuBeans.get(i).getId()==id){
                return i;
            }
        }
        return -1;
    }
}
