package net.javaguides.employeeservice.util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateBean {
    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
