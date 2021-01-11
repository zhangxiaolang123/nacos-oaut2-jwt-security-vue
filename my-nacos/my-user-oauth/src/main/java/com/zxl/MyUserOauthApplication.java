package com.zxl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class MyUserOauthApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyUserOauthApplication.class, args);
	}

	@Bean(name = "restTemplate")
	public RestTemplate restTemplate() {
		SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
		// 解决401报错时，报java.net.HttpRetryException: cannot retry due to server authentication, in streaming mode
		requestFactory.setOutputStreaming(false);
		RestTemplate restTemplate = new RestTemplate(requestFactory);


		return restTemplate;
		//    return new RestTemplate(requestFactory);
	}
}
