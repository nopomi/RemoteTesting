/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package max.Appledore.main;

import dbretriever.SourceRetriever;
import dbsaver.ArticleSaver;
import max.Appledore.container.ArticleContainer;
import max.Appledore.container.SourceContainer;
import max.Appledore.domain.Source;
import max.Appledore.fetcher.Fetcher;

/**
 *
 * @author FunkyO
 */
public class Appledore {

    //this class still needs the code for retrieving the sources from the database, 
    //and checking for new Sources on each loop (or on startup, depending on what we decided).
    public static void main(String[] args) {

        SourceRetriever sourceRetriever = new SourceRetriever();
        SourceContainer sources = new SourceContainer();
        testInitialization(sources);

        Fetcher fetcher = new Fetcher();
        ArticleSaver saver = new ArticleSaver();

        fetcher.setSources(sources);

        run(fetcher, saver);

    }

    public static void run(Fetcher fetcher, ArticleSaver saver) {
        while (true) {
            ArticleContainer articles = fetcher.fetchArticles();
            saver.save(articles);
            Thread.sleep(3600000);
        }
    }

    public static void testInitialization(SourceContainer sources) {
        Source source1 = new Source("http://feeds.bbci.co.uk/news/technology/rss.xml", 1, "div.story-body p");
        sources.addSource(source1);

    }

}
