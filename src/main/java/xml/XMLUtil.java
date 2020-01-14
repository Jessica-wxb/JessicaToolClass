package xml;

import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;

/**
 * @ClassName XMLUtil
 * @Description TODO
 * @Author 王小波
 * @Date 2020/1/7 16:39
 * @Version 1.0
 **/
public class XMLUtil {
    public static Object getBean(String path, String tagName) {
        try {
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            Document document = builder.parse(new File(path));

            String firstChild = document.getElementsByTagName(tagName).item(1).getFirstChild().getNodeValue();

            Class aClass = Class.forName(firstChild);
            Object o = aClass.newInstance();
            return o;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
