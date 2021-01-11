package com.zxl;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;

@EnableDiscoveryClient
@SpringBootApplication
@MapperScan("com.zxl.mapper")
public class MyProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyProviderApplication.class, args);
	}

}
