package com.ecommerce.ProductManagementAPI;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "Product Management REST API Documentation",
				description = "Ecommerce Product Management REST API Documentation",
				version = "v1",
				contact = @Contact(
						name = "Md Obydur Rahaman Sojib",
						email = "sojib19991018@gmail.com",
						url = "https://www.ecommerce.com"
				)
		),
		externalDocs = @ExternalDocumentation(
				description = "Ecommerce Product Management API Documentation",
				url = "https://www.ecommerce.com"
		)
)
public class ProductManagementApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductManagementApiApplication.class, args);
	}

}
