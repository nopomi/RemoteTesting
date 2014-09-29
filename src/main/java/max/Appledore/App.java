package max.Appledore;

import java.net.MalformedURLException;
import java.net.URL;


public class App {
    
    public static void main(String[] args) throws MalformedURLException{
        URL url = null;
        
        try{
        url = new URL("http://feeds.reuters.com/reuters/technologyNews");
        
        }catch(MalformedURLException e){
            System.out.println("Malformed url!");
        }
        
        RSSReader rssReader = new RSSReader(url);
        
        rssReader.printFeed();
        
    }
    
}
