package org.example.properties;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonIgnoreProperty {

    public static void main(String[] args) throws JsonProcessingException {
        String jsonInput = "{\n" +
                "   \"firstName\": \"Homer\",\n" +
                "   \"middleName\": \"Jay\",\n" +
                "   \"lastName\": \"Simpson\"\n" +
                "}";
        ObjectMapper mapper = new ObjectMapper();
        Student student = mapper.readValue(jsonInput, Student.class);
        System.out.println(student.firstName);
        System.out.println(student.lastName);

        Student student2 = new Student();
        student2.firstName = "first";
        student2.lastName = "last";
        System.out.println(mapper.writeValueAsString(student2));
    }

    // TODO. 从Json转换成object的时候，忽略无法识别的属性
    @JsonIgnoreProperties(ignoreUnknown = true)
    static class Student {

        public String firstName;
        public String lastName;

        public Student() {}

        // 不参与Json序列化的字段
        @JsonIgnore
        private int statusCode;
    }
}
