package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"com.example" })
@EnableJpaAuditing
@EnableJpaRepositories(basePackages = "com.example.database.repository")
@EntityScan(basePackages = "com.example.database.model")
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class TralalaApplication {


	public static void main(String[] args) {

		SpringApplication.run(TralalaApplication.class, args);
	}
}
