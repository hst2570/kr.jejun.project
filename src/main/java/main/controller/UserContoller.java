package main.controller;

import main.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by user on 2016-06-10.
 */
@Controller
public class UserContoller {
    /*
        1. 회원가입 저장
        2. 로그인
     */
    @RequestMapping("/signup")
    public String signup(User user){
        return "signup";
    }

    @RequestMapping("/signin")
    public String signin(){
        return "signin";
    }
}
