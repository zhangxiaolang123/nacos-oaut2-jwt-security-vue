package com.zxl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MySentinelApplication {

	public static void main(String[] args) {
		SpringApplication.run(MySentinelApplication.class, args);
	}

}
