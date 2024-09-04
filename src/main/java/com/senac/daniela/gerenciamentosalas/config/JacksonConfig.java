package com.senac.daniela.gerenciamentosalas.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.LocalTime;

@Configuration
public class JacksonConfig {

    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        SimpleModule module = new SimpleModule();

        // Registrando serializadores e desserializadores para LocalTime
        module.addSerializer(LocalTime.class, new LocalTimeJsonSerializer());
        module.addDeserializer(LocalTime.class, new LocalTimeJsonDeserializer());

        // Registrando serializadores e desserializadores para LocalDate
        module.addSerializer(LocalDate.class, new LocalDateJsonSerializer());
        module.addDeserializer(LocalDate.class, new LocalDateJsonDeserializer());

        objectMapper.registerModule(module);
        return objectMapper;
    }
}
