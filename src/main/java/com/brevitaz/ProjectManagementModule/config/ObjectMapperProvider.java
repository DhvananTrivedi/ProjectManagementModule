package com.brevitaz.ProjectManagementModule.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ObjectMapperProvider {


    private static ObjectMapper mapper;

    public ObjectMapperProvider()
    {
    }

    @Bean
    public ObjectMapper getInstance()
    {
        if (mapper == null) {
            mapper = new ObjectMapper();
            return mapper;
        }
        return mapper;

    }

}
