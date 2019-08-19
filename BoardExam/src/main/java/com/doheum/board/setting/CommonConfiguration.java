package com.doheum.board.setting;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import nz.net.ultraq.thymeleaf.LayoutDialect;

@Configuration
@PropertySource("classpath:/application.properties")
public class CommonConfiguration {

	@Bean
	public LayoutDialect layoutDialect() {
	    return new LayoutDialect();
	}
}
