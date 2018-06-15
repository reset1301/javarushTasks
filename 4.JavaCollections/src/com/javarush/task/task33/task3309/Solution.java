package com.javarush.task.task33.task3309;

import org.w3c.dom.Comment;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.StringWriter;
import java.util.regex.Pattern;

/*
Комментарий внутри xml
*/
public class Solution {
    public static String toXmlWithComment(Object obj, String tagName, String comment) {
        try {
            Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
            JAXBContext context = JAXBContext.newInstance(obj.getClass());
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(obj, document);

            StringWriter stringWriter = new StringWriter();
            NodeList nodeList = document.getElementsByTagName("*");

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                replaceCDATAText(node, document);
                if (node.getNodeName().equals(tagName)) {
                    Comment comm = document.createComment(comment);
                    node.getParentNode().insertBefore(comm, node);
                }
            }

            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
            transformer.transform(new DOMSource(document), new StreamResult(stringWriter));

            return stringWriter.toString();
        } catch (ParserConfigurationException | JAXBException | TransformerException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static void replaceCDATAText(Node node, Document document) {
        if (node.getNodeType() == 3 && Pattern.compile("[<>&'\"]").matcher(node.getTextContent()).find()) {
            Node cdataNode = document.createCDATASection(node.getNodeValue());
            node.getParentNode().replaceChild(cdataNode, node);
        }
        NodeList nodeList = node.getChildNodes();
        for (int i = 0; i < nodeList.getLength(); i++) {
            replaceCDATAText(nodeList.item(i), document);
        }
    }

    @XmlType(name = "anExample")
    @XmlRootElement
    public static class AnExample {
        public String[] needCDATA = new String[]{"need CDATA because of < and >", "1", "2"};
    }

    public static void main(String[] args) {
        String result = Solution.toXmlWithComment(new AnExample(), "needCDATA", "it's a comment - <needCDATA>");
        System.out.println(result);
    }
}
//    public static String toXmlWithComment(Object obj, String tagName, String comment) throws JAXBException {
//        tagName = "<" + tagName;
//
//        JAXBContext context = JAXBContext.newInstance(obj.getClass());
//        Marshaller marshaller = context.createMarshaller();
//        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
//
//        StringWriter writer = new StringWriter();
//        marshaller.marshal(obj, writer);
//        if (!writer.toString().contains(tagName))
//            return writer.toString();
//
//        String[] xmlStrings = writer.toString().split("\n");
//        StringBuilder result = new StringBuilder();
//        if (xmlStrings[0].contains("yes"))
//            result = new StringBuilder(xmlStrings[0].replace("yes", "no").trim() + "\n");
//
//        for (int i = 1; i < xmlStrings.length; i++) {
//            String s = xmlStrings[i];
//            if (s.contains(tagName)) {
//                result.append("<!--").append(comment).append("-->\n");
//            }
//            if (s.matches((".*(&amp;|&lt;|&gt;|'|\").*"))) {
////            if (s.contains("& amp;")||s.contains("& lt;")||s.contains("& gt;")||s.contains("\"")) {
//                s = s.replaceAll("&amp;", "&");
//                s = s.replaceAll("&lt;", "<");
//                s = s.replaceAll("&gt;", ">");
//                s = "<![CDATA[" + s.trim() + "]]>";
////                ss = ss.substring(0, n + 1) + s + ss.substring(k);
//            }
//
//            result.append(s.trim()).append("\n");
//        }
////        System.out.println(result);
////        System.out.println();
//        return result.toString();
//    }
//
//    public static void main(String[] args) throws JAXBException {
//        Object firstSecondObject = new FirstSecondObject();
//        System.out.println(toXmlWithComment(new First(), "second", "it's a comment"));
//    }
//}
