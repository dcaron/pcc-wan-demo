package io.pivotal.pcc.pccwandemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.gemfire.repository.config.EnableGemfireRepositories;

@SpringBootApplication
@EnableGemfireRepositories(basePackageClasses = io.pivotal.pcc.pccwandemo.pcc.CustomerRepository.class)

public class PccWanDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(PccWanDemoApplication.class, args);
	}
}
