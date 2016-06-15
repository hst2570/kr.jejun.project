package main.controller;

import main.repository.ActionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * Created by User on 2016-06-15.
 */
@Controller
public class ActionController {

    @Autowired
    private ActionRepository actionRepository;

    @RequestMapping("/action/{type}/{user}/{comment}")
    public String index(@PathVariable Long type, @PathVariable String user, @PathVariable Long comment){
        if(user == "0") return "redirect:/signup";



        return "redirect:/";
    }


}
