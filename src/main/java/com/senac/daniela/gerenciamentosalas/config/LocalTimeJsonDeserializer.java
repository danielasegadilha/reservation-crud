package com.senac.daniela.gerenciamentosalas.config;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class LocalTimeJsonDeserializer extends JsonDeserializer<LocalTime> {

    @Override
    public LocalTime deserialize(JsonParser jp, DeserializationContext ctxt)
            throws IOException, JsonProcessingException {
        JsonNode node = jp.getCodec().readTree(jp);
        int hour = (node.get("hour") != null) ? node.get("hour").asInt() : 0;
        int minute = (node.get("minute") != null) ? node.get("minute").asInt() : 0;
        int second = (node.get("second") != null) ? node.get("second").asInt() : 0;
        return LocalTime.of(hour, minute, second);
    }
}
