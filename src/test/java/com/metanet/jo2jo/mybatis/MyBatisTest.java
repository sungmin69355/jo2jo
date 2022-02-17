package com.metanet.jo2jo.mybatis;

import javax.sql.DataSource;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

// spring-mvc.xml에 있는 객체들을 컨테이너에 쭉 올려놓는 작업 (Junit테스트에서)
public class MyBatisTest {

    @Autowired
    private DataSource ds;

    @Test
    public void DB접속테스트() throws Exception {
        Assertions.assertThat(ds != null);
    }
}