package org.example.properties.include;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CustomComp {

    private final String name;
    private final String namespace;
    private Component component;

    @JsonCreator
    public CustomComp(@JsonProperty("name") final String name,
                      @JsonProperty("namespace") String namespace,
                      @JsonProperty("component") Component component) {
        this.name = name;
        this.namespace = namespace;
        this.component = component;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    // 使用了JsonCreator之后，不能再创建Setter方法
    public void setName(String name) {
        // this.name = name;
    }

    @JsonProperty("namespace")
    public String getNamespace() {
        return namespace;
    }

    public Component getComponent() {
        return component;
    }

}
