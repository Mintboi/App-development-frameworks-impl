package com.Project.MartinSwiftImpl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.Project.MartinSwiftImpl.Repositories")
@EntityScan(basePackages = {"com.Project.MartinSwiftImpl.Security", "com.Project.MartinSwiftImpl.Objects"})
public class MartinSwiftImplApplication {

	public static void main(String[] args) {
		SpringApplication.run(MartinSwiftImplApplication.class, args);
	}

}
