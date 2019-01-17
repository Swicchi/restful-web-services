package com.example.restfulwebservices;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfig {
    //All the paths
    //All the apis
    //swagger-ui.html
    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2);
    }

}
