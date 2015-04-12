/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author User
 */
@Service
public class GameService {
    
    private String answer1 = "console.log";
    private String answer2 = "var name = \"Joe\"";
    private String answer3 = "var numbers = [1,2,3]";
    private ArrayList<String> answers = new ArrayList();
    
    
    public ArrayList<Boolean> checkAnswers(String [] answers) {
        
        this.answers.add(answer1);
        this.answers.add(answer2);
        this.answers.add(answer3);
        
        
        ArrayList<Boolean> results = new ArrayList();

        
        for (int i = 0; i < answers.length; i++) {
            if (answers[i].equals(this.answers.get(i))) {
                System.out.println("YEAA");
                results.add(Boolean.TRUE);
            } else {
                System.out.println("NOO");
                results.add(Boolean.FALSE);
            }        
        }
        return results;
    }
    
    
}
