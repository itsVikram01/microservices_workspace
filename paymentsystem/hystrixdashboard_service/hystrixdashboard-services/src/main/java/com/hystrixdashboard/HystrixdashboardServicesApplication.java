package com.hystrixdashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
//@EnableHystrixDashboard
@EnableHystrix
public class HystrixdashboardServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(HystrixdashboardServicesApplication.class, args);
		System.out.println("HystrixdashboardServicesApplication Started.........!!");
	}

}
