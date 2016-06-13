package main.controller;

import main.domain.User;
import main.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by user on 2016-06-10.
 */
@Controller
public class UserContoller {
    /*
        1. 회원가입 저장
        2. 로그인
     */

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/signup")
    public String signup(){
        return "signup";
    }

    @RequestMapping("/signin")
    public String signinMain(HttpSession session){
        return "signin";
    }

    @RequestMapping(value = "/signin/check", method = RequestMethod.POST)
    public String signin(HttpSession session, HttpServletRequest request){
        List<User> user =  userRepository.findAll();
        System.out.println(request.getParameter("userId"));
        System.out.println(request.getParameter("password"));

        for(int i = 0; i < user.size(); i++){
            if(user.get(i).getUserId().equals(request.getParameter("userId"))
                    && user.get(i).getPassword().equals(request.getParameter("password"))){
                System.out.println("로그인 성공");

                session.setAttribute("getId", request.getParameter("userId"));
                session.setAttribute("login", "ok");
                return "redirect:/";
            }
        }

        session.setAttribute("login", "fail");
        return "signin";
    }
}
