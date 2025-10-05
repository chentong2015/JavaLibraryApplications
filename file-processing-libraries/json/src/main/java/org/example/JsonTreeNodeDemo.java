package org.example;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class JsonTreeNodeDemo {

    private static String value = "{\n" +
            "   \"displayName\":\"The Hello\",\n" +
            "   \"description\":\"This is a sample\",\n" +
            "   \"integrationPoints\":[\n" +
            "      \"maintenance\",\n" +
            "      \"test\"\n" +
            "   ]\n" +
            "}";

    public static void main(String[] args) throws IOException {
        byte[] bytes = value.getBytes(StandardCharsets.UTF_8);
        InputStream inputStream = new ByteArrayInputStream(bytes);

        // TODO. 判断Json数据节点node是否包含指定的field字段
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(inputStream);
        if (jsonNode.has("integrationPoints")) {
            System.out.println(jsonNode.get("integrationPoints"));
            System.out.println(jsonNode.get("integrationPoints").isArray());

            JsonParser jsonParser = jsonNode.get("integrationPoints").traverse();
            List<String> intPoints = objectMapper.readValue(jsonParser, new TypeReference<>() {});
            System.out.println(intPoints.contains("maintenance"));
        }

        // TODO. 根据JsonNode节点反序列化成Oject对象
        NodeClass nodeClass = objectMapper.treeToValue(jsonNode, NodeClass.class);
        System.out.println(nodeClass);
    }

    static class NodeClass {
        private static String displayName;
        private static String description;
        private static String[] integrationPoints;
    }
}
