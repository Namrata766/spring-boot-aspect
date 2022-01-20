package com.namrata;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProgramConfig {

	@Bean
	public String message() {
		return "Have nice day.";
	}
}
