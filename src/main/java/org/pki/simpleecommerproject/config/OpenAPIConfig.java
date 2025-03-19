package org.pki.simpleecommerproject.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;

public class OpenAPIConfig {
    @Bean
    Info info() {
        Info info = new Info();
        info.title("Simple Ecommerce API");
        info.version("1.0");
        info.description("Simple Spring Boot project for Simple Ecommerce API");
        return info;
    }

    @Bean
    Contact contact() {
        Contact contact = new Contact();
        contact.setName("Sepehr");
        contact.setUrl("http://www.sepehr.com");
        contact.setEmail("sepehrjedaridv@gmail.com");
        return contact;
    }

    @Bean
    OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Simple Ecommerce API")
                        .version("1.0")
                        .description("This is a simple API in spring boot for Simple Ecommerce API.")
                        .contact(contact())
                        .license(new License()
                                .name("Apache 2.0")
                                .url("https://www.apache.org/licenses/LICENSE-2.0")));
    }
}
