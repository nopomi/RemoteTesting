/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package max.Appledore.dbsaver;

import java.util.ArrayList;
import max.Appledore.container.ArticleContainer;
import max.Appledore.domain.Article;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author FunkyO
 */
public class ArticleSaver {

    public void saveArticles(ArticleContainer articles) throws ClassNotFoundException {

        try {
            String url = "jdbc:msql://200.210.220.1:1114/Demo";
            Connection conn = DriverManager.getConnection(url, "", ""); //requires url, username and password as parameter
            Statement st = conn.createStatement();
            for (Article article : articles.getArticles()) {
                st.executeUpdate("INSERT INTO articles VALUES ('" + article.getTitle() + "', '" + article.getShortText() + "', '" + article.getLongText() + "', '" + article.getImageURL() + "', '" + article.getArticleURL() + "', '" + article.getDate());                
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
