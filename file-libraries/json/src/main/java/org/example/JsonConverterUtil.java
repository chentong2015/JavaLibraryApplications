package org.example;

import com.fasterxml.jackson.annotation.JsonIgnoreType;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.json.JsonMapper;
import jakarta.xml.bind.JAXBElement;
import java.text.DateFormat;

// 2.10以前低版本的APIs
// JsonMapper jsonMapper = new JsonMapper();
// jsonMapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
// jsonMapper.configure(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY, true);
// jsonMapper.addMixIn(JAXBElement.class, JAXBElementMixIn.class);
public class JsonConverterUtil {

    // TODO. JsonMapper通过继承和Builder模式构建ObjectMapper类型API
    private final JsonMapper jsonMapper;

    // TODO. 注意null属性的忽略和生成属性的排序效果
    // 1. Making JSON serializer ignore null and empty objects
    // 2. Specifying object properties serialization order
    // 3. Unwrapping JAXBElement object
    public JsonConverterUtil() {
        jsonMapper = JsonMapper.builder()
                .serializationInclusion(JsonInclude.Include.NON_EMPTY)
                .configure(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY, true)
                .addMixIn(JAXBElement.class, JAXBElementMixIn.class)
                .build();
        // Configuring the default DateFormat to use
        // when serializing time values as Strings, and deserializing from JSON Strings.
        jsonMapper.setDateFormat(DateFormat.getDateInstance());
    }

    public String toJson(Object object) {
        try {
            return jsonMapper.writeValueAsString(object);
        } catch (JsonProcessingException ex) {
            throw new RuntimeException(ex);
        }
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

    @JsonIgnoreType
    private abstract class MixIn {
    }

    private interface JAXBElementMixIn {
        @JsonValue
        Object getValue();
    }
}
