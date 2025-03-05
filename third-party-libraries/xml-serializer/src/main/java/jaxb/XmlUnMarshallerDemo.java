package jaxb;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import jaxb.record.Person;
import jaxb.record.Record;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.InputStream;

// unmarshaller: 将xml file编组成指定Object, 对象类型必须匹配XML
public class XmlUnMarshallerDemo {

    public static void main(String[] args) throws Exception {
        ClassLoader classLoader = XmlUnMarshallerDemo.class.getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("records.xml");

        XMLInputFactory inputFactory = XMLInputFactory.newInstance();
        XMLStreamReader reader = inputFactory.createXMLStreamReader(inputStream);

        JAXBContext context = JAXBContext.newInstance(Record.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();

        Record record = (Record) unmarshaller.unmarshal(reader);
        Person person = record.getPerson().get(0);
        System.out.println(person.getDescription().getValue());
    }
}
