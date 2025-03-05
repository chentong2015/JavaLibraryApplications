package jaxb;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jaxb.demo.Demo;

// marshal: 将Object编组成指定的document xml文件
public class XmlMarshallerDemo {

    public static void main(String[] args) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Demo.class);
        Marshaller marshaller = context.createMarshaller();

        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        Demo person = new Demo("chen", "victor");
        marshaller.marshal(person, System.out);
    }
}
