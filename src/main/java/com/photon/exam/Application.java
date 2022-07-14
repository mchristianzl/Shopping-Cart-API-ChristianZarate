package com.photon.exam;

import com.photon.exam.service.TaxService;
import com.photon.exam.util.Types;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	CommandLineRunner runner(TaxService taxService) {
		return args -> {
			taxService.addTaxes(Types.GNRL, 8.75);
			taxService.addTaxes(Types.TIERED, 8.75);
			taxService.addTaxes(Types.LUXURY, 15);
		};
	}

}