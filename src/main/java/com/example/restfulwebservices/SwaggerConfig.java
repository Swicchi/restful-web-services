package com.example.restfulwebservices;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@EnableSwagger2
@Configuration
public class SwaggerConfig {
    //All the paths
    //All the apis
    //swagger-ui.html
    private static final Contact DEFAULT_CONTACT =
            new Contact("Remigio", "localhost", "rferna@gmail.com");
    private static final ApiInfo DEFAULT_API_INFO =
            new ApiInfo("Api Title", "Api Documentation", "1.0",
                    "urn:tos", DEFAULT_CONTACT, "Apache 2.0",
                    "http://www.apache.org/licenses/LICENSE-2.0");
    private static Set<String> DEFAULT_PRODUCERS_AND_CONSUMES =
            new HashSet<>(Arrays.asList("application/json","application/xml"));

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(DEFAULT_API_INFO)
                .produces(DEFAULT_PRODUCERS_AND_CONSUMES)
                .consumes(DEFAULT_PRODUCERS_AND_CONSUMES);
    }
}
