package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class DemoObjectMapper {

    // 对HashMap<>解析的默认结果为"{}"空JSON
    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, String> objectProperties = new HashMap<>();
        String strDtaRaw = objectMapper.writeValueAsString(objectProperties);

        if (strDtaRaw.getBytes(StandardCharsets.UTF_8).length > 10) {
            System.out.println("> max");
        } else {
            System.out.println("< max");
        }
    }
}