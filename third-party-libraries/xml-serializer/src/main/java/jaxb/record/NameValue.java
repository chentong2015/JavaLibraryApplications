package jaxb.record;

import jakarta.xml.bind.annotation.*;
import java.util.List;

// TODO. 配置XML上级的根标签和Property属性的顺序
@XmlRootElement(name = "NameValue")
@XmlType(name = "", propOrder = {
    "firstName",
    "middleName",
    "surname",
})
@XmlAccessorType(XmlAccessType.FIELD)
public class NameValue {

    @XmlElement(name = "FirstName")
    protected List<String> firstName;

    @XmlElement(name = "MiddleName")
    protected List<String> middleName;

    @XmlElement(name = "Surname")
    protected List<String> surname;

    public List<String> getFirstName() {
        return firstName;
    }

    public List<String> getMiddleName() {
        return middleName;
    }

    public List<String> getSurname() {
        return surname;
    }
}