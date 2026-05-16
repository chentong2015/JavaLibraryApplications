package org.example.properties.ignore;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public class JsonIgnoreTest {

    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        BeanIgnorance instance = new BeanIgnorance("test", List.of("item1", "item2"));
        System.out.println(objectMapper.writeValueAsString(instance));
    }
}
