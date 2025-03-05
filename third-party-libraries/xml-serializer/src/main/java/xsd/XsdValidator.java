package xsd;

import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.*;
import java.net.URL;
import java.nio.file.FileSystems;
import java.nio.file.Path;

public class XsdValidator {

    public static void main(String[] args) throws IOException, SAXException {
        // 系统路径下的文件: 用于自定义输入路径
        Path path = FileSystems.getDefault().getPath("third-party-libraries",
               "xml-serializer", "src", "main", "resources", "entity.xml");
        String xmlFilePath = path.toAbsolutePath().toString();
        File xmlfile = new File(xmlFilePath);
        StreamSource streamSource = new StreamSource(xmlfile);

        // URL Classpath文件路径: 项目中包含的约束文件
        String classPathXsdFileName = "entity.xsd";
        URL url = XsdValidator.class.getClassLoader().getResource(classPathXsdFileName);

        // Validate .xml file with .xsd Schema
        SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Schema schema = factory.newSchema(url);
        Validator validator = schema.newValidator();
        validator.validate(streamSource);
        System.out.println("Validation Done");
    }
}
