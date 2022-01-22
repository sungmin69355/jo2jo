package com.metanet.jo2jo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = "com.metanet.jo2jo.repository")
@ComponentScan( //Component를찾아서 알아서 컨테이너에 등록한다.
    basePackages = "com.metanet.jo2jo.*"
)
public class AppConfig {

}
