package wad.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import wad.domain.Game;
import wad.domain.Guest;

@Controller
@RequestMapping("*")
public class GameController {
    
    private final Game game = new Game();

    @RequestMapping(method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("greeting", "Do you want to play a game?");
        List<String> questions = game.getQuestions();
        model.addAttribute("questions", questions);
        return "/WEB-INF/views/page.jsp";
    }
    
    @RequestMapping(value = "/game", method = RequestMethod.POST)
    public String post(HttpServletRequest request){
        for (String a1 : request.getParameterValues("answer")) {
            System.out.println(a1);
        }
        return "/WEB-INF/views/page.jsp";
    }
    

}
