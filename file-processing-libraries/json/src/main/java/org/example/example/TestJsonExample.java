package org.example.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;

public class TestJsonExample {

    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        MyInstance instance = new MyInstance("test", List.of("item1", "item2"));
        System.out.println(objectMapper.writeValueAsString(instance));

        MyJsonComponent component = new MyJsonComponent("component name");
        System.out.println(objectMapper.writeValueAsString(component));

        MyJsonInstance jsonInstance = new MyJsonInstance("name", "namespace", component);
        System.out.println(objectMapper.writeValueAsString(jsonInstance.getName()));
    }
}
