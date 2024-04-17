package rufethuseynov.blogapp.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI(){
        return new OpenAPI().info(
                new Info()
                        .title("")
                        .version("v1")
                        .description("Blog Backend APIs")
                        .contact(
                                new Contact()
                                        .url("https://www.linkedin.com/in/rufeth/")
                                        .email("huseyinovrufet49@gmail.com")
                                        .name("Rufet Huseynov")
                        )
        );

    }

}
