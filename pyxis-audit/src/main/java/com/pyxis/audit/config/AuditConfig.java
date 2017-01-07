package com.pyxis.audit.config;

import org.javers.core.Javers;
import org.javers.core.JaversBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.gson.Gson;

@Configuration
public class AuditConfig {

    @Bean
    public Javers javers() {
        return JaversBuilder.javers().build();
    }

    @Bean
    public Gson gson() {
        return new Gson();
    }

}
