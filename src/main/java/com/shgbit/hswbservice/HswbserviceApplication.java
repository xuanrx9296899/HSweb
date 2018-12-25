package com.shgbit.hswbservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@SpringBootApplication
//mybaitsplus 扫描所有mapper
//@EnableTransactionManagement
@MapperScan("com.shgbit.hswbservice.app.mapper")
@ComponentScan(basePackages = { "com.shgbit.hswbservice.app" })
@EnableScheduling
public class HswbserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(HswbserviceApplication.class, args);
	}

}

