package wad.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import wad.domain.Game;
import wad.domain.Guest;

@Controller
@RequestMapping("/guests")
public class GameController {
    
    private final Game game = new Game();

    @RequestMapping(method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("greeting", "Do you want to play a game?");
        List<String> questions = game.getQuestions();
        model.addAttribute("questions", questions);
        return "/WEB-INF/views/page.jsp";
    }
    
    

}
