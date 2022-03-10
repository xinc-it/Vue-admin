package com.markerhub;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.markerhub.mapper")
public class VueadminJavaApplication {

	public static void main(String[] args) {
		SpringApplication.run(VueadminJavaApplication.class, args);
	}

}
