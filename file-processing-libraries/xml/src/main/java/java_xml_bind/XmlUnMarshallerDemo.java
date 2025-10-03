package java_xml_bind;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Unmarshaller;
import model.Person;
import model.Record;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.InputStream;

// unmarshaller: 将xml文件编组成Object, 类型必须匹配XML格式
public class XmlUnMarshallerDemo {

    public static void main(String[] args) throws Exception {
        JAXBContext context = JAXBContext.newInstance(Record.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();

        Record record = (Record) unmarshaller.unmarshal(getXmlStreamReader());
        Person person = record.getPerson().get(0);
        System.out.println(person.getDescription().getValue());
    }

    // 加载指定文件的XML读取流
    private static XMLStreamReader getXmlStreamReader() throws XMLStreamException {
        ClassLoader classLoader = XmlUnMarshallerDemo.class.getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("records.xml");

        XMLInputFactory inputFactory = XMLInputFactory.newInstance();
        return inputFactory.createXMLStreamReader(inputStream);
    }
}
