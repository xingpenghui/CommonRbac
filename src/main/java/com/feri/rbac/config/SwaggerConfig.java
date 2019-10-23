package com.feri.rbac.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @program: BootSsm
 * @description:
 * @author: Feri
 * @create: 2019-10-21 15:01
 */
@Configuration //配置文件
public class SwaggerConfig {
    //创建文档说明
    public ApiInfo createAI(){
        ApiInfo apiInfo=new ApiInfoBuilder().title("RBAC系统").description("实现一款基于角色权限管理系统的数据接口").contact(new Contact("Feri","http://www.17feri.top","xingfei_work@163.com")).build();
        return apiInfo;
    }
    //创建Swagger扫描信息
    @Bean
    public Docket createD(){
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(createAI()).select().
                apis(RequestHandlerSelectors.basePackage("com.feri.rbac.web")).build();
    }
}
