package com.microservices.appointmentservice.config;


import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
public class AppointmentConfiguration {

    @Bean
    public ModelMapper modelMapper(){
        return  new ModelMapper();
    }
}
