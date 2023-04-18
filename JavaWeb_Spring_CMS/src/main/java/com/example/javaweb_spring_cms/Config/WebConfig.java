package com.example.javaweb_spring_cms.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resource/static/**")
                .addResourceLocations("/static/css/")
                .addResourceLocations("/static/js");
//                .setCachePeriod(31556926);
    }
}
