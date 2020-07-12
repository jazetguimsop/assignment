package me.assignment.mc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import me.assignment.mc.config.Config;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class ConnectivityApplication {

	private final static Logger logger = LoggerFactory.getLogger(ConnectivityApplication.class);

	public static void main(String[] args) {
		logger.info("Application is starting...");
		SpringApplication.run(ConnectivityApplication.class, args);
	}

	@Bean
	public Docket swaggerApi() {
		logger.info("Intializing swagger...");
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("me.assignment.mc")).build();
	}
}
