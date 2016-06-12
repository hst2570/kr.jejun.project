package main.controller;

import main.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public String index(){
        return "index";
    }

    @RequestMapping("/comment")
    public String comment(){
        return "comment";
    }

    @RequestMapping("/comment/write")
    public String commentWrite(){
        return "commentWrite";
    }


}
