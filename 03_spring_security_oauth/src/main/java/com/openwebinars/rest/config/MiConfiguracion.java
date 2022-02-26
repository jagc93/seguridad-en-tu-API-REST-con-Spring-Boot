package com.openwebinars.rest.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing
public class MiConfiguracion {


	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

}
