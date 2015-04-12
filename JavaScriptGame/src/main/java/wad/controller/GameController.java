package wad.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import wad.domain.Game;
import wad.domain.Guest;
import wad.service.GameService;

@Controller
@RequestMapping("*")
public class GameController {
    
    @Autowired GameService gameService;
    
    private final Game game = new Game();

    @RequestMapping(method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("greeting", "Do you want to play a game?");
        List<String> questions = game.getQuestions();
        model.addAttribute("questions", questions);
        return "/WEB-INF/views/page.jsp";
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public String post(HttpServletRequest request, Model model){
        List<Boolean> results = gameService.checkAnswers(request.getParameterValues("answer"));
        model.addAttribute("results", results);
        return "/WEB-INF/views/results.jsp";
    }
    
    
    
    
    
    
    
    
    
        

    
    
    

}
