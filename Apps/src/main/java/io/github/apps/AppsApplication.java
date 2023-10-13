package io.github.apps;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class AppsApplication {

	@Autowired
	@Qualifier("appNome")
	String appNome;
	
	public static void main(String[] args) {
		SpringApplication.run(AppsApplication.class, args);
	}
	
	@GetMapping("/")
	public String init() {
		return appNome;
	}

}
