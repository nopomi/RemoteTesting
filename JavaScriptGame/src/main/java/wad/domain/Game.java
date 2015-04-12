/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.domain;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class Game {

    ArrayList<String> questions;

    public Game() {
        this.questions = new ArrayList<>();
        setQuestions();
    }

    private void setQuestions() {
        String q1 = "What is the corresponding command for sout.print in javascript?";
        String q2 = "Create a variable called name, with a value of 'Joe'";
        String q3 = "Create an array called numbers, with values '1','2' and '3'";
        this.questions.add(q1);
        this.questions.add(q2);
        this.questions.add(q3);
    }
    
    public List<String> getQuestions() {
        return this.questions;
    }

}
