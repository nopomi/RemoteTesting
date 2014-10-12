/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package max.Appledore.domain;

/**
 *
 * @author FunkyO
 */
public class Source {

    private int sourceId;
    private String sourceUrl;
    private String bodyTag;

    public Source(String url, int id, String tag) {

        this.sourceId = id;
        this.sourceUrl = url;
        this.bodyTag = tag;

    }

    public int getId() {
        return this.sourceId;
    }

    public String getUrl() {
        return this.sourceUrl;
    }

    public String getTag() {
        return this.bodyTag;
    }

}
