package com.herokuapp.convenient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.stereotype.Component;

@SpringBootApplication
@EntityScan(basePackageClasses = {ConvenientLineBotApplication.class, Jsr310JpaConverters.class})
@Component
public class ConvenientLineBotApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConvenientLineBotApplication.class, args);
	}

}
