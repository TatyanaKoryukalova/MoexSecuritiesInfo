package com.moex.securitiesinfo.xml_handler;

import com.moex.securitiesinfo.model.DataSet;
import com.moex.securitiesinfo.xml_handler.element_handler.Deserializer;
import org.hibernate.TypeMismatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MoexXmlHandler<T extends DataSet> implements XmlHandler<T> {

    @Autowired
    private Deserializer<T> deserializer;

    private List<T> items;
    private int length;

    private static final String ELEMENT_TAG_NAME = "row";

    @Override
    public void handle(File file) throws IOException, SAXException {
        items = new ArrayList<>();
        Document document = parseFile(file);
        NodeList nodeList = document.getElementsByTagName(ELEMENT_TAG_NAME);
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node.getNodeType() != Node.ELEMENT_NODE) {
                throw new TypeMismatchException("Wrong type");
            }
            Element element = (Element) node;
            items.add(deserializer.deserialize(element));
        }
        length = items.size();
    }

    private Document parseFile(File file) throws IOException, SAXException {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = null;
        try {
            documentBuilder = documentBuilderFactory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        Document document;
        document = documentBuilder.parse(file);
        document.getDocumentElement().normalize();
        return document;
    }

    @Override
    public int getLength() {
        return length;
    }

    @Override
    public T item(int index) {
        return items.get(index);
    }
}
