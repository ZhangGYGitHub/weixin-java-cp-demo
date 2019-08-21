package com.ningxun.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @Classname MyAppConfig
 * @Author lenovo
 * @Date 17:08
 *
 * @Configuration:指明当前类是一个配置类
 *扩展springMVC：既保留了springboot的默认配置，也能用我们的扩展配置
 **/
@Configuration
public class MyAppConfig extends WebMvcConfigurationSupport {
        @Override
        protected void addResourceHandlers(ResourceHandlerRegistry registry) {
            registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        }

}
