package org.example;

import com.fasterxml.jackson.annotation.JsonIgnoreType;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.json.JsonMapper;
import jakarta.xml.bind.JAXBElement;
import java.text.DateFormat;

public class JsonConverterUtil {

    // TODO. JsonMapper通过继承和Builder模式构建ObjectMapper类型API
    private final JsonMapper jsonMapper;

    // TODO. 注意null属性的忽略和生成属性的排序效果
    // 1. Making JSON serializer ignore null and empty objects
    // 2. Specifying object properties serialization order
    // 3. Unwrapping JAXBElement object
    private JsonConverterUtil() {
        jsonMapper = JsonMapper.builder()
                .serializationInclusion(JsonInclude.Include.NON_EMPTY)
                .configure(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY, true)
                .addMixIn(JAXBElement.class, JAXBElementMixIn.class)
                .build();
        jsonMapper.setDateFormat(DateFormat.getDateInstance());
    }

    public static JsonConverterUtil getInstance() {
        return new JsonConverterUtil();
    }

    public JsonConverterUtil ignore(Class<?> type) {
        addMixIn(type, MixIn.class);
        return this;
    }

    public JsonConverterUtil ignore(Class<?> type, Class<?> mixInSource) {
        addMixIn(type, mixInSource);
        return this;
    }

    private void addMixIn(Class<?> target, Class<?> mixInSource) {
        jsonMapper.addMixIn(target, mixInSource);
    }

    public String toJson(Object object) {
        return toCleanJson(object);
    }

    private String toCleanJson(Object object) {
        try {
            return jsonMapper.writeValueAsString(object);
        } catch (JsonProcessingException ex) {
            throw new RuntimeException(ex);
        }
    }

    @JsonIgnoreType
    private abstract class MixIn {
    }

    private interface JAXBElementMixIn {
        @JsonValue
        Object getValue();
    }
}
