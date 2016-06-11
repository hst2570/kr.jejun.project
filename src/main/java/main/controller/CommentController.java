package main.controller;

import main.domain.User;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by user on 2016-06-10.
 */
public class CommentController {
    /*
        1. 로그인창
        2. 글 작성
     */
    @RequestMapping("/comment")
    public String comment(){
        return "comment";
    }

    @RequestMapping("/comment/write")
    public String commentWrite(){
        return "commentWrite";
    }

}
