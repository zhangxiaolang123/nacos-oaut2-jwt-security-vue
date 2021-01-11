package com.zxl;

import com.zxl.util.FeignInterceptor;
import tk.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients
@MapperScan("com.zxl.mapper")
public class MyConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyConsumerApplication.class, args);
	}


	//fegin调用的时候也要把token带下去（消费方必须要写）feign的拦截器已经提取到common工程里
	@Bean
	public FeignInterceptor feignInterceptor(){
		return new FeignInterceptor();
	}

}
