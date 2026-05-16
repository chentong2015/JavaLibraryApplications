package java_xml;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.InputStream;

// TODO. 使用Java XML原生库的API
public class JavaXmlStreamReader {

    public static void main(String[] args) throws XMLStreamException {
        ClassLoader classLoader = JavaXmlStreamReader.class.getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("records.xml");

        // 加载指定文件的XML读取流
        XMLInputFactory inputFactory = XMLInputFactory.newInstance();
        XMLStreamReader xmlStreamReader = inputFactory.createXMLStreamReader(inputStream);

        parseXmlElement(xmlStreamReader);
    }

    private static void parseXmlElement(XMLStreamReader reader) throws XMLStreamException {
        while (reader.hasNext()) {
            int event = reader.next();
            switch (event) {
                case XMLStreamConstants.START_ELEMENT:
                    String elementName = reader.getLocalName();
                    System.out.println("Start Element: " + elementName);
                    // 读取某个<Element>元素标签包含的所有属性
                    for (int i = 0; i < reader.getAttributeCount(); i++) {
                        String attrName = reader.getAttributeLocalName(i);
                        String attrValue = reader.getAttributeValue(i);
                        System.out.println("   Attribute: " + attrName + " = " + attrValue);
                    }
                    break;
                case XMLStreamConstants.CHARACTERS:
                    String text = reader.getText().trim();
                    System.out.println("   Content: " + text);
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    System.out.println("End Element: " + reader.getLocalName());
                    break;
            }
        }
    }
}
