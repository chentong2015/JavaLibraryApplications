package org.example.properties;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.json.JsonMapper;

import java.util.Objects;

// TODO. 定义json->object反序列化时所使用的构造器
public class JsonCreatorProperty {

    private String code;
    private String message;
    private int countErrors;

    @JsonCreator
    public JsonCreatorProperty(@JsonProperty("code") String code,
                               @JsonProperty("message") String message) {
        // 使用Json文件中的属性来初始化
        this.code = Objects.requireNonNull(code, "error code must not be null");
        this.message = Objects.requireNonNull(message, "error message must not be null");
        // 自定义额外的初始化值
        this.countErrors = 10;
    }

    public static void main(String[] args) throws JsonProcessingException {
        String jsonInput = "{\n" +
                "   \"code\": \"1234\",\n" +
                "   \"message\": \"this is a test\"\n" +
                "}";
        JsonMapper jsonMapper = new JsonMapper();
        JsonCreatorProperty object = jsonMapper.readValue(jsonInput, JsonCreatorProperty.class);
        System.out.println(object);
    }
}
