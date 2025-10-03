package java_xml;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.*;
import java.net.URL;

// TODO. 使用Java XML原生库的API来验证文件的有效性
public class JavaXmlXsdValidator {

    public static void main(String[] args) throws Exception {
        URL resourceUrl = JavaXmlXsdValidator.class.getClassLoader().getResource("entity.xml");
        File file = new File(resourceUrl.toURI());
        StreamSource streamSource = new StreamSource(file);

        // URL Classpath文件路径: 项目中包含的约束文件
        URL url = JavaXmlXsdValidator.class.getClassLoader().getResource("entity.xsd");

        // Validate .xml file with .xsd Schema
        SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Schema schema = SchemaFactory.newDefaultInstance().newSchema(url);
        Validator validator = schema.newValidator();
        validator.validate(streamSource);
        System.out.println("Validation Done");
    }
}
