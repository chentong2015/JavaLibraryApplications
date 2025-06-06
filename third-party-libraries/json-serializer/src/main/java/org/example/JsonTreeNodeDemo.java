package org.example;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.sample.Person;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class JsonTreeNodeDemo {

    // Jackson判断json文件中的node是否包含指定的field字段
    public static void main(String[] args) throws IOException {
        String value = "{\n" +
                "   \"displayName\":\"The Hello\",\n" +
                "   \"description\":\"This is a sample\",\n" +
                "   \"integrationPoints\":[\n" +
                "      \"maintenance\",\n" +
                "      \"test\"\n" +
                "   ]\n" +
                "}";
        byte[] bytes = value.getBytes(StandardCharsets.UTF_8);
        InputStream inputStream = new ByteArrayInputStream(bytes);

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(inputStream);
        if (jsonNode.has("integrationPoints")) {
            System.out.println(jsonNode.get("integrationPoints"));
            System.out.println(jsonNode.get("integrationPoints").isArray());

            JsonParser jsonParser = jsonNode.get("integrationPoints").traverse();
            List<String> intPoints = objectMapper.readValue(jsonParser, new TypeReference<>() {});
            System.out.println(intPoints.contains("maintenance"));
        }
    }

    // TODO. 从InputStream流中的指定路径下取出json节点，反序列化成指定的对象
    public Person testObjectMapperTree() {
        String jsonPath = "/persons/coder/master/";
        try (InputStream inputStream = new FileInputStream("test.txt")) {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(inputStream);
            JsonNode node = root.at(jsonPath);
            return mapper.treeToValue(node, Person.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
