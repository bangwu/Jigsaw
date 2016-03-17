package com.thoughtworks.controller;

import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.web.DispatcherServletAutoConfiguration;
import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

@Configuration
@AutoConfigureAfter(DispatcherServletAutoConfiguration.class)
public class ResourcesHandler extends WebMvcAutoConfiguration.WebMvcAutoConfigurationAdapter {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/css/**").addResourceLocations("/static/", "classpath:/static/css/");
        registry.addResourceHandler("/js/**").addResourceLocations("/static/", "classpath:/static/js/");
        registry.addResourceHandler("/*.html").addResourceLocations("/template/", "classpath:/template/");
        super.addResourceHandlers(registry);
    }
}
