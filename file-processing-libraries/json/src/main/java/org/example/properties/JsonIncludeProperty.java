package org.example.properties;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonIncludeProperty {

    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        // 通过Object添加的注解可以忽略对null属性的序列化
        // {"firstName":"chen","lastName":"tong"}
        Person p = new Person();
        System.out.println(objectMapper.writeValueAsString(p));
    }

    // 在对象序列化成json的过程中，忽略null属性值的序列化
    @JsonInclude(JsonInclude.Include.NON_NULL)
    static class Person {

        public String firstName = "chen";
        public String middleName;
        public String lastName = "tong";
    }
}
