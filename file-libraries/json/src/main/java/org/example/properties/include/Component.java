package org.example.properties.include;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Component {

    private final String componentName;

    @JsonCreator
    public Component(@JsonProperty("componentName") String componentName) {
        this.componentName = componentName;
    }

    @JsonProperty("componentName")
    public String getComponentName() {
        return componentName;
    }
}
