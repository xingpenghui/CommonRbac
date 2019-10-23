package com.feri.rbac.config;

import com.alibaba.druid.support.http.StatViewFilter;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: BootSsm
 * @description:
 * @author: Feri
 * @create: 2019-10-21 14:23
 */
@Configuration //配置文件
public class DruidConfig {
    //注册Druid的过滤器 实现SQL的监控  FilterRegistrationBean过滤器注册对象 实现过滤器的注册
    @Bean  //创建对象 调用方法
    public FilterRegistrationBean createFR(){
        FilterRegistrationBean registrationBean=new FilterRegistrationBean();
        //设置过滤器
        registrationBean.setFilter(new WebStatFilter());
        //设置过滤路径
        registrationBean.addUrlPatterns("/*");
        return registrationBean;
    }
    //注册Servlet 实现可视化页面的访问
    @Bean
    public ServletRegistrationBean createSRB(){
        ServletRegistrationBean registrationBean=new ServletRegistrationBean();
        //设置Servlet对象
        registrationBean.setServlet(new StatViewServlet());
        //设置触发路径
        registrationBean.addUrlMappings("/druid/*");
        return registrationBean;
    }
}
