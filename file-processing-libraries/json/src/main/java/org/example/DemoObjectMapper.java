package org.example;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DemoObjectMapper {

    public static void main(String[] args) throws JsonProcessingException {
        String jsonInput = "{\n" +
                "   \"isEightByte\": \"true\",\n" +
                "   \"numberValidationLevel\": \"100\"\n" +
                "}";

        ObjectMapper objectMapper = new ObjectMapper();
        MapperClass mapperClass = objectMapper.readValue(jsonInput, MapperClass.class);
        System.out.println(mapperClass);
    }

    static class MapperClass {

        @JsonProperty("isEightByte")
        private boolean isEightByte;

        // TODO. 从指定的字符串中解析出整型的值
        @JsonProperty("numberValidationLevel")
        private int numberValidationLevel;

        public MapperClass() {}

        public MapperClass(boolean isEightByte, int numberValidationLevel) {
            this.isEightByte = isEightByte;
            this.numberValidationLevel = numberValidationLevel;
        }
    }
}
