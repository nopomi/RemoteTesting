/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package max.Appledore.domain;

import java.sql.Timestamp;
import java.util.Date;

/**
 *
 * @author FunkyO
 */
public class Article {

    private String title;
    private String articleURL;
    private String shortText;
    private String longText;
    private String imageURL;
    private Timestamp timestamp;

    public Article(String title, String articleURL, String shortText, String longText, String imageURL, Timestamp timestamp) {

        this.title = title;
        this.articleURL = articleURL;
        this.shortText = shortText;
        this.longText = longText;
        this.imageURL = imageURL;
        this.timestamp = timestamp;

    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArticleURL() {
        return this.articleURL;
    }

    public void setArticleURL(String articleURL) {
        this.articleURL = articleURL;
    }

    public String getShortText() {
        return this.shortText;
    }

    public void setShortText(String shortText) {
        this.shortText = shortText;
    }

    public String getLongText() {
        return this.longText;
    }

    public void setLongText(String longText) {
        this.longText = longText;
    }

    public String getImageURL() {
        return this.imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public Timestamp getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = (Timestamp) timestamp;
    }

}
