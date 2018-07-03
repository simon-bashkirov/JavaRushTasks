package com.javarush.task.task33.task3309;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

/*
Комментарий внутри xml
*/
public class Solution {
    public static String toXmlWithComment(Object obj, String tagName, String comment) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(obj.getClass());
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        String xml = null;
        try (StringWriter writer = new StringWriter()) {
            marshaller.marshal(obj, writer);
            xml = writer.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String xmlWithComments = null;
        try (StringReader stringReader = new StringReader(xml);
             BufferedReader bufferedReader = new BufferedReader(stringReader);
             StringWriter stringWriter = new StringWriter();
        ) {
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                if (line.matches(".+<" + tagName + ">.*") && !line.matches(".+CDATA.+")) {
                    stringWriter.write("<!--" + comment + "-->" + System.lineSeparator());
                }
                stringWriter.write(line + System.lineSeparator());
            }
            xmlWithComments = stringWriter.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(xmlWithComments);
        return xmlWithComments;
    }

    public static void main(String[] args) throws JAXBException {
        First first = new First();
        first.second.add("S1");
        first.second.add("S2");
        toXmlWithComment(first, "second", "it's a comment");
    }

    @XmlRootElement
    public static class First {
        public List<String> second = new ArrayList<>();

    }
}
