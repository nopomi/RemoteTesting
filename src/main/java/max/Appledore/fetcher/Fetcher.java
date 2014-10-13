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
import java.io.IOException;
import java.net.URL;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import max.Appledore.container.ArticleContainer;
import max.Appledore.container.SourceContainer;
import max.Appledore.domain.Article;
import max.Appledore.domain.Source;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;


public class Fetcher {

    private SourceContainer sources;

    public ArticleContainer fetchArticles() {

        ArticleContainer articles = new ArticleContainer();
        JSoupFetcher jsoup = new JSoupFetcher();
        

        for (Source source : this.sources.getSources()) {

            try {
                DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
                Document doc = builder.parse(source.getUrl());

                NodeList items = doc.getElementsByTagName("item");

                for (int i = 0; i < items.getLength(); i++) {
                    Element item = (Element) items.item(i);
                    String title = getValue(item, "title");                    
                    String articleURL = getValue(item, "link");                    
                    String shortText = getValue(item, "description");                    
//                    String imageURL = getValue(item, "image"); // not working yet, needs to be modified to get item child for image url
//                    String timestamp = getValue(item, "pubDate");
//                    Date time = DateFormat.parse(timestamp);
//                    Timestamp stamp = new Timestamp(time.getYear(), time.getMonth(), time.getDay(), time.getHours(), time.getMinutes(), time.getSeconds(), 0);
                    
                    Timestamp stamp = new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());                  
                    String imageURL = "http://www.hallaminternet.com/assets/URL-tagging-image.png";
                    String longText = jsoup.getFullArticleText("http://www.bbc.com/news/technology-29567196", source.getTag());

                    articles.addArticle(new Article(title, articleURL, shortText, longText, imageURL, stamp));
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

    

}
