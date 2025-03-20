package jaxb;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.events.XMLEvent;
import java.io.InputStream;

public class JavaXmlStreamReader {

    public static void main(String[] args) throws XMLStreamException {
        XMLStreamReader xmlStreamReader = getXmlStreamReader();
        while (xmlStreamReader.hasNext()) {
            int eventType = xmlStreamReader.next();
            if (eventType == XMLEvent.START_ELEMENT) {
                parseElement(xmlStreamReader);
                return;
            }
        }
    }

    // 加载指定文件的XML读取流
    public static XMLStreamReader getXmlStreamReader() throws XMLStreamException {
        ClassLoader classLoader = XmlUnMarshallerDemo.class.getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("records.xml");

        XMLInputFactory inputFactory = XMLInputFactory.newInstance();
        return inputFactory.createXMLStreamReader(inputStream);
    }

    // TODO. 只有当读取文件的开头才能解析文件数据
    private static void parseElement(XMLStreamReader xmlStreamReader) {
        String elementName = xmlStreamReader.getName().toString();
        System.out.println(elementName);
        String elementValue = xmlStreamReader.getAttributeValue(null, "title");
        System.out.println(elementValue);
    }
}
