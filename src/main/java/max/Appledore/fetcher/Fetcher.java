/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package max.Appledore.fetcher;

/**
 *
 * @author FunkyO
 */
import java.net.URL;
import java.text.DateFormat;
import java.util.Date;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import max.Appledore.container.ArticleContainer;
import max.Appledore.container.SourceContainer;
import max.Appledore.domain.Article;
import max.Appledore.domain.Source;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Fetcher {

    private SourceContainer sources;

    public ArticleContainer fetchArticles() {

        ArticleContainer articles = new ArticleContainer();

        for (Source source : this.sources.getSources()) {

            try {
                DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
                Document doc = builder.parse(source.getUrl().openStream());

                NodeList items = doc.getElementsByTagName("item");

                for (int i = 0; i < items.getLength(); i++) {
                    Element item = (Element) items.item(i);
                    String title = getValue(item, "title");
                    String articleURL = getValue(item, "link");
                    String shortText = getValue(item, "description");
                    String imageURL = getValue(item, "image"); // not working yet, needs to be modified to get item child for image url
                    String timestamp = getValue(item, "pubDate");
                    Date time = DateFormat.parse(timestamp);
                    Timestamp stamp = new Timestamp(time.getYear(), time.getMonth(), time.getDay(), time.getHours(), time.getMinutes(), time.getSeconds(), 0);

                    String longText = getFullArticleText(source.getUrl(), source.getTag());

                    articles.addArticle(new Article(title, articleURL, shortText, longText, imageURL, stamp);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return articles;
    }

    public String getValue(Element parent, String nodeName) {
        return parent.getElementsByTagName(nodeName).item(0).getFirstChild().getNodeValue();
    }

    public void setSources(SourceContainer sources) {
        this.sources = sources;
    }

    public String getFullArticleText(String URL, String bodyTag) {
        Document doc = Jsoup.connect(URL).get();
        Element articleText = doc.select(bodyTag);

        return 
    
    }

}
