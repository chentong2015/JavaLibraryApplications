package jaxb.record;

import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.CollapsedStringAdapter;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlRootElement(name = "person")
@XmlType(name = "", propOrder = {
        "value"
})
@XmlAccessorType(XmlAccessType.FIELD)
public class Description {

    // TODO. value标识属性标签内的值
    @XmlValue
    protected String value;

    @XmlAttribute(name = "Id", required = true)
    protected String id;

    @XmlAttribute(name = "Type", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String type;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
