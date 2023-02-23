package net.javaguides.employeeservice.util;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperBean {
    @Bean
    public ModelMapper getModelMapper(){
        return new ModelMapper();
    }
}
