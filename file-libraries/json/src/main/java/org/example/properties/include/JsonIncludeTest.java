package org.example.properties.include;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonIncludeTest {

    public static void main(String[] args) throws JsonProcessingException {
       ObjectMapper objectMapper = new ObjectMapper();

       Component component = new Component("component name");
       System.out.println(objectMapper.writeValueAsString(component));

       CustomComp jsonInstance = new CustomComp("name", "namespace", component);
       System.out.println(objectMapper.writeValueAsString(jsonInstance.getName()));
    }
}
