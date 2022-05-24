package com.shayandaneshvar.cucumberdemo.cucumber.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.DefaultDataTableCellTransformer;
import io.cucumber.java.DefaultDataTableEntryTransformer;
import io.cucumber.java.DefaultParameterTransformer;

import java.lang.reflect.Type;

public class CucumberConfig {
    private final ObjectMapper objectMapper = new ObjectMapper();

    @DefaultDataTableCellTransformer
    @DefaultDataTableEntryTransformer
    @DefaultParameterTransformer
    public <T> T convert(Object object, Type type) {
        return objectMapper.convertValue(object, objectMapper.constructType(type));
    }


}
