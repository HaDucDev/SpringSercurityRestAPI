package com.example.SpringSecurityRestAPI.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

//Bạn sẽ phải đăng ký bộ đánh chặn(Interceptor) này với InterceptorRegistry
// bằng cách sử dụng WebMVCConfigerAdapter
@Component
public class BookInterceptorConfig extends WebMvcConfigurationSupport {

    @Autowired
    private BookInterceptor bookInterceptor;

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(bookInterceptor);
    }
}
