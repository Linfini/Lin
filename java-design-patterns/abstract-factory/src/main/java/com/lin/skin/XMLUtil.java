package com.lin.skin;


import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;

public class XMLUtil {
    public static Object getBean() {
        try {
            DocumentBuilderFactory dFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = dFactory.newDocumentBuilder();
            Document doc = builder.parse(new File("java-design-patterns/abstract-factory/src/main/resources/config.xml"));

            //获取包含类名的文本节点
            NodeList nl = doc.getElementsByTagName("className");
            NodeList packet = doc.getElementsByTagName("packet");
            Node classNode = nl.item(0).getFirstChild();
            Node p = packet.item(0).getFirstChild();
            String cName = classNode.getNodeValue();
            String packetName = p.getNodeValue();


            Class<SummerSkinFactory> aClazz = SummerSkinFactory.class;
            ClassLoader classLoader = aClazz.getClassLoader();

            ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
            //通过类名生成实例对象并将返回
            Class<?> c = Class.forName(packetName + "." + cName);
            Object obj;
            obj = c.newInstance();
            return obj;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
