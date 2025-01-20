package br.com.main.project.contalogic.complementarymodules.webservices.utilities;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

@Component
public class DataConverter implements IDataConverter {

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
