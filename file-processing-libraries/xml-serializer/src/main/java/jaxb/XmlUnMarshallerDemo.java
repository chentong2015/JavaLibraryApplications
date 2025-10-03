package jaxb;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Unmarshaller;
import jaxb.record.Person;
import jaxb.record.Record;

// unmarshaller: 将xml文件编组成Object, 类型必须匹配XML格式
public class XmlUnMarshallerDemo {

    public static void main(String[] args) throws Exception {
        JAXBContext context = JAXBContext.newInstance(Record.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();

        Record record = (Record) unmarshaller.unmarshal(JavaXmlStreamReader.getXmlStreamReader());
        Person person = record.getPerson().get(0);
        System.out.println(person.getDescription().getValue());
    }
}
