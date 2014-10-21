/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package max.Appledore.fetcher;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/**
 *
 * @author User
 */
public class JSoupFetcher {
    
    

    public JSoupFetcher() {
    }
    
    public String getFullArticleText(String URL, String bodyTag) {
        Document doc;
        String fullText = "";
        try {
            doc = Jsoup.connect(URL).get();
            Elements articleText = doc.select(bodyTag);            
            fullText = articleText.text();
            
        } catch (IOException e) {
            e.printStackTrace();
        }

        return fullText;
    }
    
    
    
}
