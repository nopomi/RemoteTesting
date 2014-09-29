package max.Appledore;

import java.net.URL;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class RSSReader {

    private URL url;

    public RSSReader(URL url) {
        this.url = url;
    }

    public void printFeed() {

        try {
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document doc = builder.parse(url.openStream());

            NodeList items = doc.getElementsByTagName("item");

            for (int i = 0; i < items.getLength(); i++) {
                Element item = (Element) items.item(i);
                System.out.println(getValue(item, "title"));
                System.out.println(getValue(item, "description"));
                System.out.println(getValue(item, "link"));
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getValue(Element parent, String nodeName) {
        return parent.getElementsByTagName(nodeName).item(0).getFirstChild().getNodeValue();
    }

    }
