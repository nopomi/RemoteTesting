/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package max.Appledore.main;

import max.Appledore.container.ArticleContainer;
import max.Appledore.container.SourceContainer;
import max.Appledore.dbretriever.SourceRetriever;
import max.Appledore.dbsaver.ArticleSaver;
import max.Appledore.domain.Article;
import max.Appledore.domain.Source;
import max.Appledore.fetcher.Fetcher;

/**
 *
 * @author FunkyO
 */
public class Appledore {

    //this class still needs the code for retrieving the sources from the database, 
    //and checking for new Sources on each loop (or on startup, depending on what we decided).
    public static void main(String[] args) throws Exception {

        SourceRetriever sourceRetriever = new SourceRetriever();
        SourceContainer sources = new SourceContainer();
        testInitialization(sources);

        Fetcher fetcher = new Fetcher();
        ArticleSaver saver = new ArticleSaver();

        fetcher.setSources(sources);
        try {
        run(fetcher, saver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public static void run(Fetcher fetcher, ArticleSaver saver) throws Exception{
        while (true) {
            ArticleContainer articles = fetcher.fetchArticles();
            saver.saveArticles(articles);
            for (Article article : articles.getArticles()) {
                System.out.println(article.toString());
            }
            
            
            try {
            Thread.sleep(3600000);
            } catch (InterruptedException e) {
            e.printStackTrace();
            }
        }
    }

    public static void testInitialization(SourceContainer sources) {
        Source source1 = new Source("http://feeds.bbci.co.uk/news/world/europe/rss.xml", 1, "div.story-body p");
        Source source2 = new Source("http://feeds.reuters.com/reuters/technologyNews", 2, "span.focusParagraph p");
        sources.addSource(source1);
        sources.addSource(source2);       

    }

}
