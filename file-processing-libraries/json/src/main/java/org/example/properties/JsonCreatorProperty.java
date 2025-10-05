package org.example.properties;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class JsonCreatorProperty {

    private String code;
    private String message;
    private int countErrors;

    // TODO. 定义json->object反序列化时所使用的构造器
    @JsonCreator
    public JsonCreatorProperty(@JsonProperty("code") String code,
                               @JsonProperty("message") String message) {
        this.code = Objects.requireNonNull(code, "error code must not be null");
        this.message = Objects.requireNonNull(message, "error message must not be null");
    }



}
