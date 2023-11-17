package com.yhp.studybbs.configs;

import com.yhp.studybbs.interceptors.CommonInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(this.commonInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/resources/**")
                .excludePathPatterns("/user/resources/**");
    }

    @Bean
    public CommonInterceptor commonInterceptor() {
        return new CommonInterceptor();
    }
}