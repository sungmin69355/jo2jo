package com.metanet.jo2jo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@Slf4j
@PropertySource("classpath:/common.properties")
public class WebMvcConfig implements WebMvcConfigurer {

    // 파일 저장할 위치
    @Value("${file.add}")
    private String potoAdd; //이거써야하는데...흠....
    //web root가 아닌 외부 경로에 있는 리소스를 url로 불러올 수 있도록 설정
    //현재 localhost:8090/resources/user/1234.jpg
    //로 접속하면 /Users/sungmin/Desktop/jo2jo/src/main/resources/user/1234.jpg 파일을 불러온다.
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        System.out.println("test");
        registry.addResourceHandler("/resources/user/**")
                .addResourceLocations(potoAdd);
    }
}