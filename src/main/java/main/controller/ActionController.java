package main.controller;

import main.domain.Action;
import main.domain.Comment;
import main.repository.ActionRepository;
import main.repository.CommentRepository;
import main.repository.UserRepository;
import main.service.ActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by User on 2016-06-15.
 */
@Controller
public class ActionController {

    @Autowired
    private ActionService actionService;

    @RequestMapping("/action/{type}/{user}/{comment}")
    public String userAction(@PathVariable Long type, @PathVariable String user, @PathVariable Long comment, Model model){
        return actionService.userAction(type, user, comment, model);
    }


}
