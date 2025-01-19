package br.com.main.project.contalogic.complementarymodules.webservices.geolocation;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataConverter implements IDataConverter{

    private ObjectMapper mapper = new ObjectMapper();

    @Override
    public <T> T getData(String json, Class<T> finalClass) {
        try {
            return mapper.readValue(json, finalClass);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
