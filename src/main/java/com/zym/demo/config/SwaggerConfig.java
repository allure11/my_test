package com.zym.demo.config;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

/**
 * swagger 配置类
 * @author zym
 */
@SpringBootConfiguration
@EnableSwagger2
public class SwaggerConfig {

    @Bean //配置docket以配置Swagger具体参数
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
                .enable(true)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.zym.demo"))
                .build();
    }

    //配置文档信息
    private ApiInfo apiInfo() {
        Contact contact = new Contact("zym", "http://xxx.xxx.com/联系人访问链接", "zym2894290453@163.com");
        return new ApiInfo(
                // 标题
                "Swagger学习",
                // 描述
                "学习演示如何配置Swagger",
                // 版本
                "v1.0",
                // 组织链接
                "http://terms.service.url/组织链接",
                // 联系人信息
                contact,
                // 许可
                "Apach 2.0 许可",
                // 许可连接
                "许可链接",
                // 扩展
                new ArrayList<>()
        );
    }

}
