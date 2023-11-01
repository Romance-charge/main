package com.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;

@ServletComponentScan
@SpringBootApplication
@MapperScan("com.example.mapper")//为userMapper.java的包路径

public class Demo1Application { //启动类
    public static void main(String[] args) {
        SpringApplication.run(Demo1Application.class, args);
        System.out.println("启动成功，别看报错了");

    }

}
