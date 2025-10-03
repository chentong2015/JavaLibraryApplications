package w3c_document;

import com.jcabi.xml.XMLDocument;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.DocumentType;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

// DOM(Document Object Model) 文件对象模型
public class W3cDocumentWriter {

    // TODO. 自定义生成XML格式的Document文件
    public static void main(String[] args) {
        DOMImplementation domImplementation = getDocumentBuilder().getDOMImplementation();
        DocumentType docType = domImplementation.createDocumentType("hibernate-mapping",
                "-//Hibernate/Hibernate Mapping DTD 3.0//EN",
                "http://www.hibernate.org/dtd/hibernate-mapping-3.0.dtd");
        Document document = domImplementation.createDocument(null, "hibernate-mapping", docType);
        document.getDocumentElement().setAttribute("default-cascade", "none");
        document.getDocumentElement().setAttribute("default-access", "property");
        document.getDocumentElement().setAttribute("auto-import", "false");

        Element classNode = document.createElement("class");
        String className = W3cDocumentWriter.class.getName();
        classNode.setAttribute("table", "t_table");
        classNode.setAttribute("entity-name", className);
        classNode.setAttribute("name", className);

        Element idElement = document.createElement("id");
        idElement.setAttribute("column", "column_name");
        idElement.setAttribute("name", "property_name");
        idElement.setAttribute("type", "property_type");
        classNode.appendChild(idElement);

        document.getDocumentElement().appendChild(classNode);
        printDocumentToXml(document);
    }

    private static DocumentBuilder getDocumentBuilder() {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setValidating(false);
            return factory.newDocumentBuilder();
        } catch (ParserConfigurationException ex) {
            throw new RuntimeException(ex);
        }
    }

    // 将生成的dom Node节点转换成xml字符串
    // <?xml version="1.0" encoding="UTF-8" standalone="no"?>
    // <hibernate-mapping auto-import="false" default-access="property" default-cascade="none">
    //    <class entity-name="com.java.others.XML.W3cDocumentDemo" name="com.java.others.XML.W3cDocumentDemo" table="t_table"/>
    // </hibernate-mapping>
    private static void printDocumentToXml(Document document) {
        String xml = new XMLDocument(document).toString();
        System.out.println(xml);
    }
}
