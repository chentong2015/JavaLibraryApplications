package jaxb;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import jaxb.model.Person;
import jaxb.model.Record;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.InputStream;

// unmarshaller: 将xml file编组成指定Object, 对象类型必须匹配XML
public class XmlUnMarshallerDemo {

    public static void main(String[] args) throws Exception {
        ClassLoader classLoader = XmlUnMarshallerDemo.class.getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("records.xml");
        readXml(inputStream, Record.class);
    }

    public static void readXml(InputStream inputStream, Class<?> clazz) throws XMLStreamException, JAXBException {
        XMLInputFactory inputFactory = XMLInputFactory.newInstance();
        XMLStreamReader reader = inputFactory.createXMLStreamReader(inputStream);

        JAXBContext context = JAXBContext.newInstance(clazz);
        Unmarshaller unmarshaller = context.createUnmarshaller();

        Record record = (Record) unmarshaller.unmarshal(reader);
        Person person = record.getPerson().get(0);
        System.out.println(person.getDescription().getValue());
    }
}
