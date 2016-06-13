package main.controller;

import main.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * Created by user on 2016-06-10.
 */
@Controller
public class CommentController {
    /*
        1. 로그인창
        2. 글 작성
     */
    @RequestMapping("/")
    public String index(HttpSession session){
        return "index";
    }

    @RequestMapping("/comment")
    public String comment(HttpSession session){
        return "comment";
    }

    @RequestMapping("/comment/write")
    public String commentWrite(HttpSession session){
        return "commentWrite";
    }


}
