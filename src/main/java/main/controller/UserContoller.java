package main.controller;

import main.domain.User;
import main.repository.UserRepository;
import main.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
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
    private UserService userService;

    @RequestMapping("/signup")
    public String signup(){
        return "signup";
    }

    @RequestMapping("/signin")
    public String signinMain(HttpSession session){
        return "signin";
    }

    @RequestMapping("/user/mod/{id}")
    public String updateUser(@PathVariable String id, Model model){
        userService.updateUser(id, model);

        return "signup";
    }

    @RequestMapping(value = "/signin/check", method = RequestMethod.POST)
    public String signin(HttpSession session, HttpServletRequest request){
        return userService.signin(session, request);
    }

    @RequestMapping(value = "/user/add", method = RequestMethod.POST)
    public String addUser(HttpServletRequest request, @RequestParam("image") MultipartFile image) throws IOException {
        userService.addUser(request, image);
        return "redirect:/";
    }
}
