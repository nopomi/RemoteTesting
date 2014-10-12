/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package max.Appledore.container;

import java.util.ArrayList;
import max.Appledore.domain.Article;

/**
 *
 * @author FunkyO
 */
public class ArticleContainer {

    private ArrayList<Article> articles;

    public ArticleContainer() {

        this.articles = new ArrayList<Article>();

    }

    public void addArticle(Article article) {

        this.articles.add(article);

    }

    public ArrayList<Article> getArticles() {

        return this.articles;

    }
}
