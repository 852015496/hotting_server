package com.hetting.hottable;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableScheduling   //开启定时任务
@EnableTransactionManagement // 开启事务管理
//改变自动扫描的包
//@ComponentScan(basePackages = {"com.hetting.hottable.utils"})
//扫描mapper层
@MapperScan("com.hetting.hottable.mapper")
//扫描cors跨域类
@ServletComponentScan(basePackages = {"com.hetting.hottable"})
public class HottableApplication {

    public static void main(String[] args) {
        SpringApplication.run(HottableApplication.class, args);
    }


}
